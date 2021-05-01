package variable.static

object ObjectTestMain {
    @JvmField
    val mVal = "val"
    @JvmStatic
    fun func1() {
        println("ObjectTestMain.func1()")
    }
}