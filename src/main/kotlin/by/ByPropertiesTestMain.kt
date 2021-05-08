package by

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class ByPropertiesTestMain() {
    var p: String by Delegate("哔哩哔哩")

    val lazy: String by lazy {
        println("初始化时运行")
        "哔哩哔哩干杯！"
    }

    var observable: String by Delegates.observable("Bilbili") { property: KProperty<*>, old: String, new: String ->
        println("${property.name} 's oldValue is $old, newValue is $new")
    }

    var votable: String by Delegates.vetoable("Android") { property: KProperty<*>, old: String, new: String ->
        new.length <= 10
    }

    var var1:String = "var1"

    var byVar :String by this::var1
    val byVal by this::p
    var byVar1 by this::observable
}

class Delegate(var string: String?) {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("$thisRef, thank you for delegating '${property.name}' to me")
        return string ?: ""
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to in '${property.name}' $thisRef")
        string = value
    }
}

fun main() {
    val byPropertiesTestMain = ByPropertiesTestMain()
    println("byPropertiesTestMain.p = ${byPropertiesTestMain.p}")
    println("byPropertiesTestMain.p = ${byPropertiesTestMain.byVal}")

    byPropertiesTestMain.p = "233"

    println("byPropertiesTestMain.p = ${byPropertiesTestMain.p}")
    println("byPropertiesTestMain.p = ${byPropertiesTestMain.byVal}")

    println()

    println("byPropertiesTestMain.var1 = ${byPropertiesTestMain.var1}")
    println("byPropertiesTestMain.byVar1 = ${byPropertiesTestMain.byVar}")

    byPropertiesTestMain.var1 = "哔哩哔哩"

    println("byPropertiesTestMain.var = ${byPropertiesTestMain.var1}")
    println("byPropertiesTestMain.byVar1 = ${byPropertiesTestMain.byVar}")

    println()

    println("byPropertiesTestMain.lazy = ${byPropertiesTestMain.lazy}")
    println("byPropertiesTestMain.lazy = ${byPropertiesTestMain.lazy}")

    println()

    byPropertiesTestMain.observable = "哔哩哔哩"
    println("byPropertiesTestMain.observable = ${byPropertiesTestMain.observable}")

    println()

    println("byPropertiesTestMain.votable = ${byPropertiesTestMain.votable}")
    byPropertiesTestMain.votable = "哔哩哔哩大魔王"
    println("byPropertiesTestMain.votable = ${byPropertiesTestMain.votable}")
    byPropertiesTestMain.votable = "哔哩哔哩大魔王哔哩哔哩大魔王哔哩哔哩大魔王哔哩哔哩大魔王"
    println("byPropertiesTestMain.votable = ${byPropertiesTestMain.votable}")
}