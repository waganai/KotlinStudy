package test

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

class GsonTestMain(
    @SerializedName(value = "nickName", alternate = ["nickname, nick_name"])
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

        fun funClass() {
            val gson = Gson()

            val str1 =
                "{\"name\":\"小明0\",\"nickName\":\"小明1\",\"nickname\":\"小明2\",\"nick_name\":\"小明3\",\"age\":12,\"sex\":\"男生\"}"
            val value1 = gson.fromJson(str1, GsonTestMain::class.java)
            val str2 =
                "{\"name\":\"小红0\",\"nickname\":\"小红2\",\"nick_name\":\"小红3\",\"age\":11,\"sex\":\"女生\"}"
            val value2 = gson.fromJson(str2, GsonTestMain::class.java)
            val str3 =
                "{\"name\":\"小红0\",\"nickname\":\"小红2\",\"nick_name\":\"小红3\",\"age\":11,\"sex\":\"女生\"}"
            val value3 = gson.fromJson(str3, GsonTestMain2::class.java)
            val str4 =
                "{\"name\":\"小红0\",\"nickname\":\"小红2\",\"nick_name\":\"小红3\",\"age\":11,\"sex\":\"女生\"}"
            val value4 = gson.fromJson(str4, GsonTestMain3::class.java)
            val str5 =
                "{\"name\":\"小红0\",\"nickname\":\"小红2\",\"nick_name\":\"小红3\",\"age\":11,\"sex\":\"女生\"}"
            val value5 = gson.fromJson(str5, GsonTestMain4::class.java)

            println("value1 {name = ${value1.name}, age = ${value1.age}, sex = ${value1.sex}")
            println("value2 {name = ${value2.name}, age = ${value2.age}, sex = ${value2.sex}")
            println("value3 {name = ${value3.name}, age = ${value3.age}, sex = ${value3.sex}")
            println("value4 {name = ${value4.name}, age = ${value4.age}, sex = ${value4.sex}")
            println("value5 {name = ${value5.name}, age = ${value5.age}, sex = ${value5.sex}")
        }
    }
}

class GsonTestMain2 {
    @SerializedName(value = "nickName", alternate = ["nickname, nick_name"])
    var name: String = "小明"
    var age: Int = 12
    var sex: String = "男生"
}

class GsonTestMain3 {
    @SerializedName(value = "nickName", alternate = ["nickname, nick_name"])
    var name: String? = null
    var age: Int = 12
    var sex: String = "男生"
}

class GsonTestMain4(name: String, age: Int, sex: String) {
     @SerializedName(value = "nickName", alternate = ["nickname, nick_name"])
    lateinit var name: String
    var age: Int
    lateinit var sex: String

    init {
        this.name = name
        this.age = age
        this.sex = sex
    }
}

fun main() {
//    GsonTestMain.funSimpleTransform()
//    GsonTestMain.funCollectionTransform()
    GsonTestMain.funClass()
}