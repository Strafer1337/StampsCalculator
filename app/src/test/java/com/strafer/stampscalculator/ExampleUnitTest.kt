package com.strafer.stampscalculator

import com.strafer.stampscalculator.utils.Calculator
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

    @Test
    fun calculateWeight4() {
        assertEquals(
            36.0.toString(),
            Calculator().calculateWeight(40.1)
        )
    }
}