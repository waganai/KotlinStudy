package test

import com.google.gson.Gson

class GsonTestMain {
    var name = "小明"
    var age = 12
    var sex = "男生"
}

fun main() {
    val gson = Gson()
    val a: Int = gson.fromJson("233", Int::class.java)
    // Gson只能转化十进制数字
//    val b: Int = gson.fromJson("0b111", Int::class.java)

    println("a = $a")

    val c = gson.fromJson("true", Boolean::class.java)

    if (c) {
        println("c = $c")
    } else {
        println(" c is not Boolean")
    }

    val d = GsonTestMain()
    val string = gson.toJson(d)

    println("string = $string")

    val e = gson.fromJson(string, GsonTestMain::class.java)

    println("e is GsonTestMain = ${e is GsonTestMain}")
}