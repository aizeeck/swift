package lesson16_Regex_Lambda_JUnit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aizeeck on 10.06.17.
 */
public class Task1b_FindFunnyCharacters {
    public static void main(String[] args) {
        String funnyString = " this9, -is 645 t☢est -65 str--987☢565~!@#$%^&*()_+-=/\\ing ";
        Pattern pattern = Pattern.compile("(\\w)()");
        Matcher matcher = pattern.matcher(funnyString);
        while (matcher.find()) {
            System.out.printf("Found match [%s] at index [%d]%n",
                    matcher.group(), matcher.start());
        }
    }
}
