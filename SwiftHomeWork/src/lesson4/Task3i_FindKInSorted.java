package lesson4;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task3i_FindKInSorted {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] arr = new int[N];

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

        int left = 0;
        int mid = 0;
        int right = arr.length;
        int iter = 0;
        int indexOf = -1;
        do {
            iter++;
            mid = left + (right - left) / 2;
            if (mid >= N) {break;}
            
            if (K < arr[mid]) {
                right = mid;
            } else if (K > arr[mid]) {
                left = mid + 1;
            } else {
                indexOf = mid;
                break;
            }
        } while (left != mid);
        if (indexOf > 0) {
            System.out.println("resultIndex: " + mid + "\niterations:" + iter);
        } else {
            System.out.println("resultIndex: " + "NO" + "\niterations:" + iter);
        }
        

    }
}
