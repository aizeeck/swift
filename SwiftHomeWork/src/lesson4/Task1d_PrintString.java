package lesson4;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task1d_PrintString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (char c : input.toCharArray()) {
            System.out.println(c);
        }
    }
}
