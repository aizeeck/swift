package lesson10_DataStructures;

import java.io.StringReader;
import java.util.*;

/**
 * Created by aizeeck on 03.05.17.
 */

public class Task9_ExpressionCalculator_v_2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        List<List<String>> signs = new ArrayList<>();
        signs.add(Arrays.asList("^", "dummy"));
        signs.add(Arrays.asList("*", "/"));
        signs.add(Arrays.asList("+", "-"));

        while (expression.contains("(")) {
            expression = normalizeInBrackets(expression);
        }

        for (List<String> ss : signs) {
            int repetitionCnt = 0;
            while (expression.contains(ss.get(0)) || expression.contains(ss.get(1))) {
                String prevExpression = expression;

                int s0 = expression.indexOf(ss.get(0));
                int s1 = expression.indexOf(ss.get(1));
                if (s0 > 0 && s1 > 0 && s1 < s0) {
                    String tmp = ss.get(0);
                    ss.set(0, ss.get(1));
                    ss.set(1, tmp);
                }
                if (s0 < 0 && s1 > 0) {
                    String tmp = ss.get(0);
                    ss.set(0, ss.get(1));
                    ss.set(1, tmp);
                }
                for (String s : ss) {
                    if (!expression.contains(s)) {
                        break;
                    }
                    s0 = expression.indexOf(ss.get(0));
                    s1 = expression.indexOf(ss.get(1));
                    if (s0 > 0 && s1 > 0 && s1 < s0) {
                        String tmp = ss.get(0);
                        ss.set(0, ss.get(1));
                        ss.set(1, tmp);
                    }
                    ArrayList<Integer> tmp = signsListIndexes(expression, s);
                    for (int i = 0; i < tmp.size(); i++) {
                        boolean isValueSet = false;
                        ArrayList<Integer> currentSignIndex = signsListIndexes(expression, s);
                        StringBuffer buffer = new StringBuffer();
                        ArrayList<Integer> allSignsInexes = signsIndexes(expression);
                        int left = 0;
                        try {
                            left = allSignsInexes.get(allSignsInexes.indexOf(currentSignIndex.get(0)) - 1) + 1;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            left = 0;
                        }

                        int right = 0;
                        try {
                            right = allSignsInexes.get(allSignsInexes.indexOf(currentSignIndex.get(0)) + 1);
                        } catch (IndexOutOfBoundsException e) {
                            right = expression.length() + 1;
                        }

                        String subExpression = expression.substring(left == 0 ? 0 : left, right - 1);
                        double value = calculateSimple(subExpression);

                        if (left == 0) {
                            if (!isValueSet) {
                                buffer.append(value);
                                isValueSet = true;
                            }
                        } else {
                            buffer.append(expression.substring(0, left + 1));
                        }

                        if (right < expression.length()) {
                            if (!isValueSet) {
                                buffer.append(value);
                                isValueSet = true;
                            }
                            buffer.append(expression.substring(right - 1, expression.length()));
                        } else {
                            if (String.valueOf(value).equals(buffer.toString())) {
                                expression = buffer.toString();
                                break;
                            } else {
                                if (!isValueSet) {
                                    buffer.append(value);
                                    isValueSet = true;
                                }
                            }
                        }
                        expression = buffer.toString();
                    }
                }
                try {
                    Double.parseDouble(expression);
                    break;
                } catch (NumberFormatException e) {

                }
                /*if (expression.equals(prevExpression)) {
                    if (repetitionCnt > 1) {
                        break;
                    }
                    repetitionCnt++;
                }*/
            }
        }
        System.out.println(expression);
    }

    private static String normalizeInBrackets(String expression) {
        String normalizedExpression = "";
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] expressionArray = expression.toCharArray();

        int left = 0;
        int right = 0;

        for (int i = 0; i < expressionArray.length; i++) {
            if (stack.size() == 0 && '(' == expressionArray[i]) {
                left = i;
                stack.push(expressionArray[i]);
            } else if (stack.size() > 0 && ')' == expressionArray[i]) {
                if (stack.peek() == '(') {
                    stack.pop();
                    right = i;
                    normalizedExpression = new String(Arrays.copyOfRange(expressionArray, left + 1, right));
                    double value = calculateSimple(normalizedExpression);
                    if (left > 0) {
                        normalizedExpression = expression.substring(0, left);
                    } else {
                        normalizedExpression = "";
                    }
                    normalizedExpression += value;
                    if (right < expression.length() - 1) {
                        normalizedExpression += expression.substring(right + 1, expression.length());
                    }
                    break;
                }
            }
        }
        return normalizedExpression;
    }

    private static double calculateSimple(String simpleExpression) {
        Scanner reader = new Scanner(new StringReader(simpleExpression));
        double operand1 = reader.nextDouble();
        reader.next();
        double operand2 = reader.nextDouble();

        if (simpleExpression.contains("^")) {
            return Math.pow(operand1, operand2);
        } else if (simpleExpression.contains("*")) {
            return operand1 * operand2;
        } else if (simpleExpression.contains("/")) {
            return operand1 / operand2;
        } else if (simpleExpression.contains("+")) {
            return operand1 + operand2;
        } else if (simpleExpression.contains("-")) {
            return operand1 - operand2;
        }
        return 0;
    }

    private static ArrayList<Integer> signsIndexes(String expression) {
        String signsDefinition = "^*/+";
        ArrayList<Integer> signsIndexes = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (signsDefinition.contains(String.valueOf(expression.charAt(i)))) {
                signsIndexes.add(i);
                continue;
            }
            if (expression.charAt(i) == '-' && expression.charAt(i + 1) == ' ') {
                signsIndexes.add(i);
                continue;
            }
        }
        return signsIndexes;
    }

    private static ArrayList<Integer> signsListIndexes(String expression, String signsDefinition) {
        ArrayList<Integer> signsIndexes = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (signsDefinition.contains(String.valueOf(expression.charAt(i)))) {
                signsIndexes.add(i);
                continue;
            }
        }
        return signsIndexes;
    }
}

/*
(5 + 3) * 2 - 11 / 2^2
(5 + 3) * (2 + 11) * 2 ^ 2
8 * (2 - 11)
(5 + 3) * 2 - 11 / 2 ^ 2
*/