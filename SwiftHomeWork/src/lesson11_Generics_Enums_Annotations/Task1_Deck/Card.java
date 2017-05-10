package lesson11_Generics_Enums_Annotations.Task1_Deck;

import lesson11_Generics_Enums_Annotations.Task0_Cards.CardRank;
import lesson11_Generics_Enums_Annotations.Task0_Cards.CardSuit;

/**
 * Created by aizeeck on 09.05.17.
 */
public class Card implements Comparable<Card> {

    private CardSuit cardSuit;
    private CardRank cardRank;

    @Override
    public int compareTo(Card o) {
        return 0;
    }
}
