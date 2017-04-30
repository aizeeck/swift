package lesson8.Task2_Bank;

import lesson8.Task2_Bank.Accounts.Account;
import lesson8.Task2_Bank.Accounts.DepositAccount;
import lesson8.Task2_Bank.Accounts.LoanAccount;
import lesson8.Task2_Bank.Accounts.MortgageAccount;
import lesson8.Task2_Bank.Customers.CompanyCustomer;
import lesson8.Task2_Bank.Customers.Customer;
import lesson8.Task2_Bank.Customers.IndividualCustomer;

import java.util.ArrayList;

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
            acc = new DepositAccount(String.valueOf(accounts.size()), balance, interestRate, owner);
        } else if (accTypeCode.equals("2")) {
            acc = new LoanAccount(String.valueOf(accounts.size()), balance, interestRate, owner);
        } else if (accTypeCode.equals("3")) {
            acc = new MortgageAccount(String.valueOf(accounts.size()), balance, interestRate, owner);
        }
        accounts.add(acc);
        owner.addAccount(acc);
        return acc;
   }


}