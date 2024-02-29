package com.part1.myapplication.kotlin4

fun callLambda(lambda : (Int) -> Boolean) : Boolean {           // 람다식을 인수로 받음
    return lambda(7)
}


fun main() {
    val sayHello = fun() { println("안녕하세요!") }
    sayHello()

    val squareNum : (Int) -> (Int) = { number -> number * number }
    println(squareNum(12))

    val squareNum2 = { number : Int -> number * number }
    println(squareNum2(10))

    val squareNum3 : (Int) -> Int = { it * it }
    println(squareNum3(5))

    val paramLambda : (Int) -> Boolean = {num -> num == 10}
    println(callLambda(paramLambda))                // 람다식의 인수로 넣은 5 != 10이므로 false 리턴함
    println(callLambda({num -> num == 7}))          // 람다식 바로 넣어주기
    println(callLambda({it == 10}))                 // 인수가 하나일 때 it으로 변경 가능
    // 만약 함수의 마지막 인수가 람다일 경우 밖으로 뺄수 있음
    println(callLambda(){it == 10})

}