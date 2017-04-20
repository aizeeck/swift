package lesson7.Task2_UniversityManagement;

/**
 *
 * @author aizeeck
 */
public class Employee extends Persone {

    private double hourSalary;
    private int tolerance;

    public Employee(String firstName, String lastName, double hourSalary) {
        super(firstName, lastName);
        this.hourSalary = hourSalary;
        this.tolerance = 20;
    }
    
    
    
}
