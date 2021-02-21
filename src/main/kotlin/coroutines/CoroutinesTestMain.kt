package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Math.random
import java.lang.Thread.sleep

class CoroutinesTestMain {
}

fun main() {
    val job = GlobalScope.launch {
        for (i in 0..9) {
            println("子协程执行第$i 次")

            val sleepTime = (1000 * random()).toLong()

            delay(sleepTime)
        }

        println("子协程执行结束")
    }

    println("job.isActive : ${job.isActive}")
    println("job.isCompleted : ${job.isCompleted}")

    sleep(10000L)
    println("主协程执行结束")

    println("job.isActive : ${job.isActive}")
    println("job.isCompleted : ${job.isCompleted}")
}