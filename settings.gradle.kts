pluginManagement {
    plugins {
        id("com.github.johnrengelman.shadow").version("7.1.2")
    }

    repositories {
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
}

rootProject.name = "${extra["PROJECT_NAME"]}"