package swiftacademy.lesson4;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task1c_ReadArray {

    public static void main(String[] args) {
        int[] arr;
        int arrLen = 0;
        Scanner scanner = new Scanner(System.in);
        arrLen = scanner.nextInt();
        arr = new int[arrLen];
        for (int i = 0; i < arrLen; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }
}
