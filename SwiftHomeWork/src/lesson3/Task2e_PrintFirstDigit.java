package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task2e_PrintFirstDigit {
    public static void main(String[] args) {
        String input = "";
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        System.out.println(input.charAt(0));
    }
}
