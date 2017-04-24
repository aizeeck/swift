package lesson9;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by aizeeck on 23.04.17.
 */
public class Task0_NumberNotANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = "";
        while (!line.equals("END")) {
            line = scanner.nextLine();
            try {
                Integer.parseInt(line);
                System.out.println("Is a number");
            } catch (NumberFormatException e) {
                System.out.println("Not a number");
            }
        }


    }
}
