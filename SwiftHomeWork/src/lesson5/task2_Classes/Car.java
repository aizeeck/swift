package lesson5.task2_Classes;

import java.util.Date;

/**
 *
 * @author aizeeck
 */
public class Car {
    String brand;
    String model;
    int power;
    int deliveryYear;
    int category;
    
    public int insuranceCategory() {
        int cat = 0;
        int currentYear = new Date().getYear() + 1900;
        int age = currentYear - deliveryYear;
        
        if (age <= 8) {
            category = 1;
        } else if (age <= 15) {
            category = 2;
        } else if (age <= 25) {
            category = 3;
        } else if (age > 25) {
            category = 4;
        }
        return category;
    }
    
    public static void main(String[] args) {
        Car c = new Car();
        System.out.println(c.insuranceCategory());
    }
}
