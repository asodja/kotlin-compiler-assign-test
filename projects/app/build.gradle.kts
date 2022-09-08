import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    id("org.jetbrains.kotlin.plugin.value.container.assignment")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}

valueContainerAssignment {
    annotation("test.compiler.SupportsAssign")
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.useK2 = false
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}