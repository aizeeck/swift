package lesson9.Task3_PersonCharacteristics.education;

/**
 * Created by aizeeck on 22.04.17.
 */
public abstract class GradedEducation extends Education {
    protected double finalGrade;

    public double getFinalGrade() {
        if (this.isGraduated()) {
            return finalGrade;
        } else {
            return -1;
        }
    }

    @Override
    public void gotGraduated(double finalGrade) {
        this.finalGrade = finalGrade;
        setGraduated(true);
    }

    @Override
    public String getDegree() {
        return this.degree;
    }
}
