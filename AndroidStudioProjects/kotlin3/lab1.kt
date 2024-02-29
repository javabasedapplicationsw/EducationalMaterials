package com.part1.myapplication.kotlin3

// 클래스 속성인 프라퍼티 추가
class Car (val color : String)

// 객체 생성
// 자바에서는 new 키워드를 사용했지만, 코틀린에서는 필요없음
val car = Car("파란")


class Person {
    constructor(age : Int) {
        println("나는 $age 살 입니다")
    }
}
val person = Person(10)

fun main() {
    println("나의 차 색상은 ${car.color} 색입니다.")      // 객체의 color 프로퍼티 사용
    println(person)
}

