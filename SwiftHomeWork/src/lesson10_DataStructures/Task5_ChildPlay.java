package lesson10_DataStructures;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aizeeck on 06.05.17.
 */
public class Task5_ChildPlay {
    public static void main(String[] args) {
        int roundCount = 0;
        ArrayList<Integer> childTall = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int childCount = scanner.nextInt();


        for (int i = 0; i < childCount; i++) {
            childTall.add(scanner.nextInt());
        }

        int tmp;
        do {
            tmp = childTall.size();
            for (int i = childTall.size() - 1; i > 1; i--) {
                if (childTall.get(i) > childTall.get(i - 1)) {
                    childTall.remove(i);
                }
            }
            if (childTall.size() != tmp) {
                roundCount++;
            }
        } while (tmp != childTall.size());

        System.out.println(roundCount);
    }
}
