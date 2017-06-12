package lesson16_Regex_Lambda_JUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aizeeck on 10.06.17.
 */
public class Task1a_FindIntegers {
    public static void main(String[] args) {
        String line = " this9, -is 645 test -65 str--987565ing ";
        Task1a_FindIntegers findIntegers = new Task1a_FindIntegers();
        List<Integer> numbers = findIntegers.retrieveNumbers(line);
        numbers.forEach(integer -> System.out.println(integer));
    }

    public List<Integer> retrieveNumbers(String str) {
        List<Integer> res = new ArrayList<>();
        Pattern pattern = Pattern.compile("-?\\d+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            res.add(Integer.parseInt(matcher.group()));
        }
        return res;
    }
}