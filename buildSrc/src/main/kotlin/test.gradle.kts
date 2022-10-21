plugins {
    `java`
}


abstract class SomeTask : DefaultTask() {
    @get:Input abstract val value: Property<String>
}

tasks.register<SomeTask>("some") {
    value = "Hello"
    doLast {
        println("Hello: ${value.get()}")
    }
}
