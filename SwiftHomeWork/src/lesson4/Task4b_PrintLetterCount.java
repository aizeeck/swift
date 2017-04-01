package lesson4;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task4b_PrintLetterCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        char[] chars = input.toLowerCase().toCharArray();
        Arrays.sort(chars);

        for (int i = 1; i < chars.length; i++) {
            int counter = 1;
            while ((chars[i] == chars[i - 1])) {
                counter++;
                i++;
                if (i >= chars.length) {
                    break;
                }
            }
            System.out.printf("%s(%d)\n", chars[i - 1], counter);
        }

        if (chars[chars.length - 1] != chars[chars.length - 2]) {
            System.out.printf("%s(%d)\n", chars[chars.length - 1], 1);
        }
    }
}
