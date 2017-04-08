package lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author aizeeck
 */
public class Task5_PersonCharacteristics {

    public static void main(String[] args) throws IOException {
        int iterations = 0;
        int yearBorn = 0;
        int yearsOld = 0;
        char gender = 0;
        double weight = 0.00f;
        double tall = 0.00f;
        double[] grades = new double[4];
        double gradesAverage = 0.00d;
        String firstName = "";
        String lastName = "";
        String profession = "";
        String pronoun1 = "";
        String pronoun2 = "";
        String output = "";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        iterations = Integer.parseInt(reader.readLine());

        for (int i = 0; i < iterations; i++) {
            String line = reader.readLine();
            String[] characteristics = line.split(";");
            firstName = characteristics[0];
            lastName = characteristics[1];
            gender = characteristics[2].charAt(0);
            yearBorn = Integer.parseInt(characteristics[3]);
            yearsOld = 2016 - yearBorn;
            weight = Double.parseDouble(characteristics[4]);
            tall = Double.parseDouble(characteristics[5]);
            profession = characteristics[6];

            int counter = 7;
            grades[0] = Double.parseDouble(characteristics[counter++]);
            grades[1] = Double.parseDouble(characteristics[counter++]);
            grades[2] = Double.parseDouble(characteristics[counter++]);
            grades[3] = Double.parseDouble(characteristics[counter++]);

            double gradesSum = 0.00d;
            for (int j = 0; j < grades.length; j++) {
                gradesSum += grades[j];
            }
            gradesAverage = gradesSum / grades.length;

            switch (gender) {
                case 'M':
                    pronoun1 = "He";
                    pronoun2 = "His";
                    break;
                case 'F':
                    pronoun1 = "She";
                    pronoun2 = "Her";
                    break;
            }

            output += String.format("%s %s is %d years old. %s was born in %d. "
                    + "%s weight is %.1f and he is %.0f cm tall. %s is a %s with an average grade of %.3f.",
                    firstName,
                    lastName,
                    yearsOld,
                    pronoun1,
                    yearBorn,
                    pronoun2,
                    weight,
                    tall,
                    pronoun1,
                    profession,
                    gradesAverage);

            if (yearsOld < 18) {
                output += String.format("%s %s is under-aged.\n",
                        firstName,
                        lastName);
            } else {
                output += "\n";
            }
        }
        System.out.println(output);
    }
}
