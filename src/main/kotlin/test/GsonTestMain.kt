package test

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GsonTestMain(
    var name: String = "小明",
    var age: Int = 12,
    var sex: String = "男生"
) {
    companion object {
        fun funSimpleTransform() {
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

        fun funCollectionTransform() {
            val gson = Gson()

            val array1 = arrayOf(GsonTestMain(), GsonTestMain("小红", 12, "女生"), GsonTestMain("小刚", 13, "男生"))
            val list1 = listOf(
                GsonTestMain("斯卡哈", 100000, "女生"),
                GsonTestMain("呆毛", 2100, "女生"),
                GsonTestMain("冲田总司", 200, "女生")
            )

            val str1 = gson.toJson(array1)
            println("str1 = $str1")
            println()

            val str2 = gson.toJson(list1)
            println("str2 = $str2")
            println()

            val array2 = gson.fromJson(str1, Array<GsonTestMain>::class.java)

            println("array2 is $array2")
            println("array2 is Array<GsonTestMain> = ${array2 is Array<GsonTestMain>}")
            println()

            val list2: List<GsonTestMain> = gson.fromJson(str2, object : TypeToken<List<GsonTestMain>>() {}.type)

            println("list2 is $list2")
            println("list2 is Array<GsonTestMain> = ${list2 is List<GsonTestMain>}")
            println()
        }
    }
}

fun main() {
//    GsonTestMain.funSimpleTransform()
    GsonTestMain.funCollectionTransform()
}