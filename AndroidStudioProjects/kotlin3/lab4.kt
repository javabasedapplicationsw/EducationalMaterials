package com.part1.myapplication.kotlin3

open class Plant(val name : String) {}

// 부모 클래스의 생성자를 실행시키려면 자식 클래스에서 반드시 부모 클래스의 생성자를 명시적으로 호출해 주어야 함
class Orchid(name : String, color : String) : Plant(name) {}