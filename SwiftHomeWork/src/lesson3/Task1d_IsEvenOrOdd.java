package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task1d_IsEvenOrOdd {
    public static void main(String[] args) {
        String input = "";
        int num = 0;
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.println("Enter space for exit");
            input = scanner.nextLine();
            if (input.contains(" ")) break;
            num = Integer.parseInt(input);
            if (num % 2 != 0) {
                System.out.println("ODD");
            }  else if (num % 2 == 0) {
                System.out.println("EVEN");
            }
        } while (true);
    }
}
