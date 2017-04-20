package lesson7.Task2_UniversityManagement;

/**
 *
 * @author aizeeck
 */
public class Teacher extends Employee {
private String[] subjects;

    public Teacher(String firstName, String phone, String... subjects) {
        super(firstName, phone, 25);
        this.subjects = subjects;
    }

    @Override
    public void work() {

    }
}
