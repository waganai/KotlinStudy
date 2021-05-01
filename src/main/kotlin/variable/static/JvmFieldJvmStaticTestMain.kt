package variable.static

class JvmFieldJvmStaticTestMain {
    @JvmField
    val staticVal = "staticVal"

    companion object{
        @JvmField

        val staticVal1 = "staticVal1"

        @JvmStatic
        fun staticFunc1() {
            println("staticFunc1()")
        }
    }
}