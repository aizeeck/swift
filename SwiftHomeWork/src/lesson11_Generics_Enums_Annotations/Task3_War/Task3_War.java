package lesson11_Generics_Enums_Annotations.Task3_War;

import lesson11_Generics_Enums_Annotations.Task0_Cards.CardRank;
import lesson11_Generics_Enums_Annotations.Task0_Cards.CardSuit;
import lesson11_Generics_Enums_Annotations.Task1_Deck.Card;

import java.util.*;

/**
 * Created by aizeeck on 12.05.17.
 */
public class Task3_War {

    public static void main(String[] args) {
        List<ArrayDeque<Card>> cardsSets = getShuffledDeck(2);
        ArrayDeque<Card> playerOneDeck = cardsSets.get(0);
        ArrayDeque<Card> playerTwoDeck = cardsSets.get(1);
        playerOneDeck.forEach(card -> System.out.println(card));
        System.out.println();
        playerTwoDeck.forEach(card -> System.out.println(card));
        System.out.println(warGame(playerOneDeck, playerTwoDeck));
    }

    private static int warGame(ArrayDeque<Card> playerOneDeck, ArrayDeque<Card> playerTwoDeck) {
        while (!playerOneDeck.isEmpty() && !playerTwoDeck.isEmpty()) {
            System.out.println(playerOneDeck);
            System.out.println("------------------------------------------------");
            System.out.println(playerTwoDeck);
            System.out.println("================================================");
            try {
                if (playerOneDeck.peek().compareTo(playerTwoDeck.peek()) > 0) {
                    playerOneDeck.addLast(playerOneDeck.pollFirst());
                    playerOneDeck.addLast(playerTwoDeck.pollFirst());
                } else {
                    playerTwoDeck.addLast(playerTwoDeck.pollFirst());
                    playerTwoDeck.addLast(playerOneDeck.pollFirst());
                }
            } catch (NullPointerException e) {
                System.out.println(e.fillInStackTrace());
            }

        }
        System.out.println(playerOneDeck);
        System.out.println("------------------------------------------------");
        System.out.println(playerTwoDeck);
        System.out.println("================================================");
        if (playerOneDeck.isEmpty()) {
            return 2;
        } else {
            return 1;
        }
    }

    private static TreeSet<Card> getCardsSets() {

        TreeSet<Card> cards = new TreeSet<>();

        for (int i = 1; i < 5; i++) {
            for (int j = 2; j < 15; j++) {
                Card c = new Card(CardSuit.getCardSuit(i), CardRank.getCardRank(j));
                cards.add(c);
            }
        }
        return cards;
    }

    private static List<ArrayDeque<Card>> getShuffledDeck(int gamersCount) {

        List<ArrayDeque<Card>> randomCardsSets = new ArrayList<>();

        List<Card> allCards = new ArrayList<>(getCardsSets());

        Random randomGenerator = new Random();

        for (int i = 0; i < gamersCount; i++) {
            ArrayDeque<Card> cardsTmp = new ArrayDeque<>();
            while (cardsTmp.size() < 52 / gamersCount) {
                int randomInt = randomGenerator.nextInt(allCards.size());
                Card tmp = allCards.get(randomInt);
                cardsTmp.add(tmp);
                allCards.remove(tmp);
            }
            randomCardsSets.add(cardsTmp);
        }

        return randomCardsSets;
    }

}
