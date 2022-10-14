@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("test")
    kotlin("jvm")
    kotlin("plugin.sam.with.receiver")
    kotlin("plugin.assignment")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}

assignment {
    annotation("test.compiler.SupportsAssign")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
abstract class MyTask : DefaultTask() {
    @get:Input
    abstract val input: Property<String>
    @get:OutputDirectory
    abstract val output: RegularFileProperty
    @TaskAction
    fun taskAction() {
        output.asFile.get().writeText(input.get())
    }
}

tasks.register<MyTask>("myTask") {
    input = "Hello world3"
    output = File("$buildDir/myTask/hello-world.txt")
}