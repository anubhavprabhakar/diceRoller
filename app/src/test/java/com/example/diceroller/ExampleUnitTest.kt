package com.example.diceroller

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun generates_number() {
        val dice = Dice(20)
        val rollResult = dice.roll()
        assertTrue("The value of rollResult was not between 1 and 6, it was: ${rollResult}", rollResult in 1..6)
    }
}