import org.gradle.kotlin.dsl.support.serviceOf

rootProject.name = "kotlin-compiler-test"
include("app")

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

dependencyResolutionManagement {
    repositories {
        maven {
            name = "Kotlin dev artifacts"
            url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/bootstrap")
        }
        mavenCentral()
    }
}

data class Container(val property: Property<String>)
val container = Container(gradle.serviceOf<ObjectFactory>().property(String::class.java)).apply {
    property = "Hello world"
}
println("Settings.gradle.kts: ${container.property.get()}")

for (project in rootProject.children) {
    project.projectDir = file("projects/${project.name}")
}
