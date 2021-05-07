package `class`

class ClassTestMain {
    val val1 = "val1"

    class NestedClass {
        fun func1() {
//            println("val1 = $val1")
        }
    }

    inner class InnerClass {
        fun func1() {
            println("val1 = $val1")

            val interface1 = object : TestInterface {
                override fun func1() {
                    println("interface1.func1()")
                }

                override fun func2() {
                    println("interface1.func2()")
                }
            }

            interface1.func1()
            interface1.func2()
        }
    }

    fun func1() {
        InnerClass().func1()
    }
}

fun main() {
    val innerClass = ClassTestMain.NestedClass()
    ClassTestMain().func1()
}

interface TestInterface {
    fun func1()
    fun func2()
}
