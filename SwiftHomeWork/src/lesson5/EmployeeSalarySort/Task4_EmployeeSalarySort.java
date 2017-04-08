package lesson5.EmployeeSalarySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author aizeeck
 */
public class Task4_EmployeeSalarySort {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        Employee[] employees = new Employee[N];

        for (int i = 0; i < N; i++) {
            String tmp = reader.readLine();
            String[] emplStrings = tmp.split(",");
            switch (emplStrings.length) {
                case 6:
                    employees[i] = new Employee(
                            emplStrings[0].trim(),
                            Double.parseDouble(emplStrings[1].trim()),
                            emplStrings[2].trim(),
                            emplStrings[3].trim(),
                            Integer.parseInt(emplStrings[4].trim()),
                            emplStrings[5].trim());
                    break;
                case 5:
                    employees[i] = new Employee(
                            emplStrings[0],
                            Double.parseDouble(emplStrings[1]),
                            emplStrings[2],
                            emplStrings[3],
                            Integer.parseInt(emplStrings[4]));
                    break;
                case 4:
                    employees[i] = new Employee(
                            emplStrings[0],
                            Double.parseDouble(emplStrings[1]),
                            emplStrings[2],
                            emplStrings[3]);
                    break;
                default:

            }
        }
        
        employees = sortBubleEmployees(employees);
        for (int i = 0; i < 3; i++) {
            System.out.println(employees[i]);
        }
    }

    private static Employee[] sortBubleEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length - 1; i++) {
            for (int j = 0; j < employees.length - i - 1; j++) {
                if (employees[j + 1].getSalary() > employees[j].getSalary()) {
                    Employee tmp = employees[j + 1];
                    employees[j + 1] = employees[j];
                    employees[j] = tmp;
                }
            }
        }
        return employees;
    }
}
