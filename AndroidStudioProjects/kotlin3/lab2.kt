package com.part1.myapplication.kotlin3

import java.lang.IllegalArgumentException

class Animal(name : String) {
    val name : String
    init {
        if (name.isEmpty()) {   //문자열이 비어 있는 경우
            throw IllegalArgumentException("이름이 없어요.")
        }
        this.name = name        //문자열이 안 비어 있으면 이름 저장
    }
}

fun main() {
    val newAnimal = Animal("허스키")       // 객체 생성
}