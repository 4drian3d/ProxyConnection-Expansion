enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "ProxyConnection-Expansion"

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://central.sonatype.com/repository/maven-snapshots/")
        maven("https://repo.spongepowered.org/repository/maven-public/")
        maven("https://api.modrinth.com/maven") {
            content {
                includeGroup("maven.modrinth")
            }
        }
    }
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.fabricmc.net/")
        maven("https://maven.quiltmc.org/repository/release/")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
    id("fabric-loom") version "1.11.7"
}

arrayOf("common", "paper", "sponge", "fabric").forEach {
    include("proxyconnection-expansion-$it")

    project(":proxyconnection-expansion-$it").projectDir = file(it)
}
