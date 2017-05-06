package lesson10_DataStructures;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by aizeeck on 06.05.17.
 */
public class Task2_CommonSubset {
    public static void main(String[] args) {
        Set<Integer> commonSet = new HashSet<>();
        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();

        Scanner scanner = new Scanner(System.in);
        int firstSequence = scanner.nextInt();
        int secondSequence = scanner.nextInt();

        for (int i = 0; i < firstSequence; i++) {
            firstSet.add(scanner.nextInt());
        }

        for (int i = 0; i < secondSequence; i++) {
            secondSet.add(scanner.nextInt());
        }

        secondSet.retainAll(firstSet);
        if (secondSet.size() < 1) {
            System.out.println("NO");
        } else {
            secondSet.forEach(integer -> System.out.print(integer + " "));
        }
    }
}
