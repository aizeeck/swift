package lesson5.VehicleMonitor;

import java.util.Date;
import lesson5.task2_Classes.Car;

/**
 *
 * @author aizeeck
 * !!! С цел повторно използване на готов код Vehicle extends
 * Car. В случая разпределението на полетата межде тези класове не е логично,
 * както и по-логично в една реална ситуация Car extends Vehicle.
 */
public class Vehicle extends Car {
    
    static int licenseNoTemp = 0;
    private String type;
    private int licenseNo;
    private double weight;
    private double fuelConsumption;
    private String color = "N/A";

    public Vehicle(String type, String model, int power, double fuelConsumption, int deliveryYear) {
        super(model, deliveryYear, power);
        this.type = type;
        this.fuelConsumption = fuelConsumption;
        this.licenseNo = licenseNoTemp++;
    }

    public Vehicle(String type, String model, int power, double fuelConsumption, int deliveryYear, double weight, String color) {
        super(model, deliveryYear, power);
        this.type = type;
        this.fuelConsumption = fuelConsumption;
        this.licenseNo = licenseNoTemp++;
        this.weight = weight;
        this.color = color;
    }

    public double calculateTripPrice(double fuelPrice, double distance) {
        return fuelPrice * fuelConsumption * distance / 100;
    }

    public double getInsurancePrice() {
        return (0.16 * super.getPower()) * (1.25 * calculateAge()) * (0.05 * fuelConsumption) * calculateTypeCoefficient();
    }

    private double calculateTypeCoefficient() {
        switch (getType()) {
            case "car":
                return 1.00d;
            case "suv":
                return 1.12d;
            case "truck":
                return 1.20d;
            case "motorcycle":
                return 1.50d;
            default:
                return 0.00d;
        }
    }

    private int calculateAge() {
        int currentYear = new Date().getYear() + 1900;
        return currentYear - getDeliveryYear();
    }

    public String getType() {
        return type;
    }

    public int getLicenseNo() {
        return licenseNo;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public String toString() {
        String info = String.format("%04d - %s, %04d, %s \nInsurance cost: %.2f",
                getLicenseNo(), getModel(), getDeliveryYear(), getColor(), getInsurancePrice());
        return info;
    }

}
