package lesson5.VehicleMonitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author aizeeck
 */
public class Task5_VehicleMonitor {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        double F = Double.parseDouble(reader.readLine());
        String[] vehiclelStrings = new String[N];

        for (int i = 0; i < N; i++) {
            vehiclelStrings[i] = reader.readLine();
        }
        Vehicle[] vehicle = constructVehicles(vehiclelStrings);
        for (int i = 0; i < N; i++) {
            System.out.print(vehicle[i]);
            System.out.printf("- Travel cost: %.2f\n", vehicle[i].calculateTripPrice(F, Double.parseDouble(vehiclelStrings[i].split(",")[5])));
        }
    }

    /*
    !!! Понеже разстоянието не е поле от класа Vehicle, 
        то се пази във масив от входните и се използва само при изчисляване/разпечатване на цената на пътуване.
     */
    private static Vehicle[] constructVehicles(String[] vehiclelStrings) {
        Vehicle[] vehicle = new Vehicle[vehiclelStrings.length];
        for (int i = 0; i < vehiclelStrings.length; i++) {
            String[] vehiclelConstruct = vehiclelStrings[i].split(",");
            switch (vehiclelConstruct.length) {
                case 8:
                    vehicle[i] = new Vehicle(
                            vehiclelConstruct[0].trim(),
                            vehiclelConstruct[1].trim(),
                            Integer.parseInt(vehiclelConstruct[2].trim()),
                            Double.parseDouble(vehiclelConstruct[3].trim()),
                            Integer.parseInt(vehiclelConstruct[4].trim()),
                            Double.parseDouble(vehiclelConstruct[6].trim()),
                            vehiclelConstruct[7].trim());
                    break;
                case 6:
                    vehicle[i] = new Vehicle(
                            vehiclelConstruct[0].trim(),
                            vehiclelConstruct[1].trim(),
                            Integer.parseInt(vehiclelConstruct[2].trim()),
                            Double.parseDouble(vehiclelConstruct[3].trim()),
                            Integer.parseInt(vehiclelConstruct[4].trim()));
                    break;
                default:
            }
        }
        return vehicle;
    }
}
