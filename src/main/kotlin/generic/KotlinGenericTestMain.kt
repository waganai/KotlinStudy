package generic

class KotlinGenericTestMain {
    companion object {
        @JvmStatic
        fun <T> getClassType(clazz: Class<T>) {
            println("clazz 'type is $clazz")
        }

        inline fun <reified T : Any> getClazzType(t: T) {
            println("type is ${T::class.java}")
        }
    }
}

fun main() {
    val arrayList = arrayListOf("1", "2", "3")
    val arrayList2 = object : ArrayList<String>() {}
    val array = arrayOfNulls<String>(10)

    println("arrayList' type is ${arrayList.javaClass}")
    println("array' type is ${array.javaClass}")

    val array1 = arrayOfNulls<Child>(10)
    val array2: Array<Child?> = array1

//    KotlinGenericTestMain.getClassType(array1)
    KotlinGenericTestMain.getClassType(Parent()::class.java)
    KotlinGenericTestMain.getClassType(Child()::class.java)
    KotlinGenericTestMain.getClassType(arrayList::class.java)
    KotlinGenericTestMain.getClassType(array::class.java)
    KotlinGenericTestMain.getClassType(array1::class.java)
    KotlinGenericTestMain.getClassType(array2::class.java)

    println()
    println("********************************************")

    println("arrayList' type is ${arrayList.javaClass.genericSuperclass}")
    println("arrayLis2' type is ${arrayList2.javaClass.genericSuperclass}")

    println()
    println("********************************************")

    KotlinGenericTestMain.getClazzType(Parent())
    KotlinGenericTestMain.getClazzType(Child())
    KotlinGenericTestMain.getClazzType(arrayList)
    KotlinGenericTestMain.getClazzType(arrayList2)
    KotlinGenericTestMain.getClazzType(array)
    KotlinGenericTestMain.getClazzType(array1)
    KotlinGenericTestMain.getClazzType(array2)
}

class Parent {

}

class Child {

}