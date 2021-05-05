package collections

class SequenceTestMain {
    companion object {
        @JvmStatic
        fun sequenceFunc() {
            val list1 = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
            val list2 = list1.asSequence().filter { it > 5 }.map { it * it }.toList()

            list2.forEachIndexed() { index, it ->
                print("list2[$index] = $it, ")
            }
        }
    }

}

fun main() {
    SequenceTestMain.sequenceFunc()
}