package lesson8.Task2_Bank.Accounts;

import lesson8.Task2_Bank.Customers.Customer;

/**
 * Created by aizeeck on 30.04.17.
 */
public class DepositAccount extends Account {
    public DepositAccount(String iban, double balance, double montlyInterestRate, Customer owner) {
        super(iban, balance, montlyInterestRate, owner);
    }
}
