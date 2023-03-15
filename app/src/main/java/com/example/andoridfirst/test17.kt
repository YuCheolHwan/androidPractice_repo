package com.example.andoridfirst

fun main() {
//    println(MyClass.data)
//    println(MyClass.some())
    println(sum1(1,2))
//    println(sum(10,20))
//    sum(10,20)
    good
}
class MyClass constructor(){
    companion object{
        var data = 10
        fun some(){
            println("static member variable = ${MyClass.data}")
        }
    }
}
fun sum1(no1 : Int, no2 : Int):Int{
    println("good")
    return no1 + no2
}
//val sum :(Int,Int) -> Int = {a1, b1-> println("bad"); a1 + b1 }
val good = { println("noThing") }