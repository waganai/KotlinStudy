package annotations

import annotations.customannotation.KotlinCustomClassAnnotationTest
import annotations.customannotation.KotlinCustomFunctionAnnotationTest
import annotations.customannotation.KotlinCustomPropertiesAnnotationTest
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.findAnnotation

class KotlinAnnotationTestMain {
}

fun main() {
    val clz = KotlinAnnotationTestClass::class

    val ann1 = clz.findAnnotation<KotlinCustomClassAnnotationTest>()
    println("类 ${clz.simpleName} 注解 ann1 = ${ann1.toString()}， ${ann1?.name}")

    println()
    println("读取成员属性的注解信息:")
    clz.declaredMemberProperties.forEach {
        println(
            "属性 ${it.name}, 注解信息： name = ${it.findAnnotation<KotlinCustomPropertiesAnnotationTest>()?.name}, " +
                    "type = ${it.findAnnotation<KotlinCustomPropertiesAnnotationTest>()?.type}"
        )
    }

    println()
    println("读取成员函数的注解信息:")
    clz.declaredMemberFunctions.forEach {
        println(
            "函数 ${it.name}, 注解信息： name = ${it.findAnnotation<KotlinCustomFunctionAnnotationTest>()?.name}, " +
                    "parametersCount = ${it.findAnnotation<KotlinCustomFunctionAnnotationTest>()?.parametersCount}"
        )
    }
}