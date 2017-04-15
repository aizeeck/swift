package lesson6.Task3_BankManagement;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task3_BankManagement {

    public static void main(String[] args) {
        Bank bank = new Bank();

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String[] commandSet = scanner.nextLine().split(" ");
            if (commandSet[0].equals("END")) {
                break;
            }
            executeCommand(bank, commandSet);
        }
        System.out.println(bank.toString());
    }

    private static void executeCommand(Bank bank, String[] commandSet) {
        switch (commandSet[0]) {
            case "OPEN":
                bank.openAccount(commandSet[1], commandSet[2], commandSet[3], commandSet[4]);
                return;
            case "CLOSE":
                bank.closeAccount(commandSet[1], commandSet[2]);
                return;
            case "DEPOSIT":
                bank.deposit(commandSet[1], Double.parseDouble(commandSet[2]));
                return;
            case "WITHDRAW":
                bank.withdraw(commandSet[1], commandSet[2], Double.parseDouble(commandSet[3]));
                return;
            case "TRANSFER":
                bank.transfer(commandSet[1], commandSet[2], Double.parseDouble(commandSet[3]), commandSet[4]);
        }
    }
}
