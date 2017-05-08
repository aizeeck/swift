package lesson10_DataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by aizeeck on 06.05.17.
 */
public class Task4_CountryTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int citiesCount = scanner.nextInt();
        Map<Integer, Integer> sities = new HashMap<>();

        for (int i = 0; i < citiesCount; i++) {
            sities.put((Integer) Integer.parseInt(scanner.nextLine()), (Integer) Integer.parseInt(scanner.nextLine()));
        }

        
    }
}
