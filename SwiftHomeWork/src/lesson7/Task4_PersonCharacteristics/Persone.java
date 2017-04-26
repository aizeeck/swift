package lesson7.Task4_PersonCharacteristics;

import lesson7.Task4_PersonCharacteristics.education.Education;
import lesson7.Task4_PersonCharacteristics.education.HigherEducation;
import lesson7.Task4_PersonCharacteristics.education.PrimaryEducation;
import lesson7.Task4_PersonCharacteristics.education.SecondaryEducation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author aizeeck
 */
public class Persone {

    private LocalDate dateBorn;
    private int yearsOld = 0;
    private char gender = 0;
    private double tall = 0.00f;
    private double gradesAverage = 0.00d;
    private PrimaryEducation primaryEducation;
    private SecondaryEducation secondaryEducation;
    private HigherEducation higherEducation;

    private String firstName = "";
    private String lastName = "";
    private String pronoun1 = "";
    private String pronoun2 = "";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Persone(String firstName, String lastName, char gender, double tall, LocalDate dateBorn,
                   Education education) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.tall = tall;
        this.dateBorn = dateBorn;
        this.secondaryEducation = secondaryEducation;
        yearsOld = LocalDate.now().getYear() - dateBorn.getYear();
        definePronouns();
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
        String output;
        if (secondaryEducation.isGraduated()) {
            output = String.format("%s %s is %d years old. %s was born in %d. %s started %s on %s and finished on %s with a grade of %.3f.",
                    firstName,
                    lastName,
                    yearsOld,
                    pronoun1,
                    dateBorn.getYear(),
                    pronoun1,
                    secondaryEducation.getInstitutionName(),
                    secondaryEducation.getEnrollmentDate().format(formatter),
                    secondaryEducation.getEnrollmentDate().format(formatter),
                    secondaryEducation.getFinalGrade()
            );
        } else {
            output = String.format("%s %s is %d years old. %s was born in %d. %s started %s on %s and is supposed to graduate on %s.",
                    firstName,
                    lastName,
                    yearsOld,
                    pronoun1,
                    dateBorn.getYear(),
                    pronoun1,
                    secondaryEducation.getInstitutionName(),
                    secondaryEducation.getEnrollmentDate().format(formatter),
                    secondaryEducation.getEnrollmentDate().format(formatter)
            );
        }

        if (yearsOld < 18) {
            output += String.format(" %s %s is under-aged.\n",
                    firstName,
                    lastName);
        } else {
            output += "\n";
        }
        return output;
    }

}
