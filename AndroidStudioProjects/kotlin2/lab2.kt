package com.part1.myapplication.kotlin2

fun main() {

    val price = 3000
    val tax = 300

    val originalPrice = "오리지널 가격은 $price 원입니다."
    val totalPrice = "총가격은 ${price + tax} 원입니다."

    println(originalPrice)
    println(totalPrice)
}