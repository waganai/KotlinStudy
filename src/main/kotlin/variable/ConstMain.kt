package variable

const val topConstVal = "topConstVal"
const val topConstGetVal = "topConstGetVal"
private const val topPrivateConstVal = "topPrivateConstVal"

//const var topConstVar = "topConstVar"
val topVal = "topVal"
var topVar = "topVar"
val topGetVal
    get() = "666"
var topGetVar = "topGetVar"
    get() = "233"
    set(value) {
        field = value + "666"
    }
public val publicTopVal = "publicTopVal"
public var publicTopVar = "publicTopVar"

object ConstObjectTest {
    const val objectConstVal = "objectConstVal"
    val objectVal = "objectVal"
    var objectVar = "objectVar"
}

class ConstMain {
    //    const val constVal = "constVal"
    val mVal = "mVal"
    var mVar = "mVar"

    companion object {
        const val companionObjectConstVal = "companionObjectConstVal"
        val companionObjectVal = "companionObjectVal"
        var companionObjectVar = "companionObjectVar"
    }
}

fun main() {
    println("topConstVal = $topConstVal")
    println("topPrivateConstVal = $topPrivateConstVal")
    println("topVal = $topVal")
    println("topVar = $topVar")
    println()

    println("objectConstVal = ${ConstObjectTest.objectConstVal}")
    println("objectVal = ${ConstObjectTest.objectVal}")
    println("objectVar = ${ConstObjectTest.objectVar}")
    println()

    val constMain = ConstMain()

    println("mVal = ${constMain.mVal}")
    println("mVar = ${constMain.mVar}")
    println()

    println("companionObjectConstVal = ${ConstMain.companionObjectConstVal}")
    println("companionObjectVal = ${ConstMain.companionObjectVal}")
    println("companionObjectVar = ${ConstMain.companionObjectVar}")
}
