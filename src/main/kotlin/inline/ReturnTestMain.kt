package inline

class ReturnTestMain {
}

fun main() {
    println("main() start")

    function {
        func1()

        return@function
    }

    println("main() end")
}

inline fun function(block:() -> Unit) {
    println("function() start")

    block()

    println("function() end")
}

fun func1() {
    println("func1()")

    func2()

    return
}

fun func2() {
    println("func2()")

    func3()

    return
}

fun func3() {
    println("func3()")

    func4()

    return
}

fun func4() {
    println("func4()")

    return
}



