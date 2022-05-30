package test.compiler

data class Property<T>(private var value: T) {
    fun get() = value
    fun set(value: T) {
        this.value = value
    }
}