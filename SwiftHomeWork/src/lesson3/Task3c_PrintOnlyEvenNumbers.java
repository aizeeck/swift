package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task3c_PrintOnlyEvenNumbers {

    public static void main(String[] args) {
        int iterrations = 0;
        String outputString = "";
        Scanner scanner = new Scanner(System.in);
        iterrations = scanner.nextInt();
        for (int i = 0; i < iterrations; i++) {
            int tmp = scanner.nextInt();
            outputString += (tmp % 2 == 0) ? (tmp + " ") : "";
        }
        System.out.println(outputString);
    }
}