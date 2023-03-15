package com.example.andoridfirst

fun main() {
    // 내부 함수
    fun sum(num : Int) : Int {
        var sum = 0
        for(i in 0..num){
            sum += i
        }
        return sum
    }
    //지역변수 선언
    val name : String = "홍길동"
    println("name ${name}")
    println(sum(10))
}
fun add() : Unit{
//    val value = sum(10)
}