package com.part1.myapplication.kotlin2

fun main() {
    var num = 1

    while (num < 5) {
        println(num)
        num++
    }

    println()

    num = 1
    do {
        num++
        println(num)
    } while (num < 5)

}