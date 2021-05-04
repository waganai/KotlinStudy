package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GlobalScopeLaunchTestMain {

}

fun main() {
    val job: Job = GlobalScope.launch {
        println("current thread in GlobalScope.launch() is ${Thread.currentThread().name}")

        delay(1000L)

        println("in thread ${Thread.currentThread().name}, we has delay(1000ms)")
    }

    Thread.sleep(2000L)

    println("current thread in main() is ${Thread.currentThread().name}")
}