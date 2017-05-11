package lesson11_Generics_Enums_Annotations.Task0_Cards;

/**
 * Created by aizeeck on 09.05.17.
 */
public enum CardSuit {

    Clubs(1),
    Diamonds(8),
    Hearts(57),
    Spades(400);

    private final int dummyValue;

    CardSuit(int dummyValue) {
        this.dummyValue = dummyValue;
    }

    public int getDummyValue() {
        return dummyValue;
    }

    public static CardSuit getCardSuit(int i) {
        switch (i) {
            case 1:
                return Clubs;
            case 2:
                return Diamonds;
            case 3:
                return Hearts;
            case 4:
                return Spades;
            default:
                return null;
        }
    }
}
