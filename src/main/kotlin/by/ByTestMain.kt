package by

class ByTestMain {
}

interface Base {
    val message:String

    fun func1()
    fun func2()
    fun func3() {
        println(message)
    }
}

class BaseImpl : Base {
    override val message: String = "BaseImpl"

    override fun func1() {
        println("BaseImpl.func1()")
    }

    override fun func2() {
        println("BaseImpl.func2()")
    }
}

class Derived(b: Base) : Base by b {
    override val message: String = "Derived"

    override fun func2() {
        println("Derived.func2()")
    }
}

fun main() {
    val baseImpl = BaseImpl()
    val derived = Derived(baseImpl)
    derived.run {
        func1()
        func2()
        func3()
    }
}