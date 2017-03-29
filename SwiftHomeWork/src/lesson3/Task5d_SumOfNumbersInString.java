package swiftacademy.lesson3;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author aizeeck
 */
public class Task5d_SumOfNumbersInString {

    public static void main(String[] args) {
        int sum = 0;
        String str = "";
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        scanner = new Scanner(str);
        while (scanner.hasNext()) {
            String s = scanner.findInLine(Pattern.compile("\\d{1,20}"));
            if (s != null) {
                sum = sum + Integer.parseInt(s);
            } else {
                break;
            }
        }
        System.out.println(sum);
    }
}