package com.part1.myapplication.kotlin2

fun main() {

    var score = 70
    var isPass = false

    if (score > 80) {
        isPass = true
    }

    println("시험 결과는 $isPass 입니다.")

    score = 99
    if (score == 100) {
        println("만점입니다.")
    } else {
        println("만점은 아닙니다.")
    }

    val myAge = 20
    val isAdult = if (myAge > 18) true else false   // 표현식이 하나의 값으로 평가되는 문장 -- 값을 할당해야 하므로 반드시 else문이 필요함
    println("성인 여부 : $isAdult 입니다.")

}