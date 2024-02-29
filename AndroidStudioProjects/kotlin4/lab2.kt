package com.part1.myapplication.kotlin4

interface Animal {
    fun breath()
    fun eat()
}

interface Dog {
    fun playball()
}

class JindoDog : Animal, Dog {      // 2개 이상의 인터페이스 구현
    override fun breath() {
        println("케켁하다")
    }

    override fun eat() {
        println("간식을 먹는다")
    }

    override fun playball() {
        println("공놀이하다")
    }
}

fun main() {
    val wangja = JindoDog()
    wangja.breath()
    wangja.eat()
    wangja.playball()
}