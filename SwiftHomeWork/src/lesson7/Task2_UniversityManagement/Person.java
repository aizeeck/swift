package lesson7.Task2_UniversityManagement;

/**
 *
 * @author aizeeck
 */
public abstract class Person {
    private String name;
    private String phone;
    private int tolerance;

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.tolerance = 20;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String result = "First name: " + name + "\n"
                + "Phone : " + phone + "\n";
        return result;
    }


    abstract public void work();

    public void increaseTolerance(int i) {
        if (i > 0) {
            this.tolerance += i;
        }
    }
}
