package `class`

enum class EnumClassTestMain {
    ONE,
    TWO,
    THREE;

    inline fun <reified T: Enum<T>> printAllValues() {
        enumValues<T>().forEach {
            println("$it")
        }
    }
}

enum class EnumClassTest2(val color: String, var value: Int):EnumInterface1 {
    RED("red", 0xff0000) {
        override fun func1() {
            println("RED.func1()")
        }

        override fun interfaceFunc1() {
            println("RED.interfaceFunc1()")
        }
    },
    BLUE("blue", 0x0000ff) {
        override fun func1() {
            println("BLUE.func1()")
        }

        override fun interfaceFunc1() {
            println("BLUE.interfaceFunc1()")
        }
    },
    GREEN("green", 0x00ff00) {
        override fun func1() {
            println("GREEN.func1()")
        }

        override fun interfaceFunc1() {
            println("GREEN.interfaceFunc1()")
        }
    };

    abstract fun func1()
}

fun main() {
    val one = EnumClassTestMain.ONE
    val two = EnumClassTestMain.TWO
    val three = EnumClassTestMain.THREE

    println("one = ${one.declaringClass}")
    println("two = $two")
    println("three = $three")

    println()

    EnumClassTestMain.THREE.printAllValues<EnumClassTest2>()

    println()

    println("red.color = ${EnumClassTest2.RED.color}")
    println("red.value = ${EnumClassTest2.RED.value}")
    println("blue = ${EnumClassTest2.BLUE}")
    println("green = ${EnumClassTest2.GREEN}")

    println()

    EnumClassTest2.RED.func1()
    EnumClassTest2.BLUE.func1()
    EnumClassTest2.GREEN.func1()

    println()

    EnumClassTest2.RED.interfaceFunc1()
    EnumClassTest2.BLUE.interfaceFunc1()
    EnumClassTest2.GREEN.interfaceFunc1()

    println()

    EnumClassTest2.values().forEach {
        println("$it")
    }

    println()

//    println("EnumClassTest2.valueOf(\"YELLOW\") = ${EnumClassTest2.valueOf("YELLOW")}")
}

interface EnumInterface1 {
    fun interfaceFunc1()
}