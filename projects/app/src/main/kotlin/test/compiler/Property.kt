package test.compiler

@SupportsAssign
data class Property<T>(private var value: T) {
    fun get() = value
    fun set(value: T) {
        this.value = value
    }
    fun set(value: Property<T>) {
        this.value = value.get()
    }
}

fun <T> Property<T>.assign(v: T) {
    this.set(v)
}

fun <T> Property<T>.assign(v: Property<T>) {
    this.set(v)
}

fun main() {
    val javaCompile = JavaCompile()
    javaCompile.sourceCompatibility = "5"
    javaCompile.apply {
        sourceCompatibility = "42"
    }
}