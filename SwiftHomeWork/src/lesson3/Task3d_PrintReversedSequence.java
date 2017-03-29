package swiftacademy.lesson3;


import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task3d_PrintReversedSequence {

    public static void main(String[] args) {
        int iterations = 0;
        String inputNums = "";
        String outputNums = "";
        Scanner scanner = new Scanner(System.in);
        iterations = scanner.nextInt();
        for (int i = 0; i < iterations; i++) {
            inputNums = scanner.nextInt() + " " + inputNums;
        }
        System.out.println(inputNums);
    }
}
