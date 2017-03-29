package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task2a_PrintSumOfN {
    
    public static void main(String[] args) {
        int iterrations = 0;
        int sum = 0;
        
        Scanner scanner = new Scanner(System.in);
        iterrations = scanner.nextInt();
        for (int i = 1; i <= iterrations; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
