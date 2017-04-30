package lesson8.Task2_Bank;

import lesson8.Task2_Bank.Customers.Customer;

import java.util.Scanner;

/**
 * Created by aizeeck on 30.04.17.
 */
public class BankManager {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();;

        while (!line.equals("END")) {
            String[] command = line.split(" ");
            switch (command[0]) {
                case "OPEN":
                    Customer cs = bank.openCustomer(command[2], command[1]);
                    bank.openAccount(command[3], Double.parseDouble(command[4]), Double.parseDouble(command[5]), cs);
                    break;
                case "PUT":
                    bank.depositAnAmount(command[1], Double.parseDouble(command[2]));
                    break;
                case "INFO":

                    break;
            }
            line = scanner.nextLine();
        }
    }


}
