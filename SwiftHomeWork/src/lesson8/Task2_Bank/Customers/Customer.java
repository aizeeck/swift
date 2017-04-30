package lesson8.Task2_Bank.Customers;

import lesson8.Task2_Bank.Accounts.Account;

import java.util.ArrayList;

/**
 * Created by aizeeck on 29.04.17.
 */
public abstract class Customer {
    private String name;
    private ArrayList<Account> accounts = new ArrayList<>();
    public Customer(String name) {
        this.name = name;
    }

    public void addAccount(Account acc) {
        accounts.add(acc);
    }
}
