package lesson4;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task4a_IsPalindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int correction = input.length() % 2 == 0 ? 0 : 1;

        String rightHalf = input.substring(input.length() / 2 + correction);
        String leftHalf = input.substring(0, input.length() / 2);

        boolean isPalindrome = true;
        for (int i = 0; i < rightHalf.length(); i++) {
            if (!(rightHalf.charAt(i) == leftHalf.charAt(rightHalf.length() - 1 - i))) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome);
    }
}
