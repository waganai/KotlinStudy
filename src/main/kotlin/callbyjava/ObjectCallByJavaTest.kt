package callbyjava

import java.util.*

object ObjectCallByJavaTest {
    var name = "name"

    @JvmField
    var name1 = "name1"
    lateinit var birtDate: Date

    fun function1() {
        println("ObjectCallByJavaTest.function1()")
    }
}