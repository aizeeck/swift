package lesson7.Task4_PersonCharacteristics.education;

/**
 * Created by aizeeck on 22.04.17.
 */
public class PrimaryEducation extends Education {

    @Override
    public String getDegree() {
        return null;
    }

    @Override
    public void gotGraduated(double finalGrade) {
        setGraduated(true);
    }
}
