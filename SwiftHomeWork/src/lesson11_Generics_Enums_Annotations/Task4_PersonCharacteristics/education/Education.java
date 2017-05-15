package lesson11_Generics_Enums_Annotations.Task4_PersonCharacteristics.education;

import java.time.LocalDate;

/**
 * Created by aizeeck on 22.04.17.
 */
public abstract class Education {

    protected EducationDegree degree;

    protected String institutionName;
    protected LocalDate enrollmentDate;
    protected LocalDate graduationDate;
    protected boolean graduated;

    public abstract EducationDegree getDegree();

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
        if (graduationDate.isBefore(enrollmentDate)) {
            throw new IllegalArgumentException("Graduation date is expected to be after enrollment date.");
        }
        if (graduationDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Graduation date is expected to be a date in the past.");
        }
        this.graduationDate = graduationDate;
    }
}