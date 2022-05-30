rootProject.name = "kotlin-compiler-test"
include("app")

pluginManagement {
    repositories {
        maven {
            url = uri("https://repo.grdev.net/artifactory/ext-snapshots-local")
        }
        gradlePluginPortal()
    }
    plugins {
        kotlin("jvm") version ("1.7.255-SNAPSHOT")
    }
}

dependencyResolutionManagement {
    repositories {
        maven {
            url = uri("https://repo.grdev.net/artifactory/ext-snapshots-local")
        }
        mavenCentral()
    }
}

for (project in rootProject.children) {
    project.projectDir = file("projects/${project.name}")
}
