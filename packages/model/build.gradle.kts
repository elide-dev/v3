@file:Suppress("UNUSED_VARIABLE")

import java.net.URI

val jakartaVersion = project.properties["versions.jakarta-inject"] as String
val protobufVersion = project.properties["versions.protobuf"] as String
val javaLanguageVersion = project.properties["versions.java.language"] as String
val kotlinLanguageVersion = project.properties["versions.kotlin.language"] as String
val grpcVersion = project.properties["versions.grpc"] as String
val kotlinxCoroutinesVersion = project.properties["versions.kotlinx.coroutines"] as String
val kotlinxSerializationVersion = project.properties["versions.kotlinx.serialization"] as String
val junitJupiterVersion =  project.properties["versions.junit.jupiter"] as String
val logbackVersion = project.properties["versions.logback"] as String

plugins {
  `maven-publish`
  signing
  kotlin("multiplatform")
  kotlin("plugin.atomicfu")
  kotlin("plugin.serialization")
  id("org.jetbrains.dokka")
  id("org.sonarqube")
}

group = "dev.elide"

repositories {
  google()
  mavenCentral()
  maven("https://maven-central.storage-download.googleapis.com/maven2/")
  maven(project.properties["elide.publish.repo.maven"] as String)
}

val javadocJar by tasks.registering(Jar::class) {
  archiveClassifier.set("javadoc")
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
    artifact(javadocJar.get())
    pom {
      name.set("Elide Models")
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

kotlin {
  jvm {
    compilations.all {
      kotlinOptions {
        apiVersion = kotlinLanguageVersion
        languageVersion = kotlinLanguageVersion
      }
    }
    withJava()
    testRuns["test"].executionTask.configure {
      useJUnitPlatform()
    }
  }
  js(BOTH) {
    browser {
      commonWebpackConfig {
        cssSupport.enabled = true
      }
    }
  }

  publishing {
    publications {}
  }

  val hostOs = System.getProperty("os.name")
  val isMingwX64 = hostOs.startsWith("Windows")
  val nativeTarget = when {
    hostOs == "Mac OS X" -> macosX64("native")
    hostOs == "Linux" -> linuxX64("native")
    isMingwX64 -> mingwX64("native")
    else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
  }

  sourceSets {
    val commonMain by getting {
      dependencies {
        implementation(kotlin("stdlib-common"))
        implementation(project(":packages:base"))
      }
    }
    val commonTest by getting {
      dependencies {
        implementation(kotlin("test"))
      }
    }
    val jvmMain by getting {
      dependencies {
        implementation(project(":packages:server"))
        implementation("jakarta.inject:jakarta.inject-api:$jakartaVersion")
        implementation("com.google.protobuf:protobuf-java:$protobufVersion")
        implementation("com.google.protobuf:protobuf-java-util:$protobufVersion")
        implementation("com.google.protobuf:protobuf-kotlin:$protobufVersion")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:$kotlinxSerializationVersion")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-protobuf-jvm:$kotlinxSerializationVersion")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:$kotlinxCoroutinesVersion")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$kotlinxCoroutinesVersion")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk9:$kotlinxCoroutinesVersion")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-guava:$kotlinxCoroutinesVersion")
        implementation("com.google.truth:truth:${Versions.truth}")
        implementation("com.google.truth.extensions:truth-proto-extension:${Versions.truth}")
        implementation(kotlin("test-junit5"))

        runtimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
        runtimeOnly("ch.qos.logback:logback-classic:$logbackVersion")
      }
    }
    val jvmTest by getting
    val jsMain by getting {
      dependencies {
        implementation(kotlin("stdlib-js"))
        implementation(project(":packages:frontend"))
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:$kotlinxCoroutinesVersion")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-js:$kotlinxSerializationVersion")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-protobuf-js:$kotlinxSerializationVersion")
      }
    }
    val jsTest by getting
    val nativeMain by getting
    val nativeTest by getting
  }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompileCommon>().configureEach {
  kotlinOptions {
    apiVersion = kotlinLanguageVersion
    languageVersion = kotlinLanguageVersion
  }
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
  kotlinOptions {
    apiVersion = kotlinLanguageVersion
    languageVersion = kotlinLanguageVersion
    jvmTarget = javaLanguageVersion
    javaParameters = true
  }
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile>().configureEach {
  kotlinOptions {
    apiVersion = kotlinLanguageVersion
    languageVersion = kotlinLanguageVersion
  }
}