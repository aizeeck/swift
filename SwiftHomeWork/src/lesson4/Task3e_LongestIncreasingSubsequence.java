package lesson4;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task3e_LongestIncreasingSubsequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int i = 0;
        int[][] results = new int[N][];
        int resultCounter = 0;

        for (int j = i; j < arr.length - 1; j++) {
            int begin = j;
            int end = 0;
            boolean isForCopy = false;
            while (arr[i] < arr[i + 1]) {
                end = ++i;
                isForCopy = true;
            }
            if (isForCopy) {
                results[resultCounter++] = Arrays.copyOfRange(arr, begin - 1, end + 1);
                isForCopy = false;
            }
            i++;
            j = i;
        }

        int maxResultIndex = -1;
        int maxResultLen = 0;
        for (int j = 0; j <= resultCounter - 1; j++) {
            if (results[j].length > maxResultLen) {
                maxResultIndex = j;
                maxResultLen = results[j].length;
            }

        }
        System.out.println(Arrays.toString(results[maxResultIndex]));
    }
}
