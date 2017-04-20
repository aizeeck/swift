package lesson7.Task2_UniversityManagement;

/**
 *
 * @author aizeeck
 */
public class AdministrationEmployee extends Employee {
private String[] subjects;

    public AdministrationEmployee(String firstName, String phone, double hourSalary, String[] subjects) {
        super(firstName, phone, hourSalary);
        this.subjects = subjects;
    }
}
