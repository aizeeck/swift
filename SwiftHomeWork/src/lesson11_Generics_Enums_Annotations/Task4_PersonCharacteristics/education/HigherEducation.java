package lesson11_Generics_Enums_Annotations.Task4_PersonCharacteristics.education;

import java.time.LocalDate;

/**
 * Created by aizeeck on 22.04.17.
 */
public class HigherEducation extends GradedEducation {

    public HigherEducation(String institutionName, LocalDate enrollmentDate, LocalDate graduationDate, EducationDegree degree) {
        this.institutionName = institutionName;
        this.enrollmentDate = enrollmentDate;
        this.graduationDate = graduationDate;
        EducationDegree educationDegree;
        this.degree = degree;
    }

    public HigherEducation(String institutionName, LocalDate enrollmentDate, LocalDate graduationDate, EducationDegree degree, double finalGrade) {
        this(institutionName, enrollmentDate, graduationDate, degree);
        this.finalGrade = finalGrade;
        if (finalGrade > -1) {
            this.graduated = true;
        }
    }
}
