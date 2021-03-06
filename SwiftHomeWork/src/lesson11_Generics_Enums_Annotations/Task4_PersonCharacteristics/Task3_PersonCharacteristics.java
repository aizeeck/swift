package lesson11_Generics_Enums_Annotations.Task4_PersonCharacteristics;

import lesson11_Generics_Enums_Annotations.Task4_PersonCharacteristics.education.Education;
import lesson11_Generics_Enums_Annotations.Task4_PersonCharacteristics.education.EducationFactory;

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

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int iterations = Integer.parseInt(reader.readLine());
        Task3_PersonCharacteristics manager = new Task3_PersonCharacteristics(iterations);

        for (int i = 0; i < iterations; i++) {
            String line = reader.readLine();
            String[] characteristics = line.split(";");

            Education education = EducationFactory.createEducation(characteristics);
            Gender gender = characteristics[3].charAt(0) == 'M' ? Gender.Male : Gender.Female;
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
                    gender,
                    LocalDate.parse(characteristics[4], manager.formatter),
                    Double.parseDouble(characteristics[5]),
                    address,
                    education);

            System.out.println(manager.people[i].toString() + "\n");
        }
    }
}
