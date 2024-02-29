package com.part1.myapplication.kotlin3

abstract class Game {
    fun startGame() {
        println("게임을 시작합니다.")
    }

    abstract fun printName()            // 추상 메서드
}

class Overwatch : Game() {
    override fun printName() {          // 추상 메서드 구현
        println("오버워치입니다.")
    }
}

fun main() {
    val overwatch = Overwatch()
    overwatch.startGame()
    overwatch.printName()
}