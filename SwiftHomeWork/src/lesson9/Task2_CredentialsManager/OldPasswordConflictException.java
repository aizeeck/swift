package lesson9.Task2_CredentialsManager;

/**
 * Created by aizeeck on 30.04.17.
 */
public class OldPasswordConflictException extends Exception {
    public int getPasswordConflictIndex() {
        return 1;
    }
}
