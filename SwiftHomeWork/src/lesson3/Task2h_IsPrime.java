package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task2h_IsPrime {

    public static void main(String[] args) {
        int input = 0;
        Scanner scanner = new Scanner(System.in);
        boolean isPrime = true;
        input = scanner.nextInt();
        if (input <= 1) {
            System.out.println(false);
        } else {
            for (int i = 2; i < input; i++) {
                if (input % i == 0) {
                    isPrime = false;
                }
            }
            System.out.println(isPrime);
        }
    }
}