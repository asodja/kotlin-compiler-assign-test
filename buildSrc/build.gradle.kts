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

afterEvaluate {
    kotlinDslPluginOptions {
        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
            kotlinOptions {
                jvmTarget = this@kotlinDslPluginOptions.jvmTarget.get()
                apiVersion = "1.7"
                languageVersion = "1.7"
                freeCompilerArgs += (org.gradle.kotlin.dsl.provider.KotlinDslPluginSupport.kotlinCompilerArgs + "-Xuse-ir")
            }
        }
    }
}