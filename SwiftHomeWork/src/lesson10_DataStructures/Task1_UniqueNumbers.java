package lesson10_DataStructures;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by aizeeck on 06.05.17.
 */
public class Task1_UniqueNumbers {
    public static void main(String[] args) {
        Set<Integer> integerSet = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        for (int i = 0; i < iterations; i++) {
            integerSet.add(scanner.nextInt());
        }
        integerSet.forEach(integer -> System.out.print(integer + " "));
    }
}
