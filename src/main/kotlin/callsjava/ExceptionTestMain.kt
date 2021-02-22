package callsjava

import java.io.BufferedReader
import java.io.InputStreamReader

class ExceptionTestMain {
}

fun main() {
    // Kotlin中美诶呦受检查异常，所以Java中那些需要使用try catch语句包裹的代码，在kotlin中是不需要如此写的
    InputStreamReader(System.`in`).use { ir ->
        BufferedReader(ir).use { reader ->
            // 从键盘接收了一个字符串的输入
            val command = reader.readLine()
            println("输入的内容是： $command")
        }
    }
}