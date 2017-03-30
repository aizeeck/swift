package lesson4;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task3d_PrintSplitIndex {

    public static void main(String[] args) {
        int sum = 0;
        boolean found= false;
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        
        int half = sum / 2;
        sum = 0;
        //System.out.println("half: " + half);
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            //System.out.println("sum: " + sum);
            if (sum == half) {
                System.out.println(i);
                found = true;
                break;
            }
        }
        if (!found) {System.out.println("NO");}
    }
}
