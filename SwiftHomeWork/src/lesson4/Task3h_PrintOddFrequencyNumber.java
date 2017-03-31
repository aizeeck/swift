package lesson4;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task3h_PrintOddFrequencyNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        int[][] arrResults = new int[N / 2 + 1][1];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        
        boolean needCheckLast = true;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == arr[i + 1]) {
                i++;
                continue;
            } else {
                needCheckLast = false;
                System.out.println(arr[i]);
                break;
            }
        }
        if (needCheckLast) {
            System.out.println(arr[arr.length-1]);
        }
        
    }
}
