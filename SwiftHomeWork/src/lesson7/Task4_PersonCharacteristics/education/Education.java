package lesson7.Task4_PersonCharacteristics.education;

import java.time.LocalDate;

/**
 * Created by aizeeck on 22.04.17.
 */
public abstract class Education {
    private String institutionName;
    private LocalDate enrollmentDate;
    private LocalDate graduationDate;
    private boolean graduated;

    public abstract String getDegree();

    public abstract void gotGraduated(double finalGrade);

    public String getInstitutionName() {
        return institutionName;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }
}
