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
public class Task8_SecondsInBiggerIntervals {
    public static void main(String[] args) {
        int input = 1800;
        int days = 0;
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        
        days = input/60/60/24;
        input -= days*60*60*24;
        hours = input/60/60;
        input -= hours*60*60;
        minutes = input/60;
        input -= minutes*60;
        seconds = input;        
        
        
        
        
        System.out.println(days + " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds");
    }
}
