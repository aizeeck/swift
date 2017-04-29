package lesson9.Task3_PersonCharacteristics;

import lesson9.Task3_PersonCharacteristics.education.Education;
import lesson9.Task3_PersonCharacteristics.education.GradedEducation;

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
    private final Address address;
    ArrayList<Education> educations = new ArrayList<>();
    private Education highestLevelEducation;
    private String firstName = "";
    private String middleName = "";
    private String lastName = "";
    private String pronoun1 = "";
    private String pronoun2 = "";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Person(String firstName, String middleName, String lastName, char gender, LocalDate dateBorn, double tall,
                  Address address, Education education) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.tall = tall;
        this.dateBorn = dateBorn;
        this.address = address;
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
        String output = String.format("%s %s is %d years old. %s was born in %d.",
                firstName,
                lastName,
                yearsOld,
                pronoun1,
                dateBorn.getYear()
        );

        if (yearsOld < 18) {
            output += String.format("\n%s %s is under-aged.",
                    firstName,
                    lastName);
        }

        output += "\n" + pronoun1 + " lives at: " +
                "\n" + address.toString();

        if (highestLevelEducation.isGraduated()) {
            output += String.format("\n%s started %s degree in %s on %s and finished on %s. His grade was %.3f.",
                    pronoun1,
                    highestLevelEducation.getDegree(),
                    highestLevelEducation.getInstitutionName(),
                    highestLevelEducation.getEnrollmentDate().format(formatter),
                    highestLevelEducation.getGraduationDate().format(formatter),
                    highestLevelEducation instanceof GradedEducation ? ((GradedEducation) highestLevelEducation).getFinalGrade() : ""
            );
        } else {
            output += String.format("%s started %s degree in %s on %s and is supposed to graduate on %s.",
                    pronoun1,
                    highestLevelEducation.getDegree(),
                    highestLevelEducation.getInstitutionName(),
                    highestLevelEducation.getEnrollmentDate().format(formatter),
                    highestLevelEducation.getGraduationDate().format(formatter)
            );
        }

        return output;
    }

}
