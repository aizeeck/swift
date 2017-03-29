package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task1a_ReadInt {
    public static void main(String[] args) {
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        i = scanner.nextInt();
        System.out.println(++i);
    }
}
