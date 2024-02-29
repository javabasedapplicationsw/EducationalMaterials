package com.part1.myapplication.kotlin2

fun main() {

    val numRange : IntRange = 1..5
    val charRange : CharRange = 'a'..'e'

    println(numRange.contains(3))
    println(numRange.contains(10))
    println(charRange.contains('b'))
    println(charRange.contains('w'))
}