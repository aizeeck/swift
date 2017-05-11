package lesson11_Generics_Enums_Annotations.Task0_Cards;

/**
 * Created by aizeeck on 09.05.17.
 */
public enum CardRank implements Comparable<CardRank> {

    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8),
    Nine(9),
    Ten(10),
    Jack(11),
    Queen(12),
    King(13),
    Ace(14);

    private final int strength;

    CardRank(int i) {
        this.strength = i;
    }

    public int getStrength() {
        return strength;
    }

    public static CardRank getCardRank(int i) {
        switch (i) {
            case 2:
                return Two;
            case 3:
                return Three;
            case 4:
                return Four;
            case 5:
                return Five;
            case 6:
                return Six;
            case 7:
                return Seven;
            case 8:
                return Eight;
            case 9:
                return Nine;
            case 10:
                return Ten;
            case 11:
                return Jack;
            case 12:
                return Queen;
            case 13:
                return King;
            case 14:
                return Ace;
            default:
                return null;
        }
    }
}
