package lesson12_Streams_Files.Task3_PersonCharacteristics;

import lesson12_Streams_Files.Task3_PersonCharacteristics.education.Education;
import lesson12_Streams_Files.Task3_PersonCharacteristics.education.GradedEducation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * @author aizeeck
 */
public class Person {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final LocalDate beginOfTheTime = LocalDate.parse("1900-01-01", formatter);
    private Address currentAddress;
    private ArrayList<Address> pastAddresses = new ArrayList<>();
    private ArrayList<Education> educations = new ArrayList<>();
    private LocalDate dateBorn;
    private int yearsOld = 0;
    private Gender gender;
    private double tall = 0.00f;
    private double gradesAverage = 0.00d;
    private Education highestLevelEducation;
    private String firstName = "";
    private String middleName = "";
    private String lastName = "";
    private String pronoun1 = "";
    private String pronoun2 = "";


    public Person(String firstName, String middleName, String lastName, Gender gender, LocalDate dateBorn, double tall,
                  Address address, Education education) {
        validator(firstName, middleName, lastName, dateBorn, tall, address, education);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.tall = tall;
        this.dateBorn = dateBorn;
        this.currentAddress = address;
        this.pastAddresses.add(address);
        this.educations.add(education);
        highestLevelEducation = education;
        yearsOld = LocalDate.now().getYear() - dateBorn.getYear();
        definePronouns();
    }

    public static final void validator(String firstName, String middleName, String lastName, LocalDate dateBorn, double tall,
                                       Address address, Education education) {
        if (dateBorn.isBefore(beginOfTheTime) && dateBorn.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth is expected to be after 01.01.1900 and before now.");
        }
        if (firstName.isEmpty() || middleName.isEmpty() || lastName.isEmpty()) {
            throw new IllegalArgumentException("Expected non-empty <first,last,...> name.");
        }
        if (40 > tall && tall > 300) {
            throw new IllegalArgumentException("Expected height is between 40 and 300 cm.");
        }
    }

    private void definePronouns() {
        switch (gender) {
            case Male:
                pronoun1 = "He";
                pronoun2 = "His";
                break;
            case Female:
                pronoun1 = "She";
                pronoun2 = "Her";
                break;
        }
    }

    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
        this.pastAddresses.add(currentAddress);
    }

    public Education getHighestLevelEducation() {
        return highestLevelEducation;
    }

    public ArrayList<Education> getEducations() {
        return educations;
    }

    public void addEducation(Education education) {
        this.educations.add(education);
    }

    public void setHighestLevelEducation(Education highestLevelEducation) {
        this.highestLevelEducation = highestLevelEducation;
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
                "\n" + currentAddress.toString();

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
            output += String.format("\n%s started %s degree in %s on %s and is supposed to graduate on %s.",
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
