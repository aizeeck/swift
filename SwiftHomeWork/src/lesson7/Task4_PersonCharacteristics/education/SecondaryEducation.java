package lesson7.Task4_PersonCharacteristics.education;

import java.time.LocalDate;

/**
 *
 * @author aizeeck
 */
public class SecondaryEducation extends GradedEducation {

    private String institutionName;
    private LocalDate enrollmentDate;
    private LocalDate graduationDate;
    private boolean graduated;
    private double finalGrade;

    public SecondaryEducation(String institutionName, LocalDate enrollmentDate, LocalDate graduationDate) {
        this.institutionName = institutionName;
        this.enrollmentDate = enrollmentDate;
        this.graduationDate = graduationDate;
    }

    public SecondaryEducation(String institutionName, LocalDate enrollmentDate, LocalDate graduationDate, double finalGrade) {
        this.institutionName = institutionName;
        this.enrollmentDate = enrollmentDate;
        this.graduationDate = graduationDate;
        this.finalGrade = finalGrade;
        this.graduated = true;
    }

    public void graduate(double finalGrade) {
        this.finalGrade = finalGrade;
        this.graduated = true;
    }

    @Override
    public String getDegree() {
        return null;
    }

    @Override
    public void gotGraduated() {
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
