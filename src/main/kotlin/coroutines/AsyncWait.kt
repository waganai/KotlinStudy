package coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class AsyncWait {
}

fun main()  = runBlocking{
    val response1 = async{
       function1()
    }

    val response2 = async{
       function2()
    }

    println("result is ${response1.await()} and ${response2.await()}")
}

suspend fun function1():Int {
    delay(2000L)

    return 1000
}

suspend fun function2():Int {
    delay(3000L)

    return 10000
}