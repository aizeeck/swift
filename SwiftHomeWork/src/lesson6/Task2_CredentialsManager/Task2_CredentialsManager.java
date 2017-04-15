package lesson6.Task2_CredentialsManager;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task2_CredentialsManager {

    //private static Credentials[] credentials = new Credentials[10];
    private static String execute(String[] commandSet) {
        switch (commandSet[0]) {
            case "ENROLL":
                if (commandSet.length != 3) {
                    return "fail";
                }
                new Credentials(commandSet[1], commandSet[2]);
                return "success";
            case "CHPASS":
                if (commandSet.length != 4) {
                    return "fail";
                }
                //if (!Credentials.isUserExists(commandSet[1])) {return "fail";}
                Credentials c = Credentials.getUserByName(commandSet[1], commandSet[2]);
                if (c != null) {
                    if (c.changePassword(c, commandSet[2], commandSet[3])) {
                        return "success";
                    } else {
                        return "fail";
                    }
                }
                return "fail";
            case "AUTH":
                if (commandSet.length != 3) {
                    return "fail";
                }
                Credentials c1 = Credentials.getUserByName(commandSet[1], commandSet[2]);
                if (c1 == null) {
                    return "fail";
                } else {
                    return "success";
                }
            default:
                return "unsupported command";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String[] commandSet = scanner.nextLine().split(" ");
            if (commandSet[0].equals("END")) {
                break;
            }
            //System.out.println(Arrays.toString(commandSet));
            System.out.printf("%s %s\n", commandSet[0], execute(commandSet));
        }

    }
}
