package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task2g_PrintSumOfDigits {

    public static void main(String[] args) {
        String input = "";
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            sum += Integer.parseInt(input.charAt(i) + "");
        }
        System.out.print(sum + "\n");
    }
}