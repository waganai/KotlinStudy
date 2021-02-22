package annotations

import annotations.customannotation.KotlinCustomClassAnnotationTest
import annotations.customannotation.KotlinCustomFunctionAnnotationTest
import annotations.customannotation.KotlinCustomPropertiesAnnotationTest

@KotlinCustomClassAnnotationTest(name = "KotlinAnnotationTestClass")
class KotlinAnnotationTestClass {
    @KotlinCustomPropertiesAnnotationTest(name = "name", type = String::class)
    var name = "name1"

    @KotlinCustomPropertiesAnnotationTest(name = "id", type = Int::class)
    var id = 233

    @KotlinCustomFunctionAnnotationTest(name = "function1", parametersCount = 2)
    fun function1(arg1: String, arg2: Int) {
        println("function1($arg1, $arg2)")
    }
}