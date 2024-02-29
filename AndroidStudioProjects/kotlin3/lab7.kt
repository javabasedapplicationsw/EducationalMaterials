package com.part1.myapplication.kotlin3

data class Memo(val title : String, val content : String, var isDone : Boolean)

fun main() {

    var memo1 = Memo("마트 가기", "과일, 과자, 고기", false)
    var meno2 = memo1.copy(content = "빵, 쌀")        // content 프로퍼티만 변경

    println(memo1.toString())
    println(meno2.toString())
}