package lesson10_DataStructures.Task10_PersonCharacteristics.education;

import java.time.LocalDate;

/**
 * @author aizeeck
 */
public class SecondaryEducation extends GradedEducation {

    private String institutionName;
    private LocalDate enrollmentDate;
    private LocalDate graduationDate;
    private boolean graduated;
    private double finalGrade;

    public SecondaryEducation(String institutionName, LocalDate enrollmentDate, LocalDate graduationDate, String degree) {
        this.institutionName = institutionName;
        this.enrollmentDate = enrollmentDate;
        this.graduationDate = graduationDate;
        this.degree = degree;
    }

    public SecondaryEducation(String institutionName, LocalDate enrollmentDate, LocalDate graduationDate, String degree, double finalGrade) {
        this(institutionName, enrollmentDate, graduationDate, degree);
        this.finalGrade = finalGrade;
        if (finalGrade > -1) {
            this.graduated = true;
        }
    }

    public void graduate(double finalGrade) {
        this.finalGrade = finalGrade;
        this.graduated = true;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public double getFinalGrade() {
        if (graduated) {
            return finalGrade;
        } else {
            return -1.00d;
        }
    }

    public boolean isGraduated() {
        return graduated;
    }

}
