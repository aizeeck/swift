package lesson7.Task2_UniversityManagement;

/**
 *
 * @author aizeeck
 */
public class MaintenanceEmployee extends Employee {

    public MaintenanceEmployee(String firstName, String phone) {
        super(firstName, phone, 15);
    }

    @Override
    public void work() {
        Person[] people = Task2_UniversityManagement.getPeople();
        for (Person p : people) {
            p.increaseTolerance(2);
        }
    }


}
