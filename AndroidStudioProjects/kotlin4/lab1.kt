package com.part1.myapplication.kotlin4

interface Car {
    abstract fun drive()
    fun stop()      // abstract 생략 가능
    fun destroy() = println("차가 소멸되었습니다.")
}

class Bugatti : Car {
    override fun stop() {
        println("부가티가 멈춥니다.")
    }

    override fun drive() {
        println("부가티가 달립니다.")
    }
}

fun main() {
    val myBugatti = Bugatti()           // 객체 생성
    myBugatti.drive()
    myBugatti.stop()
    myBugatti.destroy()
}









