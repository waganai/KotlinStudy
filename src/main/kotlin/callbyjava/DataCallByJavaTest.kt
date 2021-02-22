@file: JvmName("DataCallByJava")

package callbyjava

class DataCallByJavaTest(
    var name1: String = "name1",
    var id1: Int = 233,
    val name2: String = "name2",
    val id2: Int = 666
) {
    var name3 = "name3"
    var id3 = 1234

    val name4 = "name4"
    val id4 = 4567
}

var packageAttributeCallByJava = "name"

fun packageFunctionCallByJava() {
    println("packageFunctionCallByJava()")
}