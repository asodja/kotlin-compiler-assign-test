package test.compiler

operator fun <T> Property<T>.assign(value: T) {
    set(value)
}

operator fun <T> Property<T>.assign(value: Property<T>) {
    set(value.get())
}