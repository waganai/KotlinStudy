package callbyjava

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class ClassCallByJavaTest {
    companion object {
        var id = 233

        @JvmField
        public var id1 = 666
        lateinit var birthDate2: Date

        fun function2() {
            println("ClassCallByJavaTest.companion.function2()")
        }
    }

    var name = "name"

    // 注意 @JvmField 注解的作用
    @JvmField
    var name1 = "name1"
    lateinit var birthDate: Date

    fun function1() {
        println("ClassCallByJavaTest.function1()")
    }

    @Throws(ParseException::class)
    fun functionException() {
        val str = "202A-2-12"
        val df = SimpleDateFormat("yyyy-MM-dd")
        println("${df.parse(str)}")
    }
}