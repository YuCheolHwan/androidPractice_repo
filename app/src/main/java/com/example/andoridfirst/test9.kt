package com.example.andoridfirst

import java.util.*

fun main() {
    val sc : Scanner = Scanner(System.`in`)
    for(i in 0..30 step 2){
        println(i)
    }

    var data: Any = Integer.parseInt(sc.nextLine())
    when(data){
        is String -> println("string입니다")
        is Int -> println("int입니다.")
        else -> println("good")
    }

    class num(var a : Int){
    }
}