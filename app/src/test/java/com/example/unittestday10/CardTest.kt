package com.example.unittestday10

import org.junit.Assert
import org.junit.Test
import java.lang.Exception

class CardTest {

    @Test
    fun verifyHeartAce(){
        // Arrange
        val except = "Heart of Ace"
        val card = Card.create(1, Suit.Heart)
        // Act
        val result = card.toString()
        // Assert
        Assert.assertEquals(except,result)
    }

    @Test
    fun verifyHeartTwo() {
        // Arrange
        val except = "Heart of Two"
        val card = Card.create(2, Suit.Heart)
        // Act
        val result = card.toString()
        // Assert
        Assert.assertEquals(except,result)
    }

    @Test()
    fun `14 heart should not be able to created`() {
        // Arrange
        var hasException  = false
        try {
            val card = Card.create(14, Suit.Heart)
        }catch (e:Exception){
            hasException = true
        }
        // Assert
        Assert.assertTrue(hasException)
    }

    @Test
    fun verifyDiamondTwo() {
        // Arrange
        val except = "Diamond of Two"
        val card = Card.create(2, Suit.Diamond)
        // Act
        val result = card.toString()
        // Assert
        Assert.assertEquals(except,result)
    }
}