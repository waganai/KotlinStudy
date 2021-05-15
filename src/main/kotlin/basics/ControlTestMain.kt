package basics

class ControlTestMain {
    companion object {
        @JvmStatic
        fun func1(block: () -> Unit) {
            println("func1() start")

            block()

            println("func1() end")
        }

        @JvmStatic
        fun func2(block: () -> String) {
            println("func2() start")

            println(block())

            println("func2() end")
        }

        @JvmStatic
        inline fun func3(block: ()->Unit) {
            println("func3() start")

            println(block())

            println("func3() end")
        }

        @JvmStatic
        inline fun func4(block: () -> String) {
            println("func4() start")

            println(block())

            println("func4() end")
        }
    }
}

fun main() {
    ControlTestMain.func1(fun () {
        val a = 12
        val b = 13
        println("a + b = ${a + b}")
        return
    })

    println("")

    ControlTestMain.func1 {
        val c = 12
        val d = 13
        println("c + d = ${c + d}")
        return@func1
    }

    println("")

    ControlTestMain.func2(fun ():String {
        val e = 12
        val f = 13

        return "e + f = ${e + f}"
    })

    println("")

    ControlTestMain.func2 {
        val g = 12
        val h = 13

        return@func2 "g + h = ${g + h}"
    }

    println("")

//    ControlTestMain.func3 {
//        val i = 19
//        val j  = 10
//        println("i + j = ${i + j}")
//
//        return
//    }

    println("")

    ControlTestMain.func3 {
        val k = 19
        val l  = 10
        println("k + l = ${k + l}")

        return@func3
    }

    println("")

//    ControlTestMain.func4 {
//        val m = 19
//        val n  = 10
//        "m + n = ${m + n}"
//
//        return
//    }

    println("")

    ControlTestMain.func4 {
        val o = 19
        val p  = 10

        return@func4 "o + p = ${o + p}"
    }
}