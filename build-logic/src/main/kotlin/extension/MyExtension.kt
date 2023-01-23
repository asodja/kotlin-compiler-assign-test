package extension

import org.gradle.api.provider.Property

interface MyExtension {
    val property: Property<String>
}
