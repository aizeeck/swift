package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task2d_PrintAllDivisors {

    public static void main(String[] args) {
        int iterrations = 0;
        String outputString = "";
        Scanner scanner = new Scanner(System.in);
        iterrations = scanner.nextInt();
        for (int i = 1; i <= iterrations; i++) {
            if (iterrations % i == 0) {
                outputString += (i + " ");
            }
        }
        System.out.println(outputString);
    }
}
