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
        setFacultyNumber(facultyNumber);
        setLectureCount(lectureCount);
        setExerciseCount(exerciseCount);
    }

    public void setFacultyNumber(String facultyNumber) {
        if (5 > facultyNumber.length() && facultyNumber.length() > 10) {
            System.out.println("Expected length for faculty number\n" +
                    "is between 5 and 10 symbols.");
            return;
        }
        this.facultyNumber = facultyNumber;
    }

    public void setLectureCount(int lectureCount) {
        this.lectureCount = lectureCount;
    }

    public void setExerciseCount(int exerciseCount) {
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
