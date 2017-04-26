package lesson10;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by aizeeck on 25.04.17.
 */
public class SumLastSixAdded_upd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();

        int x = scanner.nextInt();
        while (x != 0) {
            int idx = 0;
            for (; idx < list.size(); idx++) {
                if (x < list.get(idx)) {
                    break;
                }
            }
            list.add(idx, x);

            System.out.println(list);
            x = scanner.nextInt();
        }
    }
}
