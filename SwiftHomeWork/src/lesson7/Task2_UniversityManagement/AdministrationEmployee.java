package lesson7.Task2_UniversityManagement;

/**
 *
 * @author aizeeck
 */
public class AdministrationEmployee extends Employee {
private String[] subjects;

    public AdministrationEmployee(String firstName, String phone, String... subjects) {
        super(firstName, phone, 19);
        this.subjects = subjects;
    }

    @Override
    public void work() {

    }
}
