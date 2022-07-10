package elide.server.assets

import com.google.common.graph.ElementOrder
import com.google.common.graph.ImmutableNetwork
import com.google.common.graph.NetworkBuilder
import com.google.common.truth.extensions.proto.ProtoTruth.assertThat
import com.google.common.util.concurrent.ListeningExecutorService
import com.google.common.util.concurrent.MoreExecutors
import elide.server.AssetModuleId
import elide.server.TestUtil
import elide.server.runtime.AppExecutor
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import tools.elide.assets.AssetBundle
import tools.elide.assets.AssetBundle.AssetContent
import tools.elide.assets.AssetBundle.AssetDependencies
import tools.elide.assets.AssetBundle.GenericBundle
import tools.elide.assets.AssetBundle.ScriptBundle
import tools.elide.assets.AssetBundle.StyleBundle
import tools.elide.assets.ManifestFormat
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

/** Tests for [ServerAssetIndex]. */
@Suppress("UnstableApiUsage")
@MicronautTest
class ServerAssetIndexTest {
  private fun loadSampleManifest(): AssetBundle {
    val data = TestUtil.loadBinary("/manifests/app.assets.pb")
    val baos = ByteArrayInputStream(data)
    val provider = ServerAssetManifestProvider()
    return provider.deserializeLoadManifest(
      ManifestFormat.BINARY to baos,
    ) ?: error("Failed to load embedded sample manifest")
  }

  private fun createIndexer(assetBundle: AssetBundle? = null): Pair<AssetBundle, ServerAssetIndex> {
    val sample = assetBundle ?: assertNotNull(loadSampleManifest())
    val exec = object : AppExecutor {
      override fun service(): ListeningExecutorService {
        return MoreExecutors.listeningDecorator(
          Executors.newSingleThreadExecutor()
        )
      }
    }
    return sample to ServerAssetIndex(
      exec,
      object : AssetManifestLoader {
        override fun findLoadManifest(candidates: List<Pair<ManifestFormat, String>>): AssetBundle? {
          return sample
        }

        override fun findManifest(candidates: List<Pair<ManifestFormat, String>>): Pair<ManifestFormat, InputStream>? {
          return ManifestFormat.BINARY to ByteArrayInputStream(ByteArray(0))
        }
      }
    )
  }

  @Test fun testGenerateIndexes() {
    val (sample, indexer) = createIndexer()
    val indexes = assertDoesNotThrow {
      indexer.buildAssetIndexes(
        sample
      )
    }
    assertNotNull(indexes, "should not get `null` from `buildAssetIndexes`")
    val (depGraph, manifest) = indexes
    assertNotNull(depGraph, "should not get `null` for first item in interpreted asset manifest pair")
    assertNotNull(manifest, "should not get `null` for second item in interpreted asset manifest pair")
    assertTrue(depGraph.nodes().isNotEmpty(), "nodes list in dep graph should not be empty")
  }

  @Test fun testGenerateFailDuplicateTags() {
    val bundle = AssetBundle.newBuilder()
    bundle.addAsset(AssetContent.newBuilder().setModule("test1"))
    bundle.addAsset(AssetContent.newBuilder().setModule("test2"))
    bundle.addAsset(AssetContent.newBuilder().setModule("test1"))
    bundle.putScripts("test1", ScriptBundle.newBuilder().setModule("test1").build())
    bundle.putScripts("test2", ScriptBundle.newBuilder().setModule("test2").build())
    val (_, indexer) = createIndexer(bundle.build())
    assertThrows<IllegalStateException> {
      indexer.buildAssetIndexes(bundle.build())
    }
  }

  @Test fun testGenerateFailDuplicateModuleIds() {
    val bundle = AssetBundle.newBuilder()
    bundle.addAsset(AssetContent.newBuilder().setModule("test1"))
    bundle.addAsset(AssetContent.newBuilder().setModule("test2"))
    bundle.putScripts("test1", ScriptBundle.newBuilder().setModule("test1").build())
    bundle.putScripts("test2", ScriptBundle.newBuilder().setModule("test2").build())
    bundle.putStyles("test1", StyleBundle.newBuilder().setModule("test1").build())
    val (_, indexer) = createIndexer(bundle.build())
    assertThrows<IllegalStateException> {
      indexer.buildAssetIndexes(bundle.build())
    }
  }

  @Test fun testGenerateWithScriptDeps() {
    val bundle = AssetBundle.newBuilder()
    bundle.addAsset(AssetContent.newBuilder().setModule("test1"))
    bundle.addAsset(AssetContent.newBuilder().setModule("test2"))
    bundle.putScripts("test1", ScriptBundle.newBuilder().setModule("test1").build())
    bundle.putScripts(
      "test2",
      ScriptBundle
        .newBuilder()
        .setModule("test2")
        .setDependencies(
          AssetDependencies.newBuilder()
            .addDirect("test1")
        )
        .build()
    )
    val (_, indexer) = createIndexer(bundle.build())
    val indexes = assertDoesNotThrow {
      indexer.buildAssetIndexes(
        bundle.build()
      )
    }
    assertNotNull(indexes)
    val (depGraph, manifest) = indexes
    assertNotNull(depGraph)
    assertNotNull(manifest)
    assertTrue(depGraph.nodes().isNotEmpty())
    assertTrue(depGraph.nodes().contains("test1"))
    assertTrue(depGraph.nodes().contains("test2"))
    assertTrue(depGraph.edges().isNotEmpty())
    assertTrue(
      depGraph.edges().contains(
        AssetDependency(
          depender = "test2",
          dependee = "test1",
          optional = false,
        )
      )
    )
    assertTrue(
      depGraph.hasEdgeConnecting("test2", "test1")
    )
    assertTrue(
      depGraph.adjacentNodes("test2").contains("test1")
    )
    assertTrue(
      depGraph.outEdges("test2").isNotEmpty()
    )
    assertTrue(
      depGraph.outEdges("test2").contains(
        AssetDependency(
          depender = "test2",
          dependee = "test1",
          optional = false,
        )
      )
    )
    assertTrue(
      depGraph.inEdges("test1").contains(
        AssetDependency(
          depender = "test2",
          dependee = "test1",
          optional = false,
        )
      )
    )
  }

  @Test fun testGenerateWithStyleDeps() {
    val bundle = AssetBundle.newBuilder()
    bundle.addAsset(AssetContent.newBuilder().setModule("test1"))
    bundle.addAsset(AssetContent.newBuilder().setModule("test2"))
    bundle.putStyles("test1", StyleBundle.newBuilder().setModule("test1").build())
    bundle.putStyles(
      "test2",
      StyleBundle
        .newBuilder()
        .setModule("test2")
        .setDependencies(
          AssetDependencies.newBuilder()
            .addDirect("test1")
        )
        .build()
    )
    val (_, indexer) = createIndexer(bundle.build())
    val indexes = assertDoesNotThrow {
      indexer.buildAssetIndexes(
        bundle.build()
      )
    }
    assertNotNull(indexes)
    val (depGraph, manifest) = indexes
    assertNotNull(depGraph)
    assertNotNull(manifest)
    assertTrue(depGraph.nodes().isNotEmpty())
    assertTrue(depGraph.nodes().contains("test1"))
    assertTrue(depGraph.nodes().contains("test2"))
    assertTrue(depGraph.edges().isNotEmpty())
    assertTrue(
      depGraph.edges().contains(
        AssetDependency(
          depender = "test2",
          dependee = "test1",
          optional = false,
        )
      )
    )
    assertTrue(
      depGraph.hasEdgeConnecting("test2", "test1")
    )
    assertTrue(
      depGraph.adjacentNodes("test2").contains("test1")
    )
    assertTrue(
      depGraph.outEdges("test2").isNotEmpty()
    )
    assertTrue(
      depGraph.outEdges("test2").contains(
        AssetDependency(
          depender = "test2",
          dependee = "test1",
          optional = false,
        )
      )
    )
    assertTrue(
      depGraph.inEdges("test1").contains(
        AssetDependency(
          depender = "test2",
          dependee = "test1",
          optional = false,
        )
      )
    )
  }

  @Test fun testGenerateIndexesTextAssets() {
    val bundle = AssetBundle.newBuilder()
    bundle.addAsset(AssetContent.newBuilder().setModule("test1"))
    bundle.putGeneric("test1", GenericBundle.newBuilder().setModule("test1").build())
    val (_, indexer) = createIndexer(bundle.build())
    val indexes = assertDoesNotThrow {
      indexer.buildAssetIndexes(
        bundle.build()
      )
    }
    assertNotNull(indexes)
    val (depGraph, manifest) = indexes
    assertNotNull(depGraph)
    assertNotNull(manifest)
    assertTrue(manifest.moduleIndex.contains("test1"))
  }

  @Test fun testFailCompletelyGenericAsset() {
    val bundle = AssetBundle.newBuilder().build()
    val (_, indexer) = createIndexer(bundle)
    val builder: ImmutableNetwork.Builder<AssetModuleId, AssetDependency> = NetworkBuilder
      .directed()
      .allowsParallelEdges(false)
      .allowsSelfLoops(false)
      .nodeOrder(ElementOrder.stable<AssetModuleId>())
      .edgeOrder(ElementOrder.stable<AssetDependency>())
      .immutable()

    assertThrows<IllegalStateException> {
      indexer.pointerForConcrete(
        AssetType.GENERIC,
        "some-module",
        5,
        bundle,
        builder,
      )
    }
  }

  @Test fun testAssetIndexBoot() {
    val (sample, indexer) = createIndexer()
    assertNotNull(sample)
    assertNotNull(indexer)
    assertDoesNotThrow {
      indexer.initialize()
    }
    assertTrue(indexer.initialized.get())
    assertNotNull(indexer.assetManifest.get())
    assertNotNull(indexer.dependencyGraph.get())
  }

  @Test fun testAssetIndexerInitializeTwiceDoesNotThrow() {
    val (sample, indexer) = createIndexer()
    assertNotNull(sample)
    assertNotNull(indexer)
    assertDoesNotThrow {
      indexer.initialize()
    }
    assertDoesNotThrow {
      indexer.initialize()
    }
  }

  @Test fun testAssetIndexerDoesNotInitializeMoreThanOnce() {
    val firstCall = AtomicBoolean(true)
    val exec = object : AppExecutor {
      override fun service(): ListeningExecutorService {
        return MoreExecutors.listeningDecorator(
          Executors.newSingleThreadExecutor()
        )
      }
    }
    val indexer = ServerAssetIndex(
      exec,
      object : AssetManifestLoader {
        override fun findLoadManifest(candidates: List<Pair<ManifestFormat, String>>): AssetBundle? {
          if (firstCall.get()) {
            return null
          } else {
            throw IllegalStateException("FAIL")
          }
        }

        override fun findManifest(candidates: List<Pair<ManifestFormat, String>>): Pair<ManifestFormat, InputStream>? {
          if (firstCall.get()) {
            return null
          } else {
            throw IllegalStateException("FAIL")
          }
        }
      }
    )
    assertNotNull(indexer)
    assertDoesNotThrow {
      indexer.initialize()
    }
    assertDoesNotThrow {
      indexer.initialize()
    }
  }

  @Test fun testAssetIndexBootNoManifest() {
    val exec = object : AppExecutor {
      override fun service(): ListeningExecutorService {
        return MoreExecutors.listeningDecorator(
          Executors.newSingleThreadExecutor()
        )
      }
    }
    val indexer = ServerAssetIndex(
      exec,
      object : AssetManifestLoader {
        override fun findLoadManifest(candidates: List<Pair<ManifestFormat, String>>): AssetBundle? {
          return null
        }

        override fun findManifest(candidates: List<Pair<ManifestFormat, String>>): Pair<ManifestFormat, InputStream>? {
          return null
        }
      }
    )

    assertDoesNotThrow {
      indexer.initialize()
    }
    assertTrue(indexer.initialized.get())
    assertNull(indexer.assetManifest.get())
    assertNull(indexer.dependencyGraph.get())
  }

  @Test fun testInterpretedManifest() {
    val (sample, indexer) = createIndexer()
    assertDoesNotThrow {
      indexer.initialize()
    }
    val manifest = indexer.assetManifest.get()
    assertNotNull(manifest)
    assertNotNull(manifest.bundle)
    assertNotNull(manifest.moduleIndex)
    assertNotNull(manifest.tagIndex)
    assertTrue(manifest.bundle.isInitialized)
    assertTrue(manifest.moduleIndex.isNotEmpty())
    assertTrue(manifest.tagIndex.isNotEmpty())
    assertThat(sample).isEqualTo(manifest.bundle)
  }
}