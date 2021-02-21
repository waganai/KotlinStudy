package coroutines.controllers

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CoroutinesJoinTestMain {
}

fun main() = runBlocking {
    val job1 = launch {
        for (i in 0..4) {
            println("job1 执行第$i 次")

            val sleepTime = (1000 * Math.random()).toLong()

            delay(sleepTime)
        }

        println("job1 执行结束")
    }

    val job2 = launch {
        for (i in 0..2) {
            println("job2 执行第$i 次")

            val sleepTime = (1000 * Math.random()).toLong()

            delay(sleepTime)
        }

        job1.join()

        println("job2 等待 job1执行结束")

        for (i in 3..4) {
            println("job2 执行第$i 次")

            val sleepTime = (1000 * Math.random()).toLong()

            delay(sleepTime)
        }

        println("job2 执行结束")
    }

    delay(10000L)
}