package `class`

class TypeAlias {
    fun func1() {
        println("TypeAlias.func1()")
    }

    fun func2() {
        TypeInner().func1()
    }

    inline fun fun3(block:fString) {
        println(block.invoke())
    }

    inner class InnerClass{
        fun func1() {
            println("TypeAlias.InnerClass.func1()")
        }
    }
}

typealias Type = TypeAlias
typealias TypeInner = TypeAlias.InnerClass
typealias fString = () -> String

fun main() {
    val type = Type()
    type.func1()
    type.func2()
    type.fun3 { "哔哩哔哩666" }
}