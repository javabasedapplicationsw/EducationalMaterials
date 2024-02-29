package com.part1.myapplication.kotlin2

fun main() {
    printAge(20)
    printAge2(30)
    println(addNum(10, 20))
    println(minusNum(20,10))
}

fun printAge(age : Int) : Unit {
    println(age)
}

fun printAge2(age : Int) {
    println(age)
}

fun addNum(a : Int, b : Int) : Int {
    return a + b
}

fun minusNum(a : Int, b : Int) = a-b