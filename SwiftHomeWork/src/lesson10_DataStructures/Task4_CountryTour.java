package lesson10_DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aizeeck on 06.05.17.
 */
public class Task4_CountryTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int citiesCount = scanner.nextInt();
        ArrayList<Integer[]> cities = new ArrayList<>();

        for (int i = 0; i < citiesCount; i++) {
            int s1 = scanner.nextInt();
            int s2 = scanner.nextInt();
            cities.add(new Integer[]{s1, s2});
        }

        int count = fuctorial(cities.size());
        int max = cities.size() - 1;
        System.out.println("var" + count);
        int shift = max;
        Integer[] tmp;
        while (count > 0) {
            tmp = cities.get(shift);
            cities.set(shift, cities.get(shift - 1));
            cities.set(shift - 1, tmp);
            print(cities);
            count--;
            if (shift < 2) {
                shift = max;
            } else {
                shift--;
            }
        }
    }

    static void print(ArrayList<Integer[]> cities) {
        cities.forEach(integers -> System.out.print(Arrays.toString(integers)));
        System.out.println("\n------------------------------------------");
    }

    static int fuctorial(int n) {
        return (n > 0) ? n * fuctorial(n - 1) : 1;
    }
}
