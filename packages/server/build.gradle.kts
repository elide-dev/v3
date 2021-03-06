@file:Suppress(
  "UnstableApiUsage",
  "unused",
  "UNUSED_VARIABLE",
  "DSL_SCOPE_VIOLATION",
)

import java.net.URI

plugins {
  java
  jacoco
  idea
  `maven-publish`
  signing
  kotlin("jvm")
  kotlin("kapt")
  kotlin("plugin.allopen")
  kotlin("plugin.serialization")
  alias(libs.plugins.kotlinx.plugin.atomicfu)
  alias(libs.plugins.testLogger)
  alias(libs.plugins.micronautLibrary)
  alias(libs.plugins.dokka)
}

group = "dev.elide"
version = rootProject.version as String

kotlin {
  explicitApi()

  jvmToolchain {
    languageVersion.set(JavaLanguageVersion.of((project.properties["versions.java.language"] as String)))
  }
  publishing {
    publications {
      create<MavenPublication>("main") {
        groupId = "dev.elide"
        artifactId = "server"
        version = rootProject.version as String

        from(components["kotlin"])
      }
    }
  }
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of((project.properties["versions.java.language"] as String)))
  }
}

signing {
  if (project.hasProperty("enableSigning") && project.properties["enableSigning"] == "true") {
    sign(configurations.archives.get())
    sign(publishing.publications)
  }
}

publishing {
  repositories {
    maven {
      name = "elide"
      url = URI.create(project.properties["elide.publish.repo.maven"] as String)

      if (project.hasProperty("elide.publish.repo.maven.auth")) {
          credentials {
              username = (project.properties["elide.publish.repo.maven.username"] as? String
                  ?: System.getenv("PUBLISH_USER"))?.ifBlank { null }
              password = (project.properties["elide.publish.repo.maven.password"] as? String
                  ?: System.getenv("PUBLISH_TOKEN"))?.ifBlank { null }
          }
      }
    }
  }

  publications.withType<MavenPublication> {
    pom {
      name.set("Elide")
      description.set("Polyglot application framework")
      url.set("https://github.com/elide-dev/v3")

      licenses {
        license {
          name.set("Properity License")
          url.set("https://github.com/elide-dev/v3/blob/v3/LICENSE")
        }
      }
      developers {
        developer {
          id.set("sgammon")
          name.set("Sam Gammon")
          email.set("samuel.gammon@gmail.com")
        }
      }
      scm {
        url.set("https://github.com/elide-dev/v3")
      }
    }
  }
}

testing {
  suites {
    val test by getting(JvmTestSuite::class) {
      useJUnitJupiter()
    }
  }
}

tasks {
  val javadocJar by creating(Jar::class) {
    dependsOn(":packages:server:dokkaJavadoc")
    classifier = "javadoc"
    from(named("dokkaJavadoc"))
  }

  val sourcesJar by creating(Jar::class) {
    dependsOn(JavaPlugin.CLASSES_TASK_NAME)
    classifier = "sources"
    from(sourceSets["main"].allSource)
  }

  artifacts {
    add("archives", sourcesJar)
    add("archives", javadocJar)
  }
}

tasks.jacocoTestReport {
  dependsOn(tasks.test)
  reports {
    xml.required.set(true)
  }
  classDirectories.setFrom(
    files(classDirectories.files.map {
      fileTree(it) {
        exclude(
          "**/generated/**",
          "**/com/**",
          "**/grpc/gateway/**",
          "**/tools/elide/**",
        )
      }
    })
  )
}

micronaut {
  version.set(libs.versions.micronaut.lib.get())
  processing {
    incremental.set(true)
    annotations.addAll(listOf(
      "elide.server",
      "elide.server.*",
      "elide.server.annotations",
      "elide.server.annotations.*",
    ))
  }
}

dependencies {
  // API Deps
  api(libs.jakarta.inject)
  api(libs.slf4j)
  api(platform(libs.grpc.bom))
  api(platform(libs.netty.bom))
  api(platform(libs.projectreactor.bom))

  // Modules
  kapt(libs.micronaut.inject)
  kapt(libs.micronaut.inject.java)
  implementation(project(":packages:base"))
  implementation(project(":packages:proto"))

  // Crypto
  implementation(libs.bouncycastle)
  implementation(libs.bouncycastle.pkix)
  implementation(libs.conscrypt)
  implementation(libs.tink)

  // Reactive Java
  implementation(libs.reactor.core)
  implementation(libs.reactor.netty.core)
  implementation(libs.reactor.netty.http)

  // Kotlin
  implementation(libs.kotlinx.html.jvm)
  implementation(libs.kotlinx.serialization.core.jvm)
  implementation(libs.kotlinx.serialization.json.jvm)
  implementation(libs.kotlinx.serialization.protobuf.jvm)

  // Kotlin Wrappers
  implementation(libs.kotlinx.wrappers.css)

  // Protocol Buffers
  implementation(libs.protobuf.java)
  implementation(libs.protobuf.util)
  implementation(libs.protobuf.kotlin)

  // Brotli
  implementation(libs.brotli)
  implementation(libs.brotli.native.osx)
  implementation(libs.brotli.native.linux)
  implementation(libs.brotli.native.windows)

  // Google
  implementation(libs.grpc.core)
  implementation(libs.grpc.api)
  implementation(libs.grpc.auth)
  implementation(libs.grpc.stub)
  implementation(libs.grpc.services)
  implementation(libs.grpc.netty)
  implementation(libs.grpc.protobuf)
  implementation(libs.grpc.kotlin.stub)
  implementation(libs.guava)
  implementation(libs.gax.java)
  implementation(libs.gax.java.grpc)
  implementation(libs.google.api.common)

  // Micronaut
  implementation(libs.micronaut.http)
  implementation(libs.micronaut.http.server)
  implementation(libs.micronaut.http.server.netty)
  implementation(libs.micronaut.context)
  implementation(libs.micronaut.inject)
  implementation(libs.micronaut.inject.java)
  implementation(libs.micronaut.protobuf)
  implementation(libs.micronaut.grpc.runtime)
  implementation(libs.micronaut.grpc.client.runtime)
  implementation(libs.micronaut.grpc.server.runtime)
  implementation(libs.micronaut.management)
  implementation(libs.micronaut.views.core)

  // Netty: Native
  implementation(libs.netty.tcnative)
  implementation(libs.netty.tcnative.boringssl.static)
  implementation(libs.netty.transport.native.unixCommon)
  implementation(libs.netty.transport.native.epoll)
  implementation(libs.netty.transport.native.kqueue)

  // Coroutines
  implementation(libs.kotlinx.coroutines.core)
  implementation(libs.kotlinx.coroutines.core.jvm)
  implementation(libs.kotlinx.coroutines.jdk8)
  implementation(libs.kotlinx.coroutines.jdk9)
  implementation(libs.kotlinx.coroutines.slf4j)
  implementation(libs.kotlinx.coroutines.guava)
  implementation(libs.kotlinx.coroutines.reactive)

  // General
  implementation(libs.reactivestreams)
  implementation(libs.google.common.html.types.types)

  // Testing
  kaptTest(libs.micronaut.inject)
  kaptTest(libs.micronaut.inject.java)
  testImplementation(libs.truth)
  testImplementation(libs.truth.java8)
  testImplementation(libs.truth.proto)
  testImplementation(libs.micronaut.test.junit5)
  testImplementation(kotlin("test"))
  testImplementation(project(":packages:test"))
}
