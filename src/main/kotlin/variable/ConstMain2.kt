package variable

class ConstMain2 {
}

fun main() {
    println("顶级变量")

    println("topConstVal = $topConstVal")
//    println("topPrivateConstVal = $topPrivateConstVal")
    println("topVal = $topVal")
    println("topVar = $topVar")
    println()

    println("object变量")

    println("ConstObjectTest.objectConstVal = ${ConstObjectTest.objectConstVal}")
    println("ConstObjectTest.objectVal = ${ConstObjectTest.objectVal}")
    println("ConstObjectTest.objectVar = ${ConstObjectTest.objectVar}")

    println()
}