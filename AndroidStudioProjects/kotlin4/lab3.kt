package com.part1.myapplication.kotlin4

interface Animal2 {
    fun breath()
    fun eat()
}

interface Dog2 {
    fun playball()
}

open class Name(val name : String) {
    fun printName() {
        println("제 이름은 $name 입니다.")
    }
}

class JindoDog2(name : String) : Name(name), Animal2, Dog2 {      // 부모 클래스 생성자 필요한 인수 전달
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
    val gongju = JindoDog2("공주")
    gongju.breath()
    gongju.eat()
    gongju.playball()
}