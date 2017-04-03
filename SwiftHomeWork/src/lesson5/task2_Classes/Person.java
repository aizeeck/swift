package lesson5.task2_Classes;

/**
 *
 * @author aizeeck
 */
public class Person {

    String name;
    int age;

    public Person() {
        this.name = "No name";
        this.age = -1;
    }

    public Person(String name) {
        this.name = name;
        this.age = -1;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        if (name.length() > 0) {
            this.name = name;
        } else {
            System.out.println("Please enter a valid name.");
        }

    }

    public void setAge(int age) {
        if (age >= 0 && age <= 15) {
            this.age = age;
        } else {
            System.out.println("Please enter a valid number between 0 and 150.");
        }

    }

    public String introduce() {
        String introduceString = "";
        if (name.equals("No name")) {
            introduceString = "I am John Doe";
            return introduceString;
        } else if (age < 0) {
            introduceString += String.format("Hello, I am %s.", name);
            return introduceString;
        } else {
            introduceString += String.format("Hello, I am %s. I am %d years old.", name, age);
            return introduceString;
        }
    }
}
