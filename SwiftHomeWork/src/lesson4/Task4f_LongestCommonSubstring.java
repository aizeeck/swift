package lesson4;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task4f_LongestCommonSubstring {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        
        int beginF = 0;
        int endF = 0;
        int begin = 0;
        int end = 0;
        
        for (int i = 0; i < input2.length(); i++) {
            for (int j = 0; j < input2.length(); j++) {
                while (input1.contains(input2.subSequence(begin, end)) && end < input2.length()) {
                    System.err.println(input2.subSequence(begin, end));
                    System.err.println(begin + ":" + end);
                    //System.err.println("F" + beginF + ":" + endF);
                    if ((end - begin) > (endF - beginF)) {
                        //System.err.println(begin + ":" + end);
                        beginF = begin;
                        endF = end;
                    }
                    end++;
                }
            }
            begin++;
        }
        System.err.println(input2.subSequence(beginF, endF));
    }
}

/*
//
ahasjaaakxsmza
ahaooxmaaakxs

 */
