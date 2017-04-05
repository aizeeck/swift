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

        int open = 0;
        int close = 0;
        int currentPosition = 0;
        if (brackets[0] == definitions[1]
                || brackets[0] == definitions[3]
                || brackets[0] == definitions[5]) {
            System.out.println("default: " + false);
            return;
        }
        
        for (int i = 1; i < substitute.length; i++) {
            currentPosition = i;
            char currentType = 0;
            if (brackets[i] == definitions[1]) {
                currentType = definitions[0];
            } else if (brackets[i] == definitions[3]) {
                currentType = definitions[2];
            } else if (brackets[i] == definitions[5]) {
                currentType = definitions[4];
            }
            System.out.println("i:" + i + "; brackets[i]" + brackets[i] + "; substitute[i]" + substitute[i]);
            if (brackets[i] == ')'
                    || brackets[i] == '}'
                    || brackets[i] == ']') {
                System.out.println("    i:" + i);
                substitute[i] = true;
                for (int j = i - 1; j >= 0; j--) {
                    while (substitute[j] == true) {
                        j--;
                    }
                    if (substitute[j] == false && brackets[j] == currentType) {
                        substitute[j] = true;
                        break;
                    } else {
                        System.out.println("i:" + i + "; j:" + j);
                        System.out.println("deep: " + false);
                        return;
                    }
                }
            }
        }
        System.out.println(true);
    }
}
