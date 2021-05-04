package coroutines

import kotlinx.coroutines.*

class RunBlockingTestMain {
}

fun main() = runBlocking {
    println("current thread is ${Thread.currentThread().name} start")

    delay(1000L)

    val job1 = GlobalScope.launch {
        println("current thread in job1 is ${Thread.currentThread().name}")

        delay(10000L)
    }

    val job2 = GlobalScope.launch {
        println("current thread in hob2 is ${Thread.currentThread().name}")

        delay(1000L)

        job1.cancel()
    }

    job1.join()

    println("current thread is ${Thread.currentThread().name} end")
}