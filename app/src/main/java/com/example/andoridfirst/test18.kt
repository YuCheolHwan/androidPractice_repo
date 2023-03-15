package com.example.andoridfirst

//fun sum(no1 : Int):Unit{
//    var no2 = 20
//    println("no1 = ${no1} no2 = ${no2}")
//    println("합계 = ${no1 + no2}")
//}
//typealias I = Int
//val sum :(I) -> Unit = {
//    var no2 = 20; println("no1 = ${it} no2 = ${no2}");
//    println("합계 = ${it + no2}")
//}

//val addValue = {10+20}


//fun addValue():Int{
//    return 10+20
//}

val addValue = {10+20}

fun a(addValue:()->Int ){
    println(addValue())
}

fun main() {
    a(addValue)
}