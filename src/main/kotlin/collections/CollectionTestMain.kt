package collections

class CollectionTestMain {
}

fun main() {
    val arrayList = ArrayList<String>()
    val mutableArrayList = MutableList<String>(10) {
        "it*it"
    }
    val mutableArrayList2 = mutableListOf<String>()
    mutableArrayList2[0] = "000"
}