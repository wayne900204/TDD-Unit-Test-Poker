package com.example.unittestday10

import org.junit.Assert
import org.junit.Test

class HandTest {
    @Test
    fun `H1 H3 H5 H6 H7 should be Flush`() {
        val cards: List<Card> = listOf(
            Card.create(1, Suit.Heart),
            Card.create(3, Suit.Heart),
            Card.create(5, Suit.Heart),
            Card.create(6, Suit.Heart),
            Card.create(7, Suit.Heart),
        )

        val hand = Hand(cards)
        val exceptedCategory = RankingCategory.Flush
        // act
        val category: RankingCategory = hand.getCategoary()
        // assert
        Assert.assertEquals(exceptedCategory, category)
    }

    @Test
    fun `H1 C3 S5 H6 D7 should not be Flush`() {
        val cards: List<Card> = listOf(
            Card.create(1, Suit.Heart),
            Card.create(3, Suit.Club),
            Card.create(5, Suit.Spade),
            Card.create(6, Suit.Heart),
            Card.create(7, Suit.Diamond),
        )

        val hand = Hand(cards)
        val exceptedCategory = RankingCategory.Highcard
        // act
        val category: RankingCategory = hand.getCategoary()
        // assert
        Assert.assertEquals(exceptedCategory, category)
    }

    @Test
    fun `H1 C1 S1 H6 D6 should be Full House`() {
        val cards: List<Card> = listOf(
            Card.create(1, Suit.Heart),
            Card.create(1, Suit.Club),
            Card.create(1, Suit.Spade),
            Card.create(6, Suit.Heart),
            Card.create(6, Suit.Diamond),
        )

        val hand = Hand(cards)
        val exceptedCategory = RankingCategory.FullHouse
        // act
        val category: RankingCategory = hand.getCategoary()
        // assert
        Assert.assertEquals(exceptedCategory, category)
    }

    @Test
    fun `H1 C1 S1 H1 D6 should be Full of a kind`() {
        val cards: List<Card> = listOf(
            Card.create(1, Suit.Heart),
            Card.create(1, Suit.Club),
            Card.create(1, Suit.Spade),
            Card.create(1, Suit.Heart),
            Card.create(6, Suit.Diamond),
        )

        val hand = Hand(cards)
        val exceptedCategory = RankingCategory.FourOfAKind
        // act
        val category: RankingCategory = hand.getCategoary()
        // assert
        Assert.assertEquals(exceptedCategory, category)
    }

    @Test
    fun `flush should win Full House`() {
        // Arrange
        val cards: List<Card> = listOf(
            Card.create(1, Suit.Heart),
            Card.create(1, Suit.Club),
            Card.create(1, Suit.Spade),
            Card.create(1, Suit.Heart),
            Card.create(6, Suit.Diamond),
        )

        val flushCards: List<Card> = listOf(
            Card.create(1, Suit.Heart),
            Card.create(3, Suit.Heart),
            Card.create(5, Suit.Heart),
            Card.create(6, Suit.Heart),
            Card.create(7, Suit.Heart),
        )
        val fullHouseHand = Hand(cards)
        val flushHand = Hand(flushCards)
        // Act
        val wins = fullHouseHand.wins(flushHand)
        //Assert
        Assert.assertTrue(wins)
    }
    @Test
    fun `Full house should win Flush`() {
        // Arrange
        val cards: List<Card> = listOf(
            Card.create(1, Suit.Heart),
            Card.create(1, Suit.Club),
            Card.create(1, Suit.Spade),
            Card.create(1, Suit.Heart),
            Card.create(6, Suit.Diamond),
        )

        val flushCards: List<Card> = listOf(
            Card.create(1, Suit.Heart),
            Card.create(3, Suit.Heart),
            Card.create(5, Suit.Heart),
            Card.create(6, Suit.Heart),
            Card.create(7, Suit.Heart),
        )
        val fullHouseHand = Hand(cards)
        val flushHand = Hand(flushCards)
        // Act
        val wins = flushHand.wins(fullHouseHand)
        //Assert
        Assert.assertFalse(wins)
    }
}