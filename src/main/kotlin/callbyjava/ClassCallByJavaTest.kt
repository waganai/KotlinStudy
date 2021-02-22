package callbyjava

import java.util.*

class ClassCallByJavaTest {
    var name = "name"

    // 注意 @JvmField 注解的作用
    @JvmField
    var name1 = "name1"
    lateinit var birthDate: Date

    fun function1() {
        println("ClassCallByJavaTest.function1()")
    }
}