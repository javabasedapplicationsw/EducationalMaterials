package com.part1.myapplication.kotlin

fun main() {

    val stringArray : Array<String> = arrayOf("apple", "banana", "grape")
    val intArray = arrayOf(1,2,3)       // 자료형 생략

    val score = 100                     // Int형
    val scoreString = score.toString()  // String형
    val scoreDouble = score.toDouble()  // Double형

    println(stringArray[0])
    println(intArray[2])
    println(scoreDouble)
}