package com.example.andoridfirst

fun main() {
    val data71 : Array<Int> = Array(3, {0})
    val data72 : IntArray = intArrayOf(10,20,30)
    println(data71.size)
    data71.set(1, 100)
    for(i in 0..2){
        print("${data71.get(i)} \t")
        println(data71[i])
    }
}