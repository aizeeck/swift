/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swiftacademy.lesson3;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task3b_PrintSumOfN {

    public static void main(String[] args) {
        int iterrations = 0;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        iterrations = scanner.nextInt();
        for (int i = 0; i < iterrations; i++) {
            sum += scanner.nextInt();
        }
        System.out.println(sum);
    }
}
