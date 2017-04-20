package lesson7.Task2_UniversityManagement;

/**
 *
 * @author aizeeck
 */
public class Student extends Person {

    private String facultyNumber;
    private String[] subjects;

    public Student(String firstName, String lastName, String facultyNumber, String... subjects) {
        super(firstName, lastName);
        this.facultyNumber = facultyNumber;
        this.subjects = subjects;
    }


    @Override
    public void work() {

    }
}
