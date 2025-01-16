pluginManagement {
    plugins {
        id("xyz.jpenilla.run-paper").version("2.3.1")
        id("com.github.johnrengelman.shadow").version("7.1.2")
    }

    repositories {
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
}

rootProject.name = "${extra["PROJECT_NAME"]}"