package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task2i_ToBinaryAndHexa {

    public static void main(String[] args) {
        int input = 0;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextInt();
        System.out.println(Integer.toBinaryString(input));
        System.out.println(Integer.toHexString(input).toUpperCase());
    }
}