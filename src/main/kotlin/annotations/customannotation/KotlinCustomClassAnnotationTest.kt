package annotations.customannotation

@Target(
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.CLASS
)
@Retention(AnnotationRetention.RUNTIME)
annotation class KotlinCustomClassAnnotationTest(val name: String = "Any?")
