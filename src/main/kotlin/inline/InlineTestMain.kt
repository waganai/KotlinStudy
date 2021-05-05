package inline

class InlineTestMain {
    companion object{

    }

    fun function1(block: () -> String) {
        println("function1() start")

        block()

        println("function1() end")
    }

    inline fun function2(block: () -> String) {
        println("function2() start")

        block()

        println("function2() end")
    }

    inline fun function3(block1: () -> String, block2: () -> String) {
        println("function3() start")

        block1()

        block2()

        println("function3() end")
    }

    inline fun function4(block1: () -> String, noinline block2: () -> String) {
        println("function4() start")

        block1()

        block2()

        println("function4() end")
    }
}

fun main() {
    val inlineTestMain = InlineTestMain()

    inlineTestMain.function1 { block() }

    inlineTestMain.function2 { block2() }

    inlineTestMain.function3(::block, ::block2)

    inlineTestMain.function4(::block, ::block2)
}

fun block() = "2333"

fun block2() = "6666"