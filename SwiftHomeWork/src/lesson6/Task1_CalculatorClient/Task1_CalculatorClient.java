package lesson6.Task1_CalculatorClient;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task1_CalculatorClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.next();
            if (command.equals("END")) {
                break;
            }
            double operand1 = scanner.nextDouble();
            double operand2 = scanner.nextDouble();

            System.out.printf("%.3f\n", Calculator.calculate(command, operand1, operand2));
        }
        
    }
}
