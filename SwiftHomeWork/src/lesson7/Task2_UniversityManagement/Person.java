package lesson7.Task2_UniversityManagement;

/**
 *
 * @author aizeeck
 */
public class Person {
    private String name;
    private String phone;

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        String result = "First name: " + name + "\n"
                + "Phone : " + phone + "\n";
        return result;
    }
    
    
}
