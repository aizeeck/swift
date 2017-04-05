package lesson4;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task4e_BracketMatching {

    public static void main(String[] args) {
        char[] definitions = {
            '(',
            ')',
            '[',
            ']',
            '{',
            '}'
        };
        Scanner scanner = new Scanner(System.in);
        char[] brackets = scanner.nextLine().toCharArray();
        boolean[] substitute = new boolean[brackets.length];

        if (brackets[0] == definitions[1]
                || brackets[0] == definitions[3]
                || brackets[0] == definitions[5]) {
            return;
        }
        
        for (int i = 1; i < substitute.length; i++) {
            char currentType = 0;
            if (brackets[i] == definitions[1]) {
                currentType = definitions[0];
            } else if (brackets[i] == definitions[3]) {
                currentType = definitions[2];
            } else if (brackets[i] == definitions[5]) {
                currentType = definitions[4];
            }
            if (brackets[i] == definitions[1]
                    || brackets[i] == definitions[3]
                    || brackets[i] == definitions[5]) {
                substitute[i] = true;
                for (int j = i - 1; j >= 0; j--) {
                    while (substitute[j] == true) {
                        j--;
                    }
                    if (substitute[j] == false && brackets[j] == currentType) {
                        substitute[j] = true;
                        break;
                    } else {
                        System.out.println(false);
                        return;
                    }
                }
            }
        }
        System.out.println(true);
    }
}
