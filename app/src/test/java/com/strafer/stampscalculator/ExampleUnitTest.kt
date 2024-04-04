package com.strafer.stampscalculator

import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    private val calculator = Calculator()

    @Test
    fun calculateWeight1() {
        assertEquals(
            29.0.toString(),
            calculator.calculateWeight(15.toDouble())
        )
    }

    @Test
    fun calculateWeight2() {
        assertEquals(
            29.0.toString(),
            calculator.calculateWeight(0.0)
        )
    }

    @Test
    fun calculateWeight3() {
        assertEquals(
            32.5.toString(),
            calculator.calculateWeight(40.toDouble())
        )
    }

    @Test
    fun calculateWeight4() {
        assertEquals(
            36.0.toString(),
            calculator.calculateWeight(40.1)
        )
    }
}