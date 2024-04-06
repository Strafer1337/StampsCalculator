package com.strafer.stampscalculator.utilities

import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorTest {

    @Test
    fun calculateWeight() {
        assertEquals(
            29.0.toString(),
            Calculator.calculateWeight(0.0)
        )
    }

    @Test
    fun calculateWeight1() {
        assertEquals(
            36.0.toString(),
            Calculator.calculateWeight(40.1)
        )
    }

    @Test
    fun calculateWeight2() {
        assertEquals(
            32.5.toString(),
            Calculator.calculateWeight(40.toDouble())
        )
    }

    @Test
    fun calculateWeight3() {
        assertEquals(
            39.5.toString(),
            Calculator.calculateWeight(62.toDouble())
        )
    }
}