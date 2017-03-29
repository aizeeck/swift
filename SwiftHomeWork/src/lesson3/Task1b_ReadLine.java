package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task1b_ReadLine {
        public static void main(String[] args) {
        String input = "";
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        System.out.println("Your input was:" + input);
    }
}
