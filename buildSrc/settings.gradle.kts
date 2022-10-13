pluginManagement {
    repositories {
        mavenLocal()
        maven {
            name = "Kotlin dev artifacts"
            url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/bootstrap")
        }
        gradlePluginPortal()
    }
    plugins {
        val kotlinCompilerVersion = "1.8.20-dev-649"
        kotlin("jvm") version kotlinCompilerVersion
        kotlin("plugin.sam.with.receiver") version kotlinCompilerVersion
        kotlin("plugin.assignment") version kotlinCompilerVersion
    }
}