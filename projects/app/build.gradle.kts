@file:Suppress("UnstableApiUsage")

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