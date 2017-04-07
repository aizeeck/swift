package lesson4;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task3g_LargestSumSubsequence {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        int ans = 0,
                ans_l = 0,
                ans_r = 0,
                sum = 0,
                minus_pos = -1;

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            sum += arr[i];

            if (sum > ans) {
                ans = sum;
                ans_l = minus_pos + 1;
                ans_r = i;
            }

            if (sum < 0) {
                sum = 0;
                minus_pos = i;
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, ans_l, ans_r + 1)));
    }
}
