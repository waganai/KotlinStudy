package lambda

class ClosureTestMain {
    companion object {
        @JvmStatic
        fun func1() {
            val func1 = closureFunc()
            val func2 = closureFunc()

            func1()
            func1.invoke()
            func1()
            func1.invoke()

            func2.invoke()
        }

        @JvmStatic
        fun func2() {
            test

            test
            println("test = $test")
        }
    }
}

fun main() {
    ClosureTestMain.func1()
    ClosureTestMain.func2()
}

fun closureFunc(): () -> Unit {
    var sum = 0

    return fun() {
        sum++

        println("sum = $sum")
    }
}

val test = if (5 > 3) {
    println("yes")
} else {
    println("no")
}