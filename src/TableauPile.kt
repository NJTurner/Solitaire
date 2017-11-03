/**
 * Created by nicholasturner on 11/1/17.
 */
class TableauPile(var cards: MutableList<Card> = mutableListOf()) {
    init {
        if (cards.size>0)
        cards.last().faceUp = true
    }

    //If there are cards in the tableau pile, and the first new card meets the criteria. add new cards and return true
    fun addCards(newCards: MutableList<Card>): Boolean {
        if(cards.size > 0) {
            if (newCards.first().value == cards.last().value - 1 && suitCheck(newCards.first(), cards.last())) {
                cards.addAll(newCards)
                return true
            }
            //if tableau pile is empty but the first new card is a king, then add the new cards and return true
        } else if (newCards.first().value == 12){
            cards.addAll(newCards)
            return true
        }
        return false
    }

    fun removeCards(tappedIndex:Int){
        for (i in tappedIndex..cards.lastIndex){
            cards.removeAt(tappedIndex)
        }
        if (cards.size > 0){
            cards.last().faceUp = true
        }
    }

    private fun suitCheck(c1: Card, c2: Card): Boolean {
        if((redSuits.contains(c1.suit) && blackSuits.contains(c2.suit) ) ||
                (blackSuits.contains(c1.suit) && redSuits.contains(c2.suit))){
            return true
        }
        return false
    }
}