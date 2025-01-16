@file:Suppress("SpellCheckingInspection")

import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    id("java")
    id("java-library")
    id("xyz.jpenilla.run-paper")
    id("com.github.johnrengelman.shadow")
}

group = "${properties["PROJECT_GROUP"]}"
version = "${properties["PROJECT_VERSION"]}"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://libraries.minecraft.net/")
    maven("https://repo.repsy.io/mvn/lone64/releases/")
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
    runServer {
        minecraftVersion("1.20.4")
        downloadPlugins.url("https://github.com/devlone64/MCFramework/releases/download/1.0.0/mcframework-bukkit-1.0.0-release.jar")
    }

    shadowJar {
        archiveFileName.set("${project.name}-${project.version}-release.jar")
    }

    withType<ProcessResources> {
        from("src/main/resources") {
            include("plugin.yml")
            filter<ReplaceTokens>("tokens" to mapOf("version" to project.version))
            duplicatesStrategy = DuplicatesStrategy.INCLUDE
        }
    }
}