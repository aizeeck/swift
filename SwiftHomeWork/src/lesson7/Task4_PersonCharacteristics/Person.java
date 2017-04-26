package lesson7.Task4_PersonCharacteristics;

import lesson7.Task4_PersonCharacteristics.education.Education;
import lesson7.Task4_PersonCharacteristics.education.GradedEducation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author aizeeck
 */
public class Person {

    private LocalDate dateBorn;
    private int yearsOld = 0;
    private char gender = 0;
    private double tall = 0.00f;
    private double gradesAverage = 0.00d;
    ArrayList<Education> educations = new ArrayList<>();
    private Education highestLevelEducation;

    private String firstName = "";
    private String lastName = "";
    private String pronoun1 = "";
    private String pronoun2 = "";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Person(String firstName, String lastName, char gender, double tall, LocalDate dateBorn,
                  Education education) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.tall = tall;
        this.dateBorn = dateBorn;
        this.educations.add(education);
        highestLevelEducation = education;
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

        if (highestLevelEducation.isGraduated()) {
            output = String.format("%s %s is %d years old. %s was born in %d. %s started %s degree in %s on %s and finished on %s with a grade of %.3f.",
                    firstName,
                    lastName,
                    yearsOld,
                    pronoun1,
                    dateBorn.getYear(),
                    pronoun1,
                    highestLevelEducation.getDegree(),
                    highestLevelEducation.getInstitutionName(),
                    highestLevelEducation.getEnrollmentDate().format(formatter),
                    highestLevelEducation.getGraduationDate().format(formatter),
                    highestLevelEducation instanceof GradedEducation ? ((GradedEducation) highestLevelEducation).getFinalGrade() : ""
            );
        } else {
            output = String.format("%s %s is %d years old. %s was born in %d. %s started %s degree in %s on %s and is supposed to graduate on %s.",
                    firstName,
                    lastName,
                    yearsOld,
                    pronoun1,
                    dateBorn.getYear(),
                    pronoun1,
                    highestLevelEducation.getDegree(),
                    highestLevelEducation.getInstitutionName(),
                    highestLevelEducation.getEnrollmentDate().format(formatter),
                    highestLevelEducation.getGraduationDate().format(formatter)
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
