package swiftacademy.lesson3;

import java.time.Month;
import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task2c_PrintMonth {

    public static void main(String[] args) {
        int monthId = 0;
        Scanner scanner = new Scanner(System.in);
        monthId = scanner.nextInt();

        switch (monthId) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                System.out.println(Month.of(monthId));
                break;
            default:
                System.out.println("ERROR");
        }
    }
}
