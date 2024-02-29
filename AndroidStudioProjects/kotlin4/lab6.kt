package com.part1.myapplication.kotlin4


fun reverseName3(name : String?) : String {     // 반환값 자료형은 null 불가능
    return name!!.reversed()                    //name이  절대 null이 아님을 보증
}


fun main() {

    //var myName : String               // 초기화를 해주지 않아 에러
    //var myName : String = null      // non-nullable 자료형에 null을 넣어서 에러
    var myName : String? = null       // null이 가능한 String형
    //myName = "Admiral Lee"
    //println(myName.reversed())          // 에러 발생 --   myName이  null이 될 수도 있기 때문에 코틀린 컴파일러가 개발자에게 확인하라고 알려줌
    println(reverseName3("Admiral Lee"))
    println(reverseName3(null))     // 에러 발생. NullPointerException
}



