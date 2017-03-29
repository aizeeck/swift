package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task3a_PrintMinAndMax {

    public static void main(String[] args) {
        int iterrations = 0;
        int min = 0;
        int max = 0;
        Scanner scanner = new Scanner(System.in);

        iterrations = scanner.nextInt();
        min = scanner.nextInt();
        max = min;
        for (int i = 1; i < iterrations; i++) {
            int tmp = scanner.nextInt();
            min = (tmp < min) ? tmp : min;
            max = (tmp > max) ? tmp : max;
        }
        System.out.println(min + " " + max);
    }
}
