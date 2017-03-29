package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task1e_ReadNNumbers {
    public static void main(String[] args) {
        int iterrations = 0;
        Scanner scanner = new Scanner(System.in);
        iterrations = scanner.nextInt();
        for (int i = 0; i < iterrations; i++) {              
            System.out.println(scanner.next());
        }
    }
}
