package lesson8.Task2_Bank;

import lesson8.Task2_Bank.Accounts.*;
import lesson8.Task2_Bank.Customers.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by aizeeck on 30.04.17.
 */
public class Bank {

    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Account> accounts = new ArrayList<>();

    public Customer openCustomer(String customerTypeCode, String name) {
        Customer cs = null;
        if (customerTypeCode.equals("1")) {
            cs = new IndividualCustomer(name);
        } else {
            cs = new CompanyCustomer(name);
        }
        customers.add(cs);
        return cs;
    }

    public Account openAccount(String accTypeCode, double balance, double interestRate, Customer owner) {
        Account acc = null;
        if (accTypeCode.equals("1")) {
            acc = new DepositAccount(String.valueOf(accounts.size() + 1), balance, interestRate, owner);
        } else if (accTypeCode.equals("2")) {
            acc = new LoanAccount(String.valueOf(accounts.size() + 1), balance, interestRate, owner);
        } else if (accTypeCode.equals("3")) {
            acc = new MortgageAccount(String.valueOf(accounts.size() + 1), balance, interestRate, owner);
        }
        accounts.add(acc);
        owner.addAccount(acc);
        return acc;
    }

    public void depositAnAmount(String input, double amount) {
        Customer owner = getCustomerByName(input);
        if (owner != null) {
            owner.getAccounts().get(0).depositAnAmount(amount);
            return;
        }
        Account acc = getAccountByIBAN(input);
        if (acc != null) {
            acc.depositAnAmount(amount);
            return;
        }
        throw new NoSuchElementException("Bank has no client/account " + input);
    }

    public void withdrawAnAmount(String input, double amount) {
        Customer owner = getCustomerByName(input);
        if (owner != null) {
            owner.getAccounts().get(0).withdrawAnAmount(amount);
            return;
        }
        Account acc = getAccountByIBAN(input);
        if (acc != null) {
            acc.depositAnAmount(amount);
            return;
        }
        throw new NoSuchElementException("Bank has no client/account " + input);
    }

    public double calculateInterestAmount(String input, int monthNumber) {
        Customer owner = getCustomerByName(input);
        if (owner != null) {
            return InterestCalculator.calculateInterestAmount(owner, owner.getAccounts().get(0), monthNumber);
        }
        Account acc = getAccountByIBAN(input);
        if (acc != null) {
            return InterestCalculator.calculateInterestAmount(acc.getOwner(), owner.getAccounts().get(0), monthNumber);
        }
        throw new NoSuchElementException("Bank has no client/account " + input);
    }

    private Customer getCustomerByName(String name) {
        for (Customer cs : customers) {
            if (cs.getName().equals(name)) {
                return cs;
            }
        }
        return null;

    }

    private Account getAccountByIBAN(String input) {
        for (Account acc : accounts) {
            if (acc.getIban().equals(input)) {
                return acc;
            }
        }
        return null;
    }


}