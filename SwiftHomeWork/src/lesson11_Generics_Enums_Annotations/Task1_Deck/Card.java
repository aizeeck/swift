package lesson11_Generics_Enums_Annotations.Task1_Deck;

import lesson11_Generics_Enums_Annotations.Task0_Cards.CardRank;
import lesson11_Generics_Enums_Annotations.Task0_Cards.CardSuit;

/**
 * Created by aizeeck on 09.05.17.
 */
public class Card implements Comparable<Card> {

    private CardSuit cardSuit;
    private CardRank cardRank;

    public Card(CardSuit cardSuit, CardRank cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    @Override
    public int compareTo(Card o) {
        return this.hashCode() - o.hashCode();
    }

    @Override
    public String toString() {
        return cardRank.toString() + " of " + cardSuit.toString();
    }

    @Override
    public int hashCode() {
        return this.cardSuit.getDummyValue() * this.cardRank.getStrength();
    }
}
