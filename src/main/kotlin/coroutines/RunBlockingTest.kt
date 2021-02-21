package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class RunBlockingTest {
}

fun main() = runBlocking<Unit> {
    launch {
        for (i in 0..9) {
            println("子协程执行第$i 次")

            val sleepTime = (1000 * Math.random()).toLong()

            delay(sleepTime)
        }

        println("子协程执行结束")
    }

    delay(10000)

    println("主协程执行结束")
}