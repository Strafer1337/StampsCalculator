package com.strafer.stampscalculator

import kotlin.coroutines.cancellation.CancellationException
import kotlin.math.ceil

object Calculator {
    var weight: Double? = null

    fun calculateWeight(weight: Double?): Unit {
        this.weight = if (weight!! <= 20) 29.0
        else ceil((weight - 20.0) / 20) * 3.50 + 29
    }

    fun getLiteral(): String =
        when (this.weight.toString().split('.')[0].last()) {
            '1' -> "рубль"
            '0', '5', '6', '7', '8', '9' -> "рублей"
            '2', '3', '4' -> "рубля"
            else -> throw CancellationException()
        }
}