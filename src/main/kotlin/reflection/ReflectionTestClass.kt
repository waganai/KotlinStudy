package reflection

class ReflectionTestClass(arg1: String, arg2: Int) {

    var name = "name"
    var id = 233
    private var info = "info"

    init {
        println("primaryConstructor() arg1 = $arg1, arg2 = $arg2")

        name = arg1
        id = arg2
    }

    constructor(arg3: Int) : this("", 0) {
        println("secondaryConstructor() arg3 = $arg3")

        id = arg3
    }

    fun function1() {
        println("ReflectionTestClass.function1()")
    }

    fun function2(arg1: String, arg2: Int): String {
        println("ReflectionTestClass.function2($arg1, $arg2)")

        return arg1
    }
}

fun kotlinReflectionFunction1() {
    println("kotlinReflectionFunction1()")
}

fun kotlinReflectionFunction2(arg1: String, arg2: Int): String {
    println("kotlinReflectionFunction1($arg1, $arg2)")

    return arg1
}

var kotlinReflectionAttribute = "kotlinReflectionAttribute"