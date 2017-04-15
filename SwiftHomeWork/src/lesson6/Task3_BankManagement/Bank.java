package lesson6.Task3_BankManagement;

import lesson6.Task2_CredentialsManager.Credentials;

/**
 *
 * @author aizeeck
 */
public class Bank {

    private Account[] assets = new Account[5];
    private int accountCounter = 0;

    public void openAccount(String username, String password, String name, String govId) {
        /*if (accountCounter == assets.length) {
            increaseAssetsSize();
        }*/
        if (accountCounter == assets.length) {
            System.out.println("OPEN fail");
            return;
        }
        Account tmp = new Account(username, password, name, govId);
        if (tmp != null) {
            addAccountToAssets(tmp);
            accountCounter++;
            System.out.println("OPEN success");
            return;
        }
        System.out.println("OPEN fail");
    }

    public void closeAccount(String username, String password) {
        for (int i = 0; i < assets.length; i++) {
            String tmp = assets[i].getUsername();
            if (assets[i] != null && username.equals(assets[i].getUsername())) {
                if (assets[i].hasAccess(password)) {
                    assets[i] = null;
                    accountCounter--;
                    System.out.println("CLOSE success");
                    return;
                }
            }
        }
        System.out.println("CLOSE fail");
    }

    public void deposit(String username, double amount) {
        Account account = getAccountByUsername(username);
        if (account != null) {
            double balanceBefore = account.getBalance();
            account.deposit(amount);
            if (balanceBefore < account.getBalance()) {
                System.out.println("DEPOSIT success");
                return;
            }
        }
        System.out.println("DEPOSIT fail");
    }

    public void withdraw(String username, String password, double amount) {
        Account account = getAccountByUsername(username);
        if (account != null && account.hasAccess(password)) {
            double balanceBefore = account.getBalance();
            account.withdraw(amount);
            if (balanceBefore > account.getBalance()) {
                System.out.println("WITHDRAW success");
                return;
            }
        }
        System.out.println("WITHDRAW fail");
    }

    public void transfer(String username, String password, double amount, String recipient) {
        Account accountSender = getAccountByUsername(username);
        Account accountRecipient = getAccountByUsername(recipient);
        if (accountSender != null && accountRecipient != null && accountSender.hasAccess(password)) {
            double balanceBefore = accountSender.getBalance();
            accountSender.withdraw(amount);
            if (accountSender.getBalance() < balanceBefore) {
                accountRecipient.deposit(amount);
                System.out.println("TRANSFER success");
                return;
            }
        }
        System.out.println("TRANSFER fail");
    }

    private void addAccountToAssets(Account a) {
        for (int i = 0; i < assets.length; i++) {
            if (assets[i] == null) {
                assets[i] = a;
                break;
            }
        }
    }

    private Account getAccountByUsername(String username) {
        for (int i = 0; i < assets.length; i++) {
            String tmp = assets[i].getUsername();
            if (assets[i] != null && username.equals(assets[i].getUsername())) {
                return assets[i];
            }
        }
        return null;
    }

    public double getAssets() {
        double sum = 0.00d;
        for (Account asset : assets) {
            sum += asset.getBalance();
        }
        return sum;
    }

    private void increaseAssetsSize() {
        Account[] tmp = assets;
        assets = new Account[accountCounter * 2];
        System.arraycopy(tmp, 0, assets, 0, accountCounter);
    }

    @Override
    public String toString() {
        String info = getAssets() + "\n";
        for (Account asset : assets) {
            info += asset.getName() + ", " + asset.getGovId() + ", " + asset.getBalance() + "\n";
        }
        return info;
    }

}
