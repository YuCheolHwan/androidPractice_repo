package com.example.andoridfirst

val a1 : Byte = 0b000101
val a2: Int = 234
val a3 : Short = 123
val a4 : Long = 10L
val a5 : Float = 0.12f
var a6 : Double = 0.4562
val a7 : Boolean = true
val a8 : Char = 'a'

fun main() {
    if(a8 == 'a'){
        println("true")
    }else{
        println("false")
    }
    val str2 = """
            Hello
            World
                good
                    bad
    """.trimIndent()
    println(str2)


}