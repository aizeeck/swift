package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task2f_PrintMirrorNumber {

    public static void main(String[] args) {
        String input = "";
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        for (int i = input.length()-1; i >= 0; i--) {
            System.out.print(input.charAt(i));
        }
        System.out.println();
        
    }
}
