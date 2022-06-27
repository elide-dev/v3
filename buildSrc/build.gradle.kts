val kotlinVersion = "1.7.0"
val micronautPluginVersion = "3.4.1"
val atomicFuPluginVersion = "0.18.0"
val dockerPluginVersion = "7.4.0"
val nodePluginVersion = "3.3.0"
val gauthPlugin = "2.1.5"
val kotestVersion = "5.3.1"
val protobufPluginVersion = "0.8.18"

plugins {
  `kotlin-dsl`
}

repositories {
  gradlePluginPortal()
}

dependencies {
  api(kotlin("gradle-plugin"))
  api("com.github.node-gradle:gradle-node-plugin:$nodePluginVersion")
  implementation("com.bmuschko:gradle-docker-plugin:$dockerPluginVersion")
  implementation("gradle.plugin.com.google.cloud.artifactregistry:artifactregistry-gradle-plugin:$gauthPlugin")
  implementation("gradle.plugin.com.google.protobuf:protobuf-gradle-plugin:$protobufPluginVersion")
  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
  implementation("org.jetbrains.kotlinx:atomicfu-gradle-plugin:$atomicFuPluginVersion")
  implementation("io.micronaut.gradle:micronaut-gradle-plugin:$micronautPluginVersion")
}
