package lesson7.Task1_PeoplePresentation;

/**
 *
 * @author aizeeck
 */
public class Persone {
    private String firstName;
    private String lastName;

    public Persone(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        String result = "First name: " + firstName + "\n"
                + "Last name: " + lastName + "\n";
        return result;
    }
    
    
}
