package lesson11_Generics_Enums_Annotations.Task4_PersonCharacteristics.education;

/**
 * Created by aizeeck on 22.04.17.
 */
public abstract class GradedEducation extends Education {
    protected double finalGrade;

    public double getFinalGrade() {
        if (this.isGraduated()) {
            return finalGrade;
        } else {
            throw new UnsupportedOperationException("No final grade can be provided before graduation.");
        }
    }

    @Override
    public void gotGraduated(double finalGrade) {
        if (2 > finalGrade && finalGrade > 6) {
            throw new IllegalArgumentException("Graduation grade is expected to be between 2 and 6.");
        }
        this.finalGrade = finalGrade;
        setGraduated(true);
    }

    @Override
    public EducationDegree getDegree() {
        return this.degree;
    }


}
