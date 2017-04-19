package lesson7.Task1_PeoplePresentation;

/**
 *
 * @author aizeeck
 */
public class Student extends Persone {

    private String facultyNumber;
    private int lectureCount;
    private int exerciseCount;

    public Student(String firstName, String lastName, String facultyNumber, int lectureCount, int exerciseCount) {
        super(firstName, lastName);
        this.facultyNumber = facultyNumber;
        this.lectureCount = lectureCount;
        this.exerciseCount = exerciseCount;
    }

    @Override
    public String toString() {
        double d = (lectureCount * 2 + exerciseCount * 1.5) / 5;
        String result = super.toString()
                + "Occupation: Student\n"
                + "Faculty number: " + facultyNumber + "\n"
                + "Hours per day: " + (lectureCount * 2 + exerciseCount * 1.5) / 5;
        return result;
    }

}
