package lesson5.Task6_PersonCharacteristics;

import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author aizeeck
 */
public class Persone {

    private int yearBorn = 0;
    private int yearsOld = 0;
    private char gender = 0;
    private double weight = 0.00f;
    private double tall = 0.00f;
    private double[] grades;
    private double gradesAverage = 0.00d;
    private String firstName = "";
    private String lastName = "";
    private String profession = "";
    private String pronoun1 = "";
    private String pronoun2 = "";

    public Persone(String firstName, String lastName, char gender, int yearBorn,
            double weight, double tall, String profession, double... grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.yearBorn = yearBorn;
        this.weight = weight;
        this.tall = tall;
        this.profession = profession;
        this.grades = grades;
        this.yearsOld = new Date().getYear() + 1900 - yearBorn;
        calculateGradesAverage();
        definePronouns();
    }

    private void calculateGradesAverage() {
        double gradesSum = 0.00d;
        for (int j = 0; j < grades.length; j++) {
            gradesSum += grades[j];
        }
        gradesAverage = gradesSum / grades.length;
    }

    private void definePronouns() {
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
    }

    @Override
    public String toString() {
        String output = String.format("%s %s is %d years old. %s was born in %d. "
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
        return output;
    }

}
