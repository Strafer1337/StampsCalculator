package com.strafer.stampscalculator.utils

class Literal {
    fun getLiteral(weight: String): String =
        when (weight.split('.')[0].last()) {
            '1' -> "рубль"
            '0', '5', '6', '7', '8', '9' -> "рублей"
            '2', '3', '4' -> "рубля"
            else -> throw IllegalStateException()
        }
}