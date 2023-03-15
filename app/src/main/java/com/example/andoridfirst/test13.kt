package com.example.andoridfirst

fun main() {
    var user:User1 = User1()
    println(user)
    user.someFun()
}
open class User1 (var a:Int, var b:Int, var c:Int){
    init{
        println("im main constructor")
    }
    constructor():this(0){
        println("im serve constructor1")
    }
    constructor(a:Int):this(a,0){
        println("im serve constructor2")
    }
    constructor(a:Int,b:Int):this(a,b,0){
        println("im serve constructor3")
    }



    override fun toString(): String {
        return "a = ${this.a} b = ${this.b} c = ${this.c}"
    }

    fun someFun(){
        println("member variable = ${this.a}")
    }
}
class User3(var a1 : Int, var b1 : Int, var c1 : Int, var d1 : Int):User1(a1,b1,c1){

}