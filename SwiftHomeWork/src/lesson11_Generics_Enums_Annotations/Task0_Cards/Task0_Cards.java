package lesson11_Generics_Enums_Annotations.Task0_Cards;

import java.util.Arrays;

/**
 * Created by aizeeck on 09.05.17.
 */
public class Task0_Cards {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(CardSuit.values()));
        System.out.println(Arrays.toString(CardRank.values()));
    }
}
