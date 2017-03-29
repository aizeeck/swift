package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task4a_PrintSquare {

        public static void main(String[] args) {
        int len = 0;
        Scanner scanner = new Scanner(System.in);
        len = scanner.nextInt();

        for (int j = 0; j < len; j++) {
            System.out.print("* ");
        }
        System.out.println();
        
        for (int i = 0; i < len - 2; i++) {
            System.out.print("* ");
            for (int j = 0; j < len - 2; j++) {
                System.out.print("  ");
            }
            System.out.println("* ");
        }
        
        for (int j = 0; j < len; j++) {
            System.out.print("* ");
        }
    }
    
}
