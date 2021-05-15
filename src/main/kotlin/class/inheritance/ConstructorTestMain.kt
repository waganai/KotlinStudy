package `class`.inheritance

class ConstructorTestMain {
    companion object {
        @JvmStatic
        fun func1() {
            val initOrderDemo = ConstructorTestMain.InitOrderDemo("哔哩哔哩")
        }

        @JvmStatic
        fun func2() {
            val child = Child1("22", 22, "22娘")
            child.func1("33娘是妹妹")

            println()

            println(child.func2("22娘身高160cm"))

            println()

            child.func3("22娘活泼冒失", "33娘冷淡腹黑，是机器人")
        }

        @JvmStatic
        fun func3() {
            val base = Base2()

            println()

            val child = Child2()
        }
    }

    class InitOrderDemo(name: String) {
        val firstProperty = "First property: $name".also(::println)

        init {
            println("First initializer block that prints ${name}")
        }

        val secondProperty = "Second property: ${name.length}".also(::println)

        init {
            println("Second initializer block that prints ${name.length}")
        }
    }
}

fun main() {
    ConstructorTestMain.func3()
}

open class Base1(open val name: String, open val id: Int, open var content: String) {
    open fun func1(param: String) {
        println("Base1.func1($param)")
    }

    open fun func2(param: String): String {
        println("Base1.func2($param)")

        return ""
    }
}

interface Interface1 {
    fun func1(param: String) {
        println("Interface1.func1($param)")
    }

    fun func2(param: String): String {
        println("Interface1.func2($param)")

        return param
    }

    fun func3(param1: String, param2: String)
}

class Child1(override val name: String, override val id: Int, override var content: String) :
    Interface1, Base1(name, id, content) {
    override fun func1(param: String) {
        println("Child1.func1($param)")

        super<Base1>.func1(param)
    }

    override fun func2(param: String): String {
        println("Child1.func2($param)")

        return super<Interface1>.func2(param)
    }

    override fun func3(param1: String, param2: String) {
        println("Child1.func3($param1, $param2)")
    }
}

open class Base2() {
    open val value1: String = "哔哩哔哩".also {
        println("Base2 value1 = $it")
    }

    open val value2: String = "22娘33娘".also {
        println("Base2 value2 = $it")
    }

    init {
        println("In Constructor Base2 value1 = $value1")
        println("In Constructor Base2 value2 = $value2")
    }
}

class Child2() : Base2() {
    override val value1: String = "bilibli".also {
        println("Child2 value1 = $it")
    }

    init {
        println("In Constructor Child2 value1 = $value1")
        println("In Constructor Child2 value2 = $value2")
    }
}
