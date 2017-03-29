package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task1f_ReadNNumbersOnNewLines {

    public static void main(String[] args) {
        int iterrations = 0;
        String outputString = "";
        Scanner scanner = new Scanner(System.in);
        iterrations = scanner.nextInt();
        for (int i = 0; i < iterrations; i++) {
            outputString += (scanner.nextInt() + " ");
        }
        System.out.println(outputString);
    }
}
