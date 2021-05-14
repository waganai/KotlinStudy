package basics

import kotlin.Double.Companion.NaN
import kotlin.Double.Companion.POSITIVE_INFINITY

class DigitalTestMain {
}

fun main() {
    val a: Int = 1000
    val b: Int? = a
    val c: Int? = a

    println("a === b is ${a === b}")
    println("a === c is ${a === c}")
    println("b === c is ${b === c}")

    println("")

    println("a == b is ${a == b}")
    println("a == c is ${a == c}")
    println("b == c is ${b == c}")

    println("")

    val d = 5/2
    println("d = $d")
    println("5/2 = ${5/2}")
    println("100000000/100000001 = ${100000000/100000001}")
    println("199999999/100000000 = ${199999999/100000000}")

    println("")

    println("NaN = $NaN")
    println("NaN > POSITIVE_INFINITY = ${NaN > POSITIVE_INFINITY}")
    println("-0.0 < 0.0 = ${-0.0 > 0.0}")
}