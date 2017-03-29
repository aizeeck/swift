package lesson4;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task3c_PrintClusterCount {

    public static void main(String[] args) {
        int clusterCounter = 0;
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] == arr[i - 1] && arr[i] != arr[i + 1]) {
                clusterCounter++;
            }

        }
        if (arr[arr.length - 1] == arr[arr.length - 2]) {
            clusterCounter++;
        }
        System.out.println(clusterCounter);
    }

}
