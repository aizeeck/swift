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

        if (!validateLatinLetters(firstName)){
            System.out.println("Expected only Latin letters in\n" +
                    "firstName");
            return;
        }

        if (2 > firstName.length() && firstName.length() > 30) {
            System.out.println("Expected length for firstName is\n" +
                    "between 2 and 30 symbols.");
            return;
        }

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if ('Z' <= lastName.charAt(0) && lastName.charAt(0) <= 'A') {
            System.out.println("Expected upper case letter at first\n" +
                    "position of lastName.");
            return;
        }

        if (!validateLatinLetters(lastName)){
            System.out.println("Expected only Latin letters in\n" +
                    "lastName");
            return;
        }

        if (2 > lastName.length() && lastName.length() > 30) {
            System.out.println("Expected length for lastName is\n" +
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

    private boolean validateLatinLetters(String s) {
        for (char c : s.toCharArray()) {
            if (!('A' <= c && c <= 'Z') && !('a' <= c && c <= 'z')) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "First name: " + firstName + "\n"
                + "Last name: " + lastName + "\n";
        return result;
    }
    
    
}
