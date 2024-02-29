package com.part1.myapplication.kotlin2

fun main() {
    val temperature = 15

    when(temperature) {
        -15 -> { println(" 매우 추운 날씨 ") }                   // 값 하나
        11,12,13,14 -> { println(" 겨울 날씨 ") }               // 값 여러 개
        in 15..26 -> { println(" 활동하기 좋은 봄 날씨 ") }    // 범위 안에 들어가는 경우

        !in -30..50 -> { println(" 극한 날씨 ") }           // 범위 안에 안 들어가는 경우
        else -> { println(" 적절하지 않은 값, 값을 다시 확인해 주세요.")  }      // 위 경우가 모두 아닐 때
    }

    val score = 95
    val grade = when(score) {
        in 0..40 -> "D"
        in 41..70 -> "C"
        in 71..90 -> "B"
        else -> "A"
    }
    println("학점 : $grade 입니다.")
}


















