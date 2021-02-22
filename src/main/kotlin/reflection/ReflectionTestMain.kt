package reflection

import kotlin.reflect.full.createInstance
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

class ReflectionTestMain {
    fun classReflectClass() {
        val clz1 = Int::class
        val clz2 = String::class
        val clz3 = ReflectionTestClass::class

        val test1 = ReflectionTestClass("Java", 233)
        val clz4 = test1::class

        println("clz1类名：${clz1.simpleName}")
        println("clz1全类名：${clz1.qualifiedName}")

        println()

        println("clz2类名：${clz2.simpleName}")
        println("clz2全类名：${clz2.qualifiedName}")

        println()

        println("clz3类名：${clz3.simpleName}")
        println("clz3全类名：${clz3.qualifiedName}")

        println()

        println("clz4类名：${clz4.simpleName}")
        println("clz4全类名：${clz4.qualifiedName}")

        println()

        println("clz4是否为抽象类或者接口: ${clz4.isAbstract}")
        println("clz4是否为伴生对象: ${clz4.isCompanion}")
        println("clz4是否为数据类: ${clz4.isData}")
        println("clz4所有成员:")
        clz4.members.forEach { println(it.name) }
        println("clz4父类名:")
        clz4.sealedSubclasses.forEach { println(it.simpleName) }
    }

    fun classReflectFunction() {
        val fn1 = ::kotlinReflectionFunction1
        val fn2 = ::kotlinReflectionFunction2

        fn1.invoke()
        println("fn2.invoke() = ${fn2.invoke("Kotlin", 233)}")

        val clz1 = ReflectionTestClass::class
        val reflectionTestClass = clz1.createInstance()
        reflectionTestClass.function1()
        println("reflectionTestClass.function2() = ${reflectionTestClass.function2("Android", 666)}")
    }

    fun classReflectConstructor() {
        val clz = ReflectionTestClass::class

        clz.constructors.forEach { println("$it.name(${it.parameters})") }

        val constructor1 = clz.primaryConstructor
        val instance1 = constructor1?.call("Android", 123456)
        println("instance1.name = ${instance1?.name}, instance1.id = ${instance1?.id}")
        println()

        clz.constructors.forEach {
            when (it.parameters.size) {
                1 -> {
                    val instance = it.call(66666)
                    println("when parameters.size = 1, instance.name = ${instance.name}, instance.id = ${instance.id}")
                    println()
                }

                2 -> {
                    val instance = it.call("Kotlin", 23333333)
                    println("when parameters.size = 2, instance.name = ${instance.name}, instance.id = ${instance.id}")
                    println()
                }
            }
        }
    }

    fun classReflectAttribute() {
        val clz = ReflectionTestClass::class
        clz.memberProperties.forEach { println("name = ${it.name}, type = ${it.returnType}") }
        val reflectionTestClass = clz.primaryConstructor?.call("Kotlin", 2333333)
        if (reflectionTestClass != null) {
            println("clz.memberProperties.first()' value is ${clz.memberProperties.first().get(reflectionTestClass)}")
        }

        val attribute1 = ::kotlinReflectionAttribute
        println("attribute1 = $attribute1")

        val attribute2 = ReflectionTestClass::name
        val attribute3 = ReflectionTestClass::id
    }
}

fun main() {
    val reflectionTestMain = ReflectionTestMain()
//    reflectionTestMain.classReflectClass()
//    reflectionTestMain.classReflectFunction()
//    reflectionTestMain.classReflectConstructor()
    reflectionTestMain.classReflectAttribute()
}