import education.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by aizeeck on 26.05.17.
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
                        LocalDate.parse(command[17], formatter)
                );
            case 'S':
                return new SecondaryEducation(
                        command[15],
                        LocalDate.parse(command[16], formatter),
                        LocalDate.parse(command[17], formatter)
);
            case 'B':
                return new HigherEducation(
                        command[15],
                        LocalDate.parse(command[16], formatter),
                        LocalDate.parse(command[17], formatter),
                        EducationDegree.valueOf("Bachelor")
                );
            case 'M':
                return new HigherEducation(
                        command[15],
                        LocalDate.parse(command[16], formatter),
                        LocalDate.parse(command[17], formatter),
                        EducationDegree.valueOf("Master")
                );
            case 'D':
                return new HigherEducation(
                        command[15],
                        LocalDate.parse(command[16], formatter),
                        LocalDate.parse(command[17], formatter),
                        EducationDegree.valueOf("Doctorate")
                );
        }
        throw new IllegalArgumentException("Unrecognized education code.");
    }
}
