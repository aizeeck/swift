package lesson10_DataStructures.Task10_PersonCharacteristics.education;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by aizeeck on 27.04.17.
 */
public class EducationFactory {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");

    private EducationFactory() {
    }

    public static Education createEducation(String[] command) {
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
        throw new IllegalArgumentException("Unrecognized education code.");
    }
}