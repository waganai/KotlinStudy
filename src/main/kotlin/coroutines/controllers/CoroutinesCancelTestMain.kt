package coroutines.controllers

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CoroutinesTestMain {
}

fun main() = runBlocking {
    val job1 = launch {
        while (true) {
            println("子协程运行中。。。")
            delay(1000L)
        }
    }


    val command = readLine()
    if ("q" == command) {
        job1.cancel()
        job1.join()
    }
}