package lesson8.Task2_Bank;

import lesson8.Task2_Bank.Accounts.Account;
import lesson8.Task2_Bank.Customers.CompanyCustomer;
import lesson8.Task2_Bank.Customers.Customer;
import lesson8.Task2_Bank.Customers.IndividualCustomer;

/**
 * Created by aizeeck on 30.04.17.
 */
public class InterestCalculator {

    public static double calculateInterestAmount(Customer owner, Account account, int monthNumber) {
        if (owner instanceof IndividualCustomer) {
            return calculateInterestAmount((IndividualCustomer) owner, owner.getAccounts().get(0), monthNumber);
        } else {
            return calculateInterestAmount((CompanyCustomer) owner, owner.getAccounts().get(0), monthNumber);
        }
    }

    private static double calculateInterestAmount(IndividualCustomer owner, Account account, int monthNumber) {

        return 10;
    }

    private static double calculateInterestAmount(CompanyCustomer owner, Account account, int monthNumber) {
        return 20;
    }
}
