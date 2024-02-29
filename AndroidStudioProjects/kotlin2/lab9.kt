package com.part1.myapplication.kotlin2

fun main() {
    // 읽기 전용 셋
    val immutableSet = setOf(1,1,2,2,3,3)
    println(immutableSet)

    // 읽기 쓰기 모두 가능한 셋
    val mutableSet = mutableSetOf(1,2,3,3,3,3)
    mutableSet.add(100)
    mutableSet.remove(1)
    mutableSet.remove(200)

    println(mutableSet)
}