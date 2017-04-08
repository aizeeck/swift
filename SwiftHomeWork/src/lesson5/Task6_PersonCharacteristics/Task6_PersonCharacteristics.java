/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson5.Task6_PersonCharacteristics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author aizeeck
 */
public class Task6_PersonCharacteristics {

    public static void main(String[] args) throws IOException {

        int iterations = 0;
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        iterations = Integer.parseInt(reader.readLine());
        Persone[] persones = new Persone[iterations];
        
        for (int i = 0; i < iterations; i++) {
            String line = reader.readLine();
            String[] characteristics = line.split(";");
            persones[i] = new Persone(
            characteristics[0],
            characteristics[1],
            characteristics[2].charAt(0),
            Integer.parseInt(characteristics[3]),
            Double.parseDouble(characteristics[4]),
            Double.parseDouble(characteristics[5]),
            characteristics[6],
            Double.parseDouble(characteristics[7]),
            Double.parseDouble(characteristics[8]),
            Double.parseDouble(characteristics[9]),
            Double.parseDouble(characteristics[10]));
            System.out.print(persones[i].toString());
        }
    }
}
