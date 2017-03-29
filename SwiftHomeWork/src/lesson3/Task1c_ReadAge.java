package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task1c_ReadAge {
    public static void main(String[] args) {
        int age = 0;
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.println("Enter 0 for exit");
            age = scanner.nextInt();
                    if (age < 0) {
            System.out.println("ERROR");
            } else if (age < 18) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        } while (age != 0);
    }
}
