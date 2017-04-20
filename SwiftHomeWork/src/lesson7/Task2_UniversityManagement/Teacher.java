package lesson7.Task2_UniversityManagement;

/**
 *
 * @author aizeeck
 */
public class Teacher extends Employee {
private String[] subjects;

    public Teacher(String firstName, String phone, double hourSalary, String[] subjects) {
        super(firstName, phone, hourSalary);
        this.subjects = subjects;
    }
}
