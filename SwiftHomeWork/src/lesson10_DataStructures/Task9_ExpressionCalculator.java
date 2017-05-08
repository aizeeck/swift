package lesson10_DataStructures;

import java.io.StringReader;
import java.util.*;

/**
 * Created by aizeeck on 03.05.17.
 */
/*
    0. Отделен метод за степените - който работи при липса на интервали преди и след '^'!
    1. не работи изваждането!
    2. след точка 1 - REFACTORING ! ! !


 */
public class Task9_ExpressionCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        List<List<String>> signs = new ArrayList<>();
        signs.add(Arrays.asList("^", "dummy"));
        signs.add(Arrays.asList("*", "/"));
        signs.add(Arrays.asList("+", "-"));

        for (List<String> ss : signs) {
            while (expression.contains(ss.get(0)) || expression.contains(ss.get(1))) {
                if (expression.contains("(")) {
                    while (expression.contains("(")) {
                        expression = normalizeInBrackets(expression);
                    }
                } else {
                    expression = putBrackets(expression, ss);
                }
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

    private static String putBrackets(String expression, List<String> signs) {
        String digitsForLeft = "0123456789.-";
        String digitsForRight = "0123456789. -";
        StringBuffer newExpresison = new StringBuffer();
        int left = 0;
        int right = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (signs.contains(String.valueOf(expression.charAt(i)))) {
                for (int j = i; j > left; j--) {
                    if (digitsForLeft.contains(String.valueOf(expression.charAt(j))) && !digitsForLeft.contains(String.valueOf(expression.charAt(j - 1)))) {
                        left = j;
                        break;
                    }
                }
                for (int j = i; j < expression.length(); j++) {
                    if (j == (expression.length() - 1)) {
                        right = expression.length();
                        break;
                    }
                    if (digitsForRight.contains(String.valueOf(expression.charAt(j)))
                            && !digitsForRight.contains(String.valueOf(expression.charAt(j + 1)))
                            && !"-".contains(String.valueOf(expression.charAt(j + 2)))
                            ) {
                        right = j;
                        break;
                    }
                }
                if (left > 0) {
                    newExpresison.append(expression.substring(0, left));
                }
                newExpresison.append("(");
                newExpresison.append(expression.substring(left, right));
                newExpresison.append(")");
                newExpresison.append(expression.substring(right, Math.min((right + 3), expression.length())));
                if (right < expression.length() - 1) {
                    newExpresison.append(expression.substring(right + 3, expression.length()));
                }
                return newExpresison.toString();
            }
        }
        return newExpresison.toString();
    }
}

//(5 + 3) * 2 - 11 / 2 ^ 2
//(5 + 3) * (2 + 11) * 2 ^ 2
// 8 * (2 - 11)