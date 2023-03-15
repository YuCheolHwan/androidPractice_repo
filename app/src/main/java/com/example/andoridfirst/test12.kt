package com.example.andoridfirst

fun main() {
    var data : Array<Int> = arrayOf(10,20,30)
    var sum : Int = 0
    for((index,value) in data.withIndex()){
        sum += value
        print(sum)
        if(index != data.size -1){
            print("\t|\t")
        }
    }
}