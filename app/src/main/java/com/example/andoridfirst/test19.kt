package com.example.andoridfirst

val calBoolean = {no : Int -> println("no = ${no}"); no>10}

fun ramda(arg : (Int) -> Boolean) : () -> String{
    println(arg(5))
    return {val value = "길동"; "returnValue 는 ${value}"}
}



fun main() {
    var data : String? = "a,b"
    println("data length = ${data?.length ?: 0}")

    val returnValue = ramda({no : Int -> println("no = ${no}"); no>10})
    println(returnValue())
}