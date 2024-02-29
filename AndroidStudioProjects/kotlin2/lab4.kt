package com.part1.myapplication.kotlin2

fun main() {

    // 1에서 5까지 출력하시오
    for (i in 1..5) {
        println(i)
    }

    // downTo
    for (i in 5 downTo 1) {
        println(i)
    }

    println()
    // step
    for (i in 1..10 step 2) {
        println(i)
    }
    println()

    val students = arrayOf("이순신", "원균", "권율", "류성룡", "선조")
    for (name in students) {
        println(name)
    }
    println()

    // withIndex() : 요소의 인덱스도 함께 리턴
    for ((index, name) in students.withIndex()) {
        println("Index : $index, Name : $name")
    }
}




















