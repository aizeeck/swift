package lesson7.Task4_PersonCharacteristics;

import lesson7.Task4_PersonCharacteristics.education.Education;
import lesson7.Task4_PersonCharacteristics.education.HigherEducation;
import lesson7.Task4_PersonCharacteristics.education.PrimaryEducation;
import lesson7.Task4_PersonCharacteristics.education.SecondaryEducation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author aizeeck
 */
public class Task4_PersonCharacteristics {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
    private Person[] people;

    public Task4_PersonCharacteristics(int number) {
        people = new Person[number];
    }

    private Education createEducation(String[] command) {

        switch (command[5].charAt(0)) {
            case 'P':
                return new PrimaryEducation(
                        command[6],
                        LocalDate.parse(command[7], formatter),
                        LocalDate.parse(command[8], formatter),
                        "Primary"
                );
            case 'S':
                return new SecondaryEducation(
                        command[6],
                        LocalDate.parse(command[7], formatter),
                        LocalDate.parse(command[8], formatter),
                        "Secondary",
                        command.length == 10 ? Double.parseDouble(command[9]) : -1
                );
            case 'B':
                return new HigherEducation(
                        command[6],
                        LocalDate.parse(command[7], formatter),
                        LocalDate.parse(command[8], formatter),
                        "Bachelor",
                        command.length == 10 ? Double.parseDouble(command[9]) : -1
                );
            case 'M':
                return new HigherEducation(
                        command[6],
                        LocalDate.parse(command[7], formatter),
                        LocalDate.parse(command[8], formatter),
                        "Master",
                        command.length == 10 ? Double.parseDouble(command[9]) : -1
                );
            case 'D':
                return new HigherEducation(
                        command[6],
                        LocalDate.parse(command[7], formatter),
                        LocalDate.parse(command[8], formatter),
                        "Doctorate",
                        command.length == 10 ? Double.parseDouble(command[9]) : -1
                );
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int iterations = Integer.parseInt(reader.readLine());
        Task4_PersonCharacteristics manager = new Task4_PersonCharacteristics(iterations);

        for (int i = 0; i < iterations; i++) {
            String line = reader.readLine();
            String[] characteristics = line.split(";");
            Education education = manager.createEducation(characteristics);

            manager.people[i] = new Person(
                    characteristics[0],
                    characteristics[1],
                    characteristics[2].charAt(0),
                    Double.parseDouble(characteristics[3]),
                    LocalDate.parse(characteristics[4], manager.formatter),
                    education);
            System.out.print(manager.people[i].toString());
        }
    }
}