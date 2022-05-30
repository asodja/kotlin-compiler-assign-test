package test.compiler

data class CompileTask(
    val sourceCompatibility: Property<String> = Property("Undefined"),
    val targetCompatibility: Property<String> = Property("Undefined"),
)