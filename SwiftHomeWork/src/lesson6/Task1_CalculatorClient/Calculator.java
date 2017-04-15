package lesson6.Task1_CalculatorClient;

/**
 *
 * @author aizeeck
 */
public class Calculator {

    public static double calculate(String opeartor, double a, double b) {
        switch (opeartor) {
            case "SUM":
                return sum(a, b);
            case "SUB":
                return subtract(a, b);
            case "MUL":
                return multiply(a, b);
            case "DIV":
                return divide(a, b);
            case "PER":
                return percentage(a, b);
            default:
                return 0.00d;
        }
    }

    private static double sum(double a, double b) {
        return a + b;
    }

    private static double subtract(double a, double b) {
        return a - b;
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    private static double divide(double a, double b) {
        return a / b;
    }

    private static double percentage(double a, double b) {
        return b / a;
    }
}
