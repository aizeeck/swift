package lesson8.Task3_PersonCharacteristics;

import lesson8.Task3_PersonCharacteristics.education.Education;
import lesson8.Task3_PersonCharacteristics.education.HigherEducation;
import lesson8.Task3_PersonCharacteristics.education.PrimaryEducation;
import lesson8.Task3_PersonCharacteristics.education.SecondaryEducation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author aizeeck
 */
public class Task3_PersonCharacteristics {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
    private Person[] people;

    public Task3_PersonCharacteristics(int number) {
        people = new Person[number];
    }

    private Education createEducation(String[] command) {

        
        switch (command[14].charAt(0)) {
            case 'P':
                return new PrimaryEducation(
                        command[15],
                        LocalDate.parse(command[16], formatter),
                        LocalDate.parse(command[17], formatter),
                        "Primary"
                );
            case 'S':
                return new SecondaryEducation(
                        command[15],
                        LocalDate.parse(command[16], formatter),
                        LocalDate.parse(command[17], formatter),
                        "Secondary",
                        command.length == 19 ? Double.parseDouble(command[18]) : -1
                );
            case 'B':
                return new HigherEducation(
                        command[15],
                        LocalDate.parse(command[16], formatter),
                        LocalDate.parse(command[17], formatter),
                        "Bachelor",
                        command.length == 19 ? Double.parseDouble(command[18]) : -1
                );
            case 'M':
                return new HigherEducation(
                        command[15],
                        LocalDate.parse(command[16], formatter),
                        LocalDate.parse(command[17], formatter),
                        "Master",
                        command.length == 19 ? Double.parseDouble(command[18]) : -1
                );
            case 'D':
                return new HigherEducation(
                        command[15],
                        LocalDate.parse(command[16], formatter),
                        LocalDate.parse(command[17], formatter),
                        "Doctorate",
                        command.length == 19 ? Double.parseDouble(command[18]) : -1
                );
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int iterations = Integer.parseInt(reader.readLine());
        Task3_PersonCharacteristics manager = new Task3_PersonCharacteristics(iterations);

        for (int i = 0; i < iterations; i++) {
            String line = reader.readLine();
            String[] characteristics = line.split(";");

            Education education = manager.createEducation(characteristics);

            Address address = new Address(
                    characteristics[6],
                    characteristics[7],
                    characteristics[8],
                    characteristics[9],
                    characteristics[10],
                    characteristics[11],
                    characteristics[12],
                    characteristics[13]
            );

            manager.people[i] = new Person(
                    characteristics[0],
                    characteristics[1],
                    characteristics[2],
                    characteristics[3].charAt(0),
                    LocalDate.parse(characteristics[4], manager.formatter),
                    Double.parseDouble(characteristics[5]),
                    address,
                    education);
            System.out.println(manager.people[i].toString() + "\n");
        }
    }
}