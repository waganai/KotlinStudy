package callsjava

import callskotlin.CallByKotlinTestMain
import java.util.*

class CallJavaTestMain {
}

fun main() {
    val test1 = CallByKotlinTestMain()
    println("test1.name = ${test1.name}")
    println("test1.id = ${test1.id}")

    // 当java 标识中出现kotlin关键字时，需要使用``包裹
    println("test1.object = ${CallByKotlinTestMain.`object`}")

    val date1 = test1.birthDate
    val date2: Date? = test1.birthDate
    // 对弈Java中变量属性，最好使用Any?类型接收，因为不确定他们是否是null
//    val date3: Date = test1.birthDate

    println("date1  = $date1")
    println("date2  = $date2")
}