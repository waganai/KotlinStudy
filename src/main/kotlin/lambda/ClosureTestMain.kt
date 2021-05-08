package lambda

class ClosureTestMain {
}

fun main() {
    val func = closureFunc()
    func()
    func.invoke()
    func()
    func.invoke()
}

fun closureFunc(): () -> Unit {
    var sum = 0

    return fun() {
        sum++

        println("sum = $sum")
    }
}