package lambda

class LambdaTestMain {
}

fun main() {
    fun function1() {
        println("function1()")
    }

    val func2 = ::function2

    inlineFunction1(::function1)
    inlineFunction1 { function1() }
    inlineFunction1 { ::function1.invoke() }
    inlineFunction1(func2)
//    inlineFunction1()
    inlineFunction1{func2()}
}

fun function2() {
    println("function2()")
}

inline fun inlineFunction1(block: () -> Unit) {
    block()
}