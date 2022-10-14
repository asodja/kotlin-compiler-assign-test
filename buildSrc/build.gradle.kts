buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin-api:1.8.20-dev-649!!")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.20-dev-649!!")
        classpath("org.jetbrains.kotlin:kotlin-sam-with-receiver:1.8.20-dev-649!!")
    }
}

plugins {
    `kotlin-dsl`
    kotlin("plugin.assignment")
}

repositories {
    maven {
        name = "Kotlin dev artifacts"
        url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/bootstrap")
    }
    mavenCentral()
}

assignment {
    annotation(SupportsKotlinAssignmentOverloading::class.qualifiedName!!)
}
