package lesson7.Task1_PeoplePresentation;

/**
 *
 * @author aizeeck
 */
public class Worker extends Persone {

    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        setWeekSalary(weekSalary);
        setWorkHoursPerDay(workHoursPerDay);
    }

    public void setWeekSalary(double weekSalary) {
        if (weekSalary < 0) {
            System.out.println("Expected positive number for\n" +
                    "weekSalary.");
            return;
        }
        this.weekSalary = weekSalary;
    }

    public void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 0) {
            System.out.println("Expected positive number for\n" +
                    "workHoursPerDay.");
            return;
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    @Override
    public String toString() {
        String result = super.toString()
                + "Occupation: Worker\n"
                + "Week salary:" + weekSalary + "\n"
                + "Hours per day: " + workHoursPerDay + "\n"
                + "Salary per hour: " + weekSalary / (5 * workHoursPerDay);
                
        return result;
    }
}
