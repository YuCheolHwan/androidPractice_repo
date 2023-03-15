package com.example.andoridfirst

val data5:Int by lazy {
    println("In lazy")
    10
}

fun main(){
    println("In main start")
    println(data5 + 10)
    println(data5 + 20)
    var data6 : Int = 10
    var data7 : Int? = null

    data6 = data6 + 10
    data6 = data6.plus(20)
    data7 = data7?.plus(10)

    println(data6)
    println(data7)
}