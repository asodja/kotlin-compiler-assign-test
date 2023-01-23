package extension

// Unused import
import org.gradle.kotlin.dsl.assign

class MyPlugin(private val myExtension: MyExtension) {
    fun test() {
        myExtension.property = "hello"
    }
}