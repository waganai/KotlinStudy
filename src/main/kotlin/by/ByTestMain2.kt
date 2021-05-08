package by

class ByTestMain2 {
    var map: MutableMap<String, String> = mutableMapOf("value1" to "233", "value2" to "666")

    val value1: String by map
    val value2: String by map
}

fun main() {
    val byTestMain2 = ByTestMain2()

    println("byTestMain2.value1 = ${byTestMain2.value1}")
    println("byTestMain2.value2 = ${byTestMain2.value2}")

    byTestMain2.map.put("value1", "哔哩哔哩")
    byTestMain2.map.put("value2", "BilBili")

    println()
    println("byTestMain2.value1 = ${byTestMain2.value1}")
    println("byTestMain2.value2 = ${byTestMain2.value2}")

    println()

    byFunc1 {
        "哔哩哔哩"
    }
}

fun byFunc1(block:()->String) {
    var value1 = "233"
    val value2 by lazy(block)

    println("byFunc1() value1 = $value1")
    println("byFunc1() value2 = $value2")
}