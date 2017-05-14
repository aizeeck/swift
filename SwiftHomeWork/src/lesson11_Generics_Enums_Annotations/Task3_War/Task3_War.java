package lesson11_Generics_Enums_Annotations.Task3_War;

import lesson11_Generics_Enums_Annotations.Task0_Cards.CardRank;
import lesson11_Generics_Enums_Annotations.Task0_Cards.CardSuit;
import lesson11_Generics_Enums_Annotations.Task1_Deck.Card;

import java.util.*;

/**
 * Created by aizeeck on 12.05.17.
 */
public class Task3_War {

    private ArrayDeque<Card> playerOneDeckTmp = new ArrayDeque<>();
    private ArrayDeque<Card> playerTwoDeckTmp = new ArrayDeque<>();

    public static void main(String[] args) {
//        List<ArrayDeque<Card>> cardsSets = getShuffledDeck(2);
//        ArrayDeque<Card> playerOneDeck = cardsSets.get(0);
//        ArrayDeque<Card> playerTwoDeck = cardsSets.get(1);

        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();

        scanner.nextLine();
        String str = scanner.nextLine();
        ArrayDeque<Card> playerOneDeck = createDeckFromString(str);
        str = scanner.nextLine();
        ArrayDeque<Card> playerTwoDeck = createDeckFromString(str);

        Task3_War war = new Task3_War();
        war.warGame(playerOneDeck, playerTwoDeck);

    }

    private void warGame(ArrayDeque<Card> playerOneDeck, ArrayDeque<Card> playerTwoDeck) {
        int roundCnt = 0;
        while (!playerOneDeck.isEmpty() && !playerTwoDeck.isEmpty()) {
            printPlayersDeck(playerOneDeck, playerTwoDeck);
            swapCards(playerOneDeck, playerTwoDeck, 1);
            roundCnt++;
        }

        printPlayersDeck(playerOneDeck, playerTwoDeck);
        if (playerOneDeck.isEmpty() && playerTwoDeck.isEmpty()) {
            System.out.println("Game is draw on round " + roundCnt + ".");
        } else if (playerOneDeck.isEmpty()) {
            System.out.println("Player 2 wins on round " + roundCnt + ".");
        } else {
            System.out.println("Player 1 wins on round " + roundCnt + ".");
        }
    }

    private static void printPlayersDeck(ArrayDeque<Card> playerOneDeck, ArrayDeque<Card> playerTwoDeck) {
        System.out.println(playerOneDeck);
        System.out.println("------------------------------------------------");
        System.out.println(playerTwoDeck);
        System.out.println("================================================");
    }

    private void swapCards(ArrayDeque<Card> playerOneDeck, ArrayDeque<Card> playerTwoDeck, int warriorsCount) {
        int currentWarrior = 0;
        int totalStrengthPlayerOne = 0;
        int totalStrengthplayerTwo = 0;
//        ArrayDeque<Card> playerOneDeckTmp = new ArrayDeque<>();
//        ArrayDeque<Card> playerTwoDeckTmp = new ArrayDeque<>();

        while (currentWarrior < warriorsCount && !playerOneDeck.isEmpty() && !playerTwoDeck.isEmpty()) {
            totalStrengthPlayerOne += playerOneDeck.peek().getCardRank().getStrength();
            totalStrengthplayerTwo += playerTwoDeck.peek().getCardRank().getStrength();
            playerOneDeckTmp.addLast(playerOneDeck.pollFirst());
            playerTwoDeckTmp.addLast(playerTwoDeck.pollFirst());
            currentWarrior++;
        }

        if (totalStrengthPlayerOne + totalStrengthPlayerOne == 0) {
            return;
        }

        if (totalStrengthPlayerOne > totalStrengthplayerTwo) {
            playerOneDeckTmp.forEach(card -> playerOneDeck.addLast(card));
            playerTwoDeckTmp.forEach(card -> playerOneDeck.addLast(card));
            emptyTmpDecks();
        } else if (totalStrengthPlayerOne == totalStrengthplayerTwo) {
            int playerOneDeckInitSize = playerOneDeck.size();
            int playerTwoDeckInitSize = playerOneDeck.size();
            swapCards(playerOneDeck, playerTwoDeck, 3);
            if (playerOneDeck.size() > playerOneDeckInitSize) {
                playerOneDeckTmp.forEach(card -> playerOneDeck.addLast(card));
                playerTwoDeckTmp.forEach(card -> playerOneDeck.addLast(card));
                emptyTmpDecks();
            } else if (playerTwoDeck.size() > playerTwoDeckInitSize) {
                playerTwoDeckTmp.forEach(card -> playerTwoDeck.addLast(card));
                playerOneDeckTmp.forEach(card -> playerTwoDeck.addLast(card));
                emptyTmpDecks();
            } else {
                return;
            }
        } else {
            playerTwoDeckTmp.forEach(card -> playerTwoDeck.addLast(card));
            playerOneDeckTmp.forEach(card -> playerTwoDeck.addLast(card));
            emptyTmpDecks();
        }
    }

    private void emptyTmpDecks() {
        playerOneDeckTmp.clear();
        playerTwoDeckTmp.clear();
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

    private static ArrayDeque<Card> createDeckFromString(String description) {
        Map<Character, String> suitMap = new HashMap<>();
        Map<Character, String> rankMap = new HashMap<>();

        suitMap.put('c', "Clubs");
        suitMap.put('d', "Diamonds");
        suitMap.put('h', "Hearts");
        suitMap.put('s', "Spades");

        rankMap.put('2', "Two");
        rankMap.put('3', "Three");
        rankMap.put('4', "Four");
        rankMap.put('5', "Five");
        rankMap.put('6', "Six");
        rankMap.put('7', "Seven");
        rankMap.put('8', "Eight");
        rankMap.put('9', "Nine");
        rankMap.put('T', "Ten");
        rankMap.put('J', "Jack");
        rankMap.put('Q', "Queen");
        rankMap.put('K', "King");
        rankMap.put('A', "Ace");


        ArrayDeque<Card> cardArrayDeque = new ArrayDeque<>();
        String[] tmp = description.split(" ");
        List<String> cardsStrings = Arrays.asList(tmp);
        for (String cardString : cardsStrings) {
            char cardRankChar = cardString.charAt(0);
            char cardSuitChar = cardString.charAt(1);
            cardArrayDeque.addLast(new Card(
                    CardSuit.valueOf(suitMap.get(cardSuitChar)),
                    CardRank.valueOf(rankMap.get(cardRankChar))));
        }
        return cardArrayDeque;
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
