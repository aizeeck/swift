package lesson4;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task4c_CaesarCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String todo = scanner.nextLine();
        String result = "";
        String delimiters = ",.!? ";
        switch (todo) {
            case "encode":
                for (int i = 0; i < input.length(); i++) {
                    if (delimiters.contains(String.valueOf(input.charAt(i)))) {
                        result += String.valueOf(input.charAt(i));
                    } else {
                        result += String.valueOf((char) (input.charAt(i) + 1));
                    }
                }
                break;
            case "decode":
                for (int i = 0; i < input.length(); i++) {
                    if (delimiters.contains(String.valueOf(input.charAt(i)))) {
                        result += String.valueOf(input.charAt(i));
                    } else {
                        result += String.valueOf((char) (input.charAt(i) - 1));
                    }
                }
                break;
        }
        System.out.println(result);
    }
}
