package extension

import org.gradle.kotlin.dsl.assign

class MyPlugin(val myExtension: MyExtension) {
    fun test() {
        myExtension.property = "hello"
    }
}