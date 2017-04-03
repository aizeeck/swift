package lesson4;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task4d_ConvertibleStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String target = scanner.nextLine();
        boolean isConvertable = false;

        int i = 0;
        if (target.length() <= input.length()) {
            for (int j = 0; j < target.length() && i < input.length(); j++) {
                if (target.charAt(j) == input.charAt(i)) {
                    i++;
                } else {
                    i++;
                    j--;
                }

                if (j > target.length() - 2 && i < input.length() + 1) {
                    isConvertable = true;
                }
            }
        }
        System.out.println(isConvertable);
    }
}
