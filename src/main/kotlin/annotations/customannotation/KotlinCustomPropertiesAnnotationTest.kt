package annotations.customannotation

import kotlin.reflect.KClass

@Target(
    AnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY
)
@Retention(AnnotationRetention.RUNTIME)
annotation class KotlinCustomPropertiesAnnotationTest(val name: String, val type: KClass<*>)
