package com.example.andoridfirst

import java.text.SimpleDateFormat
import java.util.*

fun main() {
    val data : Int = 20
    // 템플릿 문자열
    println("data = ${data} ")
    var value : String = formatDate(Date())
    println("date = ${value}")

    var user : User = User()
    user.sayHello()
    println(user.name)
}
fun formatDate(date : Date) : String{
    var sdf : SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    return sdf.format(date)
}

class User{
    // 멤버 변수
    var name : String = "Hello"
    // 멤버 함수
    fun sayHello():Unit{
        println("name = ${name}")
    }
}