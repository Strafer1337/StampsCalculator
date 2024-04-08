package com.strafer.stampscalculator.utilities

import kotlin.math.ceil

class Calculator {

    fun calculateWeight(weight: Double): String {
        val result = if (weight <= 20) 29.0
        else ceil((weight - 20.0) / 20) * 3.50 + 29
        return result.toString()
    }
}