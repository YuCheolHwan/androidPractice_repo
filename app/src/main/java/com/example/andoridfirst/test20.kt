package com.example.andoridfirst

fun main() {
//    var data : String? = "a,b"
//    println("data length = ${data?.length ?: 0}")
    var data : String? = "a,b"
    val length = if(data == null){
    0
    }else{
        data.length
    }
    println(length)
}