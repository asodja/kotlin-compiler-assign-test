rootProject.name = "kotlin-compiler-test"
include("app")

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
    plugins {
        val kotlinCompilerVersion = "1.8.0-dev-2494"
        kotlin("jvm") version kotlinCompilerVersion
        id("org.jetbrains.kotlin.plugin.value.container.assignment") version kotlinCompilerVersion
    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

for (project in rootProject.children) {
    project.projectDir = file("projects/${project.name}")
}
