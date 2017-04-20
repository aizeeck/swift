package lesson7.Task2_UniversityManagement;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task2_UniversityManagement {



    public static void main(String[] args) {

        Person[] person = new Person[10];
        int personCounter = 0;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("END")) {
                break;
            }
            
            String[] command = line.split(" ");

            switch (command[0]) {
                case "NEW":
                    person[personCounter++] = createPersone(command);
            }
        }
        
    }

    private static Person createPersone(String[] command) {
        String[] subjects;
        switch (command[1]) {
            case "MAINT":
                return new MaintenanceEmployee(command[2], command[3]);
            case "ADMIN":
                subjects = new String[command.length - 4];
                System.arraycopy(command,3, subjects,0, command.length - 4);
                return new AdministrationEmployee(command[2], command[3], subjects);
            case "TEACH":
                subjects = new String[command.length - 4];
                System.arraycopy(command,3, subjects,0, command.length - 4);
                return new Teacher(command[2], command[3], subjects);
            case "STUD":
                subjects = new String[command.length - 5];
                System.arraycopy(command,3, subjects,0, command.length - 5);
                return new Student(command[2], command[3], command[4], subjects);
            default: return null;
        }
    }
}
