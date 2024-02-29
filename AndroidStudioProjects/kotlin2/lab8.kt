package com.part1.myapplication.kotlin2

fun main() {

    val numImmutableList = listOf(1,2,3)
    // numImmutableList[0] = 4         // 오류 발생 (읽기 전용이므로)

    val numMutableList = mutableListOf(1,2,3)
    numMutableList[0] = 100             // 첫번째 요소를 1에서 100으로 변경

    println(numMutableList)
    println(numMutableList[0])

    println(numMutableList.contains(1))
    println(numMutableList.contains(100))

}