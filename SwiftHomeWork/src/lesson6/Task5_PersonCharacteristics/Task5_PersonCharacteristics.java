package lesson6.Task5_PersonCharacteristics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author aizeeck
 */
public class Task5_PersonCharacteristics {

    public static void main(String[] args) throws IOException {

        int iterations = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        iterations = Integer.parseInt(reader.readLine());
        Persone[] persones = new Persone[iterations];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");

        for (int i = 0; i < iterations; i++) {
            String line = reader.readLine();
            String[] characteristics = line.split(";");
            SecondaryEducation secondaryEducation = null;
            
            if (characteristics.length == 8) {
                secondaryEducation = new SecondaryEducation(
                        characteristics[5],
                        LocalDate.parse(characteristics[6], formatter),
                        LocalDate.parse(characteristics[7], formatter)
                );
            } else if (characteristics.length == 9) {
                secondaryEducation = new SecondaryEducation(
                        characteristics[5],
                        LocalDate.parse(characteristics[6], formatter),
                        LocalDate.parse(characteristics[7], formatter),
                        Double.parseDouble(characteristics[8])
                );
            }

            persones[i] = new Persone(
                    characteristics[0],
                    characteristics[1],
                    characteristics[2].charAt(0),
                    Double.parseDouble(characteristics[3]),
                    LocalDate.parse(characteristics[4], formatter),
                    secondaryEducation
            );

            System.out.print(persones[i].toString());
        }
    }
}
