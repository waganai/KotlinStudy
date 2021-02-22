package callsjava

import callskotlin.InterfaceCallByKotlinTest1

class CallJavaInterfaceTestMain {
}

fun main() {
    val n1 = 3
    val n2 = 4
    // 单函数的Java接口可以使用如此方法调用
    val interface1Function1 = InterfaceCallByKotlinTest1 { a, b -> a + b }

    println("$n1 + $n2 = ${interface1Function1.function1(n1, n2)}")
}