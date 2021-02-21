package coroutines

import kotlinx.coroutines.runBlocking

class SuspendTestMain {
    suspend fun suspendFunction1() {
        println("suspendFunction1()")
    }
}

fun main() = runBlocking {
    val test1 = SuspendTestMain()
    test1.suspendFunction1()
}