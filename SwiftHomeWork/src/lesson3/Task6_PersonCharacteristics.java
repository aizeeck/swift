package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task6_PersonCharacteristics {

    public static void main(String[] args) {
        int iterations = 0;
        int yearBorn = 0;
        int yearsOld = 0;
        float weight = 0.00f;
        float tall = 0.00f;
        String firstName = "";
        String lastName = "";
        String profession = "";
        String output = "";
        Scanner scanner = new Scanner(System.in);
        
        iterations = scanner.nextInt();
        
        for (int i = 0; i < iterations; i++) {
            firstName = scanner.next();
            lastName = scanner.next();
            yearBorn = scanner.nextInt();
            yearsOld = 2016 - yearBorn;
            weight = scanner.nextFloat();
            tall = scanner.nextFloat();
            profession = scanner.next();
            
            if (yearsOld >= 18) {
            output += String.format("%s %s is %d years old. He was born in %d. His weight is %f and he is %.0f cm tall. He is a %s.\n",
                    firstName,
                    lastName,
                    yearsOld,
                    yearBorn,
                    weight,
                    tall,
                    profession
                    );
            } else {
                output += String.format("%s %s is under-aged.\n",
                    firstName,
                    lastName);
            }
        }
        System.out.println(output);
        
        
    }

}
