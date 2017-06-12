package lesson16_Regex_Lambda_JUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aizeeck on 11.06.17.
 */
public class Task2_FilterFiles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String line = new String();
        for (int i = 0; i < Integer.parseInt(line); i++) {
            list.add(scanner.nextLine());
        }

    }

    public void printPicturesNames(List<String> files) {
        for (String s : files) {
            Pattern pattern = Pattern.compile(".*jpeg)");
            Matcher matcher = pattern.matcher(s);

        }
    }
}
