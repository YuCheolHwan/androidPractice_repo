package com.example.andoridfirst

fun main() {
    val obj : Super = Child("홍길동")
    println(obj.superData)
    obj.superFun()
}
open class Super(var name:String){
    open var superData = 10
    open fun superFun(){
        println("i am super class function ${superData}")
}

}
class Child (var name1 : String): Super(name1){
    override var superData: Int = 20
    override fun superFun(){
        println("i am child class function ${superData}")
    }
}