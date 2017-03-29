/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swiftacademy.lesson2;

import java.util.Date;

/**
 *
 * @author aizeeck
 */
public class Task10_PersonCharacteristics {
    public static void main(String[] args) {
        String firstName = "Sergey";
        String lastName = "Vizirskiy";
        short birthYear = 1988;
        float weight = 62.4f;
        short tall = 172;
        String proffesion = "banker";
        short currentYear = (short) new Date().getYear();
        short age = (short) (1900 + currentYear - birthYear);
        
        System.out.println(firstName + " " + lastName + " is " + age + " years old. His weight is " + weight + " and he is " + tall + " cm tall. "
                + "He is a " + proffesion + ".");
    }
}
