package lesson7.Task1_PeoplePresentation;

/**
 *
 * @author aizeeck
 */
public class Persone {
    private String firstName;
    private String lastName;

    public Persone(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public void setFirstName(String firstName) {

        if ('Z' < firstName.charAt(0) && firstName.charAt(0) <= 'A') {
           System.out.println("Expected upper case letter at first\n" +
                    "position of firstName.");
           return;
        }

        if (2 > firstName.length() && firstName.length() > 30) {
            System.out.println("Expected length for <parameter> is\n" +
                    "between 2 and 30 symbols.");
            return;
        }

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if ('Z' <= firstName.charAt(0) && firstName.charAt(0) <= 'A') {
            System.out.println("Expected upper case letter at first\n" +
                    "position of lastName.");
            return;
        }

        if (2 > firstName.length() && firstName.length() > 30) {
            System.out.println("Expected length for <parameter> is\n" +
                    "between 2 and 30 symbols.");
            return;
        }

        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        String result = "First name: " + firstName + "\n"
                + "Last name: " + lastName + "\n";
        return result;
    }
    
    
}
