package com.part1.myapplication.kotlin4

val bear : String by lazy {
    println("곰이 겨울잠에서 깨어납니다.")
    "black bear"
}

fun main() {
    lateinit var lunch : String         // lateinit 키워드로 나중에 값 할당할 것임을 선언


    lunch = "kimbap"

    println(lunch)

    println(bear)                   // lazy 블록 실행됨
    println()
    println(bear)                  // 이미 초기화되었으므로 블록 실행 안됨
}


