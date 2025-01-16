@file:Suppress("SpellCheckingInspection")

import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    id("java")
    id("java-library")
    id("com.github.johnrengelman.shadow")
}

group = "io.gitlab.lone64.template"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://libraries.minecraft.net/")
    maven("https://maven.lone64.dev/releases/")
    maven("https://repo.codemc.io/repository/maven-snapshots/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.32")
    compileOnly("io.gitlab.lone64:mcframework-api:1.0.0")
    compileOnly("org.spigotmc:spigot-api:1.20.4-R0.1-SNAPSHOT")

    // Annotation Processors
    annotationProcessor("org.projectlombok:lombok:1.18.32")
}

tasks {
    shadowJar {
        archiveFileName.set("template-${project.version}.jar")
    }

    withType<ProcessResources> {
        from("src/main/resources") {
            include("plugin.yml")
            filter<ReplaceTokens>("tokens" to mapOf("version" to project.version))
            duplicatesStrategy = DuplicatesStrategy.INCLUDE
        }
    }
}