import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    // Options is Java type
    options.incrementalAfterFailure.set(false) // Go to declaration works
    options.incrementalAfterFailure = false // Go to declaration doesn't work
}

tasks.withType<KotlinCompile> {
    // CompilerOptions is Kotlin type
    compilerOptions.noJdk.set(false) // Go to declaration works
    compilerOptions.noJdk = false // Go to declaration works
}

java.docsDir.set(file("src/docs")) // no error
java.docsDir = file("src/docs") // an error, but should not be
java {
    docsDir = file("src/docs") // no error
}
