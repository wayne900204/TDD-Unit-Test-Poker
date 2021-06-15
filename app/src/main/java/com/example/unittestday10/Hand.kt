package com.example.unittestday10

class Hand(val cards: List<Card>) {
    fun getCategoary(): RankingCategory {
        val suits = cards.groupBy { it.suit }
        val numbers = cards.groupBy { it.number }
        return if (numbers.size == 2) {
            if (numbers.any { (_, list) -> list.size == 4 }){
                RankingCategory.FourOfAKind
            }else{
                RankingCategory.FullHouse
            }

        } else if (suits.size == 1) {
            RankingCategory.Flush
        } else
            RankingCategory.Highcard
    }

    fun wins(otherHand: Hand): Boolean {
        return this.getCategoary().ranking>otherHand.getCategoary().ranking
    }
//    init{
//        require(cards.size==4)
//    }
}
enum class RankingCategory(val ranking:Int){
    Flush(1), Highcard(0), FourOfAKind(3), FullHouse(2)
}
