package lesson9.Task2_CredentialsManager;

/**
 *
 * @author aizeeck
 */
public class Credentials {

    private String username;
    private String password;
    private String[] passwords = new String[100];
    private int passwordsCounter = 0;

    public Credentials(String username, String password) {
        this.username = username;
        setPassword(password);
    }

    public boolean checkPassword(String password) {
        if (password.equals(this.password)) {
            return true;
        }
        return false;
    }

    public boolean changePassword(Credentials c, String password, String newPassword) {
        if (c.checkPassword(password)) {
            int tmp = passwordsCounter;
            c.setPassword(newPassword);
            if (tmp < passwordsCounter) {
                return true;
            } 
        }
        return false;
    }

    private boolean isNewPassValid(String password) {
        boolean isValid = false;
        boolean isAnOld = isTheNewPassAnOldOne(password);
        if (!isAnOld && password.length() > 1) {
            isValid = true;
        }

        return isValid;
    }

    private boolean isTheNewPassAnOldOne(String newPassword) {
        boolean isAnOld = false;
        for (String pass : passwords) {
            if (newPassword.equals(pass)) {
                isAnOld = true;
                break;
            }
        }
        return isAnOld;
    }

    public void setPassword(String password) {
        if (isNewPassValid(password)) {
            this.password = password;
            passwords[passwordsCounter] = password;
            passwordsCounter++;
        }
    }

    public String getUsername() {
        return this.username;
    }
}
