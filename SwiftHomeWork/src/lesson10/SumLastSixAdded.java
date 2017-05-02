package lesson10;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by aizeeck on 25.04.17.
 */
public class SumLastSixAdded {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();

        int sum = 0;
        int x = 0;
        do {
            x = scanner.nextInt();
            list.addFirst(x);
            int border = Math.min(list.size(), 6);
            for (int i = 0; i< border; i++) {
                sum += list.get(i);
            }
            System.out.println(sum);
            sum = 0;
        } while (x != 0);

    }
}
