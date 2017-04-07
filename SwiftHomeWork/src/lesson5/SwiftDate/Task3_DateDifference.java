package lesson5.SwiftDate;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task3_DateDifference {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SwiftDate swiftDate1 = new SwiftDate(
                scanner.nextInt(),
                scanner.nextInt(),
                scanner.nextInt()
        );

        SwiftDate swiftDate2 = new SwiftDate(
                scanner.nextInt(),
                scanner.nextInt(),
                scanner.nextInt()
        );
        System.out.println(swiftDate1.getDaysDifference(swiftDate2));
        System.out.println(swiftDate1.getInfo());
        System.out.println(swiftDate2.getInfo());
    }
}
