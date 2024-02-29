package com.part1.myapplication.kotlin3

open class Flower {
    open fun blossom() {
        println("꽃이 피다")
    }
}

class Rose : Flower() {
    override fun blossom() {
        super.blossom()     // Flower  클래스의 메서드 먼저 실행
        println("장미가 지금 만발했습니다.")
    }
}

fun main() {
    val rose = Rose()       // 객체 생성
    rose.blossom()
}