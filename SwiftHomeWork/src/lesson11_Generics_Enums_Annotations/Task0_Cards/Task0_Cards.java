package lesson11_Generics_Enums_Annotations.Task0_Cards;

import lesson11_Generics_Enums_Annotations.Task1_Deck.Card;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by aizeeck on 09.05.17.
 */
public class Task0_Cards {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(CardSuit.values()));
        System.out.println(Arrays.toString(CardRank.values()));

        TreeSet<Card> cards = new TreeSet<>();

        for (int i = 1; i < 5; i++) {
            for (int j = 2; j < 15; j++) {
                Card c = new Card(CardSuit.getCardSuit(i), CardRank.getCardRank(j));
                cards.add(c);
            }
        }

        System.out.println(cards.size());
        cards.forEach(card -> System.out.println(card));
    }
}