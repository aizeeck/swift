package lesson4;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task3f_LargestSumOfKSubsequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int sum = 0;
        int beginIndex = -1;

        for (int i = 0; i < N - K; i++) {
            int sumTmp = 0;
            for (int j = i; j < i + K; j++) {
                sumTmp += arr[j];
                //System.out.println("i:j - " + i + ":" + j + "; arr: " + arr[j] + "; sum: " + sumTmp);
            }
            beginIndex = sumTmp > sum ? i : beginIndex;
            sum = sum > sumTmp ? sum : sumTmp;
            //System.out.println("sum: " + sum);
        }

        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, beginIndex, beginIndex + K)));
    }

}
