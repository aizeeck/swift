package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task5c_PrintEverySentence {

    private static String str = "";
    private static int spliterIndex = -1;
    private static int prevSpliterIndex = -1;
    private static String spliters = ".!?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();

        do {
            prevSpliterIndex = spliterIndex + 1;

            int tmp = 0;
            int prevtmp = 0;
            for (int i = 0; i < spliters.length(); i++) {
                tmp = str.indexOf(spliters.charAt(i), prevSpliterIndex);
                if (tmp > 0 && prevtmp > 0) {
                    prevtmp = Math.min(tmp, prevtmp);
                } else if (tmp > 0 && prevtmp == 0) {
                    prevtmp = tmp;
                }

                if (tmp > 0 && prevtmp > 0) {
                    spliterIndex = Math.min(tmp, prevtmp);
                }
            }

            if (tmp < spliterIndex && prevtmp < spliterIndex) {
                spliterIndex = -1;
            }

            if (spliterIndex > 0) {
                System.out.println(str.substring(prevSpliterIndex, spliterIndex + 1).trim());
            } else {
                System.out.println(str.substring(prevSpliterIndex).trim());
                break;
            }

        } while (spliterIndex > 0);
    }
}
