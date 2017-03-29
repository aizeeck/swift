/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swiftacademy.lesson2;

/**
 *
 * @author aizeeck
 */
public class Task9_LeapYear {
    public static void main(String[] args) {
        int input = 1500;
        boolean isLeapYear = false;
        isLeapYear = (input % 400 == 0) || ((input % 4 == 0) && (input % 100 != 0));
        System.out.println(isLeapYear);
    }
}