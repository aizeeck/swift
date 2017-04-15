package lesson6.Task3_BankManagement;

import lesson6.Task2_CredentialsManager.Credentials;

/**
 *
 * @author aizeeck
 */
public class Account {

    private String name;
    private String govId;
    private Credentials credentials;
    private double balance;

    public Account(String username, String password, String name, String govId) {
        this.name = name;
        this.govId = govId;
        this.credentials = new Credentials(username, password);
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    void withdraw(double amount) {
        if ((balance - amount) >= 0) {
            balance -= amount;
        }
    }

    public boolean hasAccess(String password) {
        return credentials.checkPassword(password);
    }

    double getBalance() {
        return balance;
    }

    String getUsername() {
        return credentials.getUsername();
    }

    String getGovId() {
        return govId;
    }

    public String getName() {
        return name;
    }
}
