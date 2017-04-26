package lesson8.Task1_School;

/**
 * Created by aizeeck on 26.04.17.
 */
public class Discipline {
    private String name;
    private double hoursPerWeek;

    public Discipline(String name) {
        this.name = name;
    }

    public double getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(double hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }
}
