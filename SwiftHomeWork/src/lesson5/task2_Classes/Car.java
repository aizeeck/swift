package lesson5.task2_Classes;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Car {

    private String brand;
    private String model;
    private int power;
    private int deliveryYear;

    public Car(String brand, String model, int deliveryYear, int power) {
        this.brand = brand;
        this.model = model;
        this.power = power;
        this.deliveryYear = deliveryYear;
    }

    public Car(String model, int deliveryYear, int power) {
        this.model = model;
        this.power = power;
        this.deliveryYear = deliveryYear;
    }

    public int insuranceCategory() {
        int category = 0;
        int currentYear = new Date().getYear() + 1900;
        int age = currentYear - getDeliveryYear();

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

    public double getTaxValue() {
        double taxValue = 0;
        int category = insuranceCategory();
        switch (category) {
            case 1:
                taxValue = 150;
                break;
            case 2:
                taxValue = 200;
                break;
            case 3:
                taxValue = 300;
                break;
            case 4:
                taxValue = 500;
                break;
        }
        return getAdjustedTaxValue(taxValue);
    }

    private double getAdjustedTaxValue(double initialTaxValue) {
        int power = getPower();
        if (power <= 80) {
            return initialTaxValue * 1.2;
        } else if (power >= 140) {
            return initialTaxValue * 1.45;
        } else {
            return initialTaxValue;
        }
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setDeliveryYear(int deliveryYear) {
        this.deliveryYear = deliveryYear;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getDeliveryYear() {
        return deliveryYear;
    }

    @Override
    public String toString() {
        return "Car{" + "brand=" + brand + ", model=" + model + ", power=" + power + ", deliveryYear=" + deliveryYear + '}';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car c = new Car(
                scanner.next(),
                scanner.next(),
                scanner.nextInt(),
                scanner.nextInt()
        );
        System.out.println(c.getTaxValue());
    }
}
