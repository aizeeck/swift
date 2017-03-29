package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task2b_PrintNonDivisors {

    public static void main(String[] args) {
        int iterrations = 0;
        String outputString = "";
        Scanner scanner = new Scanner(System.in);
        iterrations = scanner.nextInt();
        for (int i = 1; i <= iterrations; i++) {
            if (i % 3 != 0 && i % 7 != 0) {
                outputString += (i + " ");
            }
        }
        System.out.println(outputString);
    }
}
