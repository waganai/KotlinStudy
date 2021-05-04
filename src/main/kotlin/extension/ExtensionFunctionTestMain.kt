package extension

class ExtensionFunctionTestMain {
}

fun main() {
    val result1 = run {
        "run{" +
                "result1" +
                "}"
    }

    println("result1 = $result1")

    val result2 = "result2".takeIf { 1 < 0 }

    println("result2 = $result2")

    val result3 = "result3".takeUnless { 1 < 0 }

    println("result3 = $result3")
}