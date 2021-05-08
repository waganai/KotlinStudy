package collections

class CollectionTestMain {
    companion object {
        @JvmStatic
        fun arrayGeneric() {
            //    val arrayList = ArrayList<String>()
//    val mutableArrayList = MutableList<String>(10) {
//        "it*it"
//    }
//    val mutableArrayList2 = mutableListOf<String>()
////    mutableArrayList2[0] = "000"
        }

        @JvmStatic
        fun mapAndFilter() {
            val list1 = listOf(0, 1, 2, 3)
            val list2 = list1.map {
                it * it
            }
            val list3 = list2.filter { it > 0 }
            val list4 = list2.filterNot { it < 4 }
            val count = list2.count { it > 3 }

            list1.forEachIndexed { index, i -> print("list1[${index}] = $i ${if (index < list1.size - 1) "," else ""}") }
            println()
            list2.forEachIndexed { index, i -> print("list2[${index}] = $i ${if (index < list2.size - 1) "," else ""}") }
            println()
            list3.forEachIndexed { index, i -> print("list3[${index}] = $i ${if (index < list3.size - 1) "," else ""}") }
            println()
            list4.forEachIndexed { index, i -> print("list4[${index}] = $i ${if (index < list4.size - 1) "," else ""}") }
            println()
            println("in list2, child who is bigger than 3 has $count")

            val list5 = listOf(-1, -2, -1, 0, 1, 2, 3, null, 4, 6, null, 10)
            val list6 = list5.filterNotNull()

            println()
            list5.forEachIndexed { index, i -> print("list5[${index}] = $i ${if (index < list5.size - 1) "," else ""}") }
            println()
            list6.forEachIndexed { index, i -> print("list6[${index}] = $i ${if (index < list6.size - 1) "," else ""}") }
        }

        @JvmStatic
        fun sumFoldReduce() {
            val list1 = listOf(1, 2, 3)
            val list2 = listOf(4, 5, 6)

            println("list1' sum is ${list1.sum()}")
            println()
            println("list2' sum is ${list2.sum()}")

            println()
            println("list1.sumBy{it * it} is ${list1.sumBy { it * it }}")
            println()
            println("list2.sumBy{it * it * it} is ${list2.sumBy { it * it * it }}")

            println()
            println("list1.fold(-1){acc, i -> acc * i} is ${list1.fold(-1) { acc, i -> acc * i }}")
            println()
            println("list2.fold(-10){acc, i -> acc * i} is ${list2.fold(-10) { acc, i -> acc * i }}")

            println()
            println("list1.reduce{acc, i -> acc * i} is ${list1.reduce { acc, i -> acc * i }}")
            println()
            println("list2.reduce{acc, i -> acc * i} is ${list2.reduce { acc, i -> acc * i }}")
        }

        @JvmStatic
        fun groupBy() {
            val list1 = listOf("A", "B", "C", "233", "666", "哔哩哔哩", "天闹黑卡尊皇讨奸天诛国贼")
            val map1 = list1.groupBy {
                when (it.length) {
                    0 -> "0"
                    1 -> "1"
                    in 2..3 -> "<4"
                    4 -> "4"
                    else -> "more"
                }
            }

            println()
            map1.forEach {
                println("(${it.key}, ${it.value}")
            }
        }

        @JvmStatic
        fun flattenFlatMap() {
            val list1 =
                listOf(listOf("A", "B", "C"), listOf("华为", "小米", "OPPO", "ViVO"), listOf("iOs", "Android", "鸿蒙"))
            val list11 = list1.flatten()
            var index = 0
            val list12 = list1.flatMap { list ->
                list.map {
                    "${index++}:$it"
                }
            }

            println()
            list11.forEach {
                print("$it ")
            }

            println()
            list12.forEach {
                print("$it ")
            }
        }

        @JvmStatic
        fun listIndexFunc() {
            var list1 = mutableListOf(
                Element(
                    "" +
                            "西游记", 1
                ), Element(
                    "" +
                            "红楼梦", 2
                ), Element(
                    "" +
                            "三国演义", 3
                ), Element(
                    "" +
                            "水浒传", 4
                )
            )

            list1.forEach { println("$it.name, ${it.id}") }

            list1[0] = Element("封神榜", 0)
            list1[1].id = 233

            println()

            list1.forEach { println("$it.name, ${it.id}") }
        }

        @JvmStatic
        fun mapIndexFunc() {
            var map = mutableMapOf(
                "百度" to Element(
                    "百度", 0
                ), "阿里" to Element(
                    "阿里", 1
                ),
                "腾讯" to Element(
                    "腾讯 ", 2
                )
            )

            map.forEach { (key, value) -> println("$key, $value") }

            map["百度"] = Element("百度百度度", 10)
            map["腾讯"]?.id = 0
            map["字节跳动"] = Element("字节跳动", 3)

            println()

            map.forEach { (key, value) -> println("$key, $value") }
        }
    }

    data class Element(var name: String, var id: Int)
}

fun main() {
//    CollectionTestMain.mapAndFilter()
//    CollectionTestMain.sumFoldReduce()
//    CollectionTestMain.groupBy()
//    CollectionTestMain.flattenFlatMap()
//    CollectionTestMain.listIndexFunc()
    CollectionTestMain.mapIndexFunc()
}