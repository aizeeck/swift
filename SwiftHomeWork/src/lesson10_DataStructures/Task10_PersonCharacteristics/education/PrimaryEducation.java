package lesson10_DataStructures.Task10_PersonCharacteristics.education;

import java.time.LocalDate;

/**
 * Created by aizeeck on 22.04.17.
 */
public class PrimaryEducation extends Education {

    public PrimaryEducation(String institutionName, LocalDate enrollmentDate, LocalDate graduationDate, String degree) {
        this.institutionName = institutionName;
        this.enrollmentDate = enrollmentDate;
        this.setGraduationDate(graduationDate);
        this.degree = degree;
    }

    @Override
    public void gotGraduated(double finalGrade) {
        setGraduated(true);
    }

    @Override
    public String getDegree() {
        return this.degree;
    }
}
