package lesson4;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task3a_PrintLargestNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int max = scanner.nextInt();
        int current = 0;
        for (int i = 0; i < N-1; i++) {
            current = scanner.nextInt();
            max = max < current ? current : max;
        }
        System.out.println(max);
    }
}
