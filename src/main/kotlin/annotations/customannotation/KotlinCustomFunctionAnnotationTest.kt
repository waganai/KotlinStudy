package annotations.customannotation

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class KotlinCustomFunctionAnnotationTest(val name: String, val parametersCount: Int = 0)
