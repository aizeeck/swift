package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task4c_PrintChristmasTree {

    public static void main(String[] args) {
        int len = 0;
        Scanner scanner = new Scanner(System.in);
        len = scanner.nextInt();

        for (int i = 1; i < len - 1; i++) {

            for (int j = 1; j < (len - i - 1); j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < (1 + (i - 1) * 2); j++) {
                System.out.print("*");
            }

            System.out.println();

        }

        for (int i = 1; i < len - 1; i++) {

            for (int j = 1; j < (len - i - 1); j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < (1 + (i - 1) * 2); j++) {
                System.out.print("*");
            }
            
            System.out.println();
            if (i > 1) {
                break;
            }
        }

    }
}
// n = 1 + (row-1)*2
// 3 = 1 + (  2-1)*2
// 5 = 1 + (  3-1)*2

