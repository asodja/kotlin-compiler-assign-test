package test.compiler


data class JavaCompile(
    val sourceCompatibility: Property<String> = Property("Undefined"),
    val targetCompatibility: Property<String> = Property("Undefined"),
)