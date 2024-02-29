package com.part1.myapplication.kotlin3

class Dinner {
    companion object {
        val MENU = "pasta"          // 정적 변수 생성
        fun eatDinner() {           // 정적 메서드 생성
            println("$MENU 는 맛있다!")
        }
    }
}

fun main() {
    println(Dinner.Companion.MENU)
    println(Dinner.MENU)        // Companion 생략 가능
    Dinner.eatDinner()
}