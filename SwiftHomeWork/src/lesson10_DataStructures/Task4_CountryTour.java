package lesson10_DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aizeeck on 06.05.17.
 */
public class Task4_CountryTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int citiesCount = scanner.nextInt();
        List<Integer[]> cities = new ArrayList<>();
        List<List<Integer[]>> citiesVariant = new ArrayList<>();

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
            citiesVariant.add(new ArrayList<>(cities));
            count--;
            if (shift < 2) {
                shift = max;
            } else {
                shift--;
            }
        }

        List<List<Integer[]>> goodPaths = new ArrayList<>();

        for (List<Integer[]> currentVar : citiesVariant) {
            if (isGoodPath(currentVar)) {
                goodPaths.add(currentVar);
            }
        }


        goodPaths.forEach(goodPath -> print(goodPath));
    }
//    ...............................................................

    private static boolean isGoodPath(List<Integer[]> currentVar) {
        int food = currentVar.get(0)[1];
        for (int i = 1; i < currentVar.size(); i++) {
            food = food - currentVar.get(i)[1];
            if (food >= 0) {
//                int wayLength = currentVar.get(i + 1)[0];
                food += currentVar.get(i)[1];
                continue;
            } else {
                return false;
            }


        }
        return true;
    }

    static void print(List<Integer[]> cities) {
        cities.forEach(integers -> System.out.print(Arrays.toString(integers)));
        System.out.println("\n------------------------------------------");
    }

    static int fuctorial(int n) {
        return (n > 0) ? n * fuctorial(n - 1) : 1;
    }
}
