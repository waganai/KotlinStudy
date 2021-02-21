package coroutines.controllers

import kotlinx.coroutines.*

class CoroutinesTimeOutTest {
    suspend fun function1() {
        for (i in 0..10) {
            println("子协程 执行第$i 次")

            val sleepTime = (1000 * Math.random()).toLong()

            delay(sleepTime)
        }

        println("子协程 执行结束")
    }
}

fun main() = runBlocking {
    withTimeout(
        3000L
    ) {
        coroutinesTimeOutTestFunction1()
    }

    withTimeout(1000L) {
        CoroutinesTimeOutTest().function1()
    }
}

suspend fun coroutinesTimeOutTestFunction1() {
    for (i in 0..10) {
        println("子协程 执行第$i 次")

        val sleepTime = (1000 * Math.random()).toLong()

        delay(sleepTime)
    }

    println("子协程 执行结束")
}