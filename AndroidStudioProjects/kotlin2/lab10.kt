package com.part1.myapplication.kotlin2

fun main() {
    //읽기 전용 맵
    val immutableMap = mapOf("name" to "이순신", "age" to 20, "age" to 80, "height" to 185)
    println(immutableMap)

    //읽기 쓰기 모두 가능한 맵
    val mutableMap = mutableMapOf("파스타" to "양식", "짜장면" to "중식", "김치찌게" to "한식")
    mutableMap.put("초밥","일식")       // 새로운 요소 추가
    mutableMap.remove("파스타")    // key값으로 요소 삭제
    mutableMap.replace("김치찌게", "K-Food")       //  기존 요소 교체

    println(mutableMap)
}