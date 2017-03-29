package swiftacademy.lesson3;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author aizeeck
 */
public class Task5a_StringWoVowels {

    public static void main(String[] args) {
        String str = "";
        String vowels = "aeiouy";
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        for (char c : vowels.toCharArray()) {
            str = str.replace(String.valueOf(c), "");
        }

        System.out.println(str);
    }
}
