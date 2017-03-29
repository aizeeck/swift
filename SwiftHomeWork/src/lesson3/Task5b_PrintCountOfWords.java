package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task5b_PrintCountOfWords {

    private static int cntWords = 0;
    private static int spliterIndex = -1;
    private static int prevSpliterIndex = -1;
    private static String spliters = " .?!,";
    private static String str = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();

        for (int i = 1; i < str.length() - 1; i++) {
            String currentLeter = String.valueOf(str.charAt(i));
            if (!spliters.contains(String.valueOf(str.charAt(i - 1))) && spliters.contains(String.valueOf(str.charAt(i)))) {
                cntWords++;
            }
        }

        if (str.length() > 0 && cntWords < 1) {
            cntWords++;
        } else {
            cntWords++;
        }
        System.out.println(cntWords);
    }
}
