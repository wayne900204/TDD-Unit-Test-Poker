package com.example.unittestday10

import org.junit.Assert
import org.junit.Test

class CalculatorTest {

    @Test
    fun addOne() {
        // Arrange
        val input = 3
        val expect = 4
        val calculateor = Calculator()
        // Act
        val result:Int = calculateor.addOne(input)
        // Assert
        Assert.assertEquals(expect,result)
    }
}