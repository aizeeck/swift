package lesson7.Task4_PersonCharacteristics.education;

/**
 * Created by aizeeck on 22.04.17.
 */
public abstract class GradedEducation extends Education {
    private double finalGrade;

    public double getFinalGrade() {
        if (this.isGraduated()) {
            return finalGrade;
        } else {
            return -1;
        }
    }

    public abstract void gotGraduated();
}
