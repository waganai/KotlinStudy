package basics

class StringTestMain {
}

fun main() {
    val text = """
    for (c in "foo")
        print(c)
"""

    println("text = $text")

    println()

    val text2 = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()

    println("text2 = \n$text2")

    println()
    println("1" + " = ${1}")

    val a = 9.99

    println()
    println("""${'$'}a""")

    println()
    println("""$a""")
}
