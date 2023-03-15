package com.example.andoridfirst

fun main() {
    var sum : Int = 0
    for(i in 10 downTo  1 step 2){
        sum += i
    }
    println(sum)
}