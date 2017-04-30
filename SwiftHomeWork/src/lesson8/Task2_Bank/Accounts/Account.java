package lesson8.Task2_Bank.Accounts;

import lesson8.Task2_Bank.Customers.Customer;

/**
 * Created by aizeeck on 29.04.17.
 */
public class Account {
    private String iban;
    private double balance;
    private double montlyInterestRate;
    private Customer owner;

    public Account(String iban, double balance, double montlyInterestRate, Customer owner) {
        String tmpIban = String.valueOf("00000000" + iban);
        this.iban = tmpIban.substring(tmpIban.length()-8, tmpIban.length());
        this.balance = balance;
        this.montlyInterestRate = montlyInterestRate;
        this.owner = owner;
    }

    public void depositAnAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount should be a positive");
        }
        balance += amount;
    }

    public String getIban() {
        return iban;
    }
}
