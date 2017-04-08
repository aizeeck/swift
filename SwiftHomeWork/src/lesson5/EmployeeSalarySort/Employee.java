package lesson5.EmployeeSalarySort;

import java.util.Comparator;

/**
 *
 * @author aizeeck
 */
public class Employee {

    private String name;
    private String email;
    private String position;
    private String department;
    private int age;
    private double salary;

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department);
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department, int age, String email) {
        this(name, salary, position, department);
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        String info = String.format("%s, %s, %s", name, department, position);
        if (email != null) {
            info += ", " + email;
        }
        return info;
    }
}
