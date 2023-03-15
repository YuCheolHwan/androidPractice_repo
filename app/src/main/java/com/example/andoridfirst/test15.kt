package com.example.andoridfirst

fun main() {
    val obj = Super1()
    obj.publicData ++
//    obj.protectedData ++
//    obj.privateData ++


}
open class Super1{
    var publicData = 10
    protected var protectedData = 20
    private var privateData = 30

}
class Sub : Super1(){
    fun subFun(){
        publicData ++
        protectedData ++
//        privateData ++

    }

}
