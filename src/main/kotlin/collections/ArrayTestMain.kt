package collections

class ArrayTestMain {

}

fun main() {
    val array = arrayOfNulls<Int>(10)

    array.forEach {
        print("${array[it ?: 0]} ")
    }

    println()

    for (i in array.indices) {
        array[i] = i
    }

    array.forEach {
        print("${array[it ?: 0]} ")
    }

    println()
}