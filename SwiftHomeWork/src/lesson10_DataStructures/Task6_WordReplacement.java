package lesson10_DataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by aizeeck on 02.05.17.
 */
public class Task6_WordReplacement {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap();
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        String[] sentenceArray = sentence.split(" ");
        int mapEntryCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < mapEntryCount; i++) {
            String[] split = scanner.nextLine().split(" ");
            map.put(split[0], split[1]);
        }

        for (int i = 0; i < sentenceArray.length; i++) {
            String key = sentenceArray[i];
            if (map.containsKey(key.toLowerCase())) {
                sentenceArray[i] = map.get(key.toLowerCase());
            }
        }
        String newSentence = "";
        for (String str : sentenceArray) {
            newSentence += str + " ";
        }

        System.out.println(newSentence);

    }
}
