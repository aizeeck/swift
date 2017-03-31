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
        int[][] stat = new int[N][3];
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
                //System.out.println("   arr: " + arr[i]);
                end = ++i;
                //System.out.println("end: " + end);
                isForCopy = true;
            }
            System.out.println(isForCopy);
            if (isForCopy) {
                System.out.println("  begin: " + begin + "; end: " + end);
                results[resultCounter++] = Arrays.copyOfRange(arr, begin - 1, end + 1);
                System.out.println(Arrays.toString(results[resultCounter]));
                isForCopy = false;
            }
            i++;

            j = i;
        }

        int maxResultIndex = -1;
        System.out.println("resSize: " + results.length);
        for (int j = 0; j <= resultCounter - 1; j++) {
            System.out.println(Arrays.toString(results[j]));
            maxResultIndex = results[j].length > maxResultIndex ? j : maxResultIndex;
        }

        System.out.println("            result is: " + Arrays.toString(results[maxResultIndex]));
    }
}
