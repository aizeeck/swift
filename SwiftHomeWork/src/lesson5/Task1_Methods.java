package lesson5;

import java.util.Arrays;

/**
 *
 * @author aizeeck
 */
public class Task1_Methods {

    public static void task1a_Printing(String name, int age) {
        System.out.printf("%s is %d years old.", name, age);
    }

    public static boolean task1b_AreEqual(int num1, int num2) {
        return num1 == num2;
    }

    public static int task1c_IndexOf(int[] arr, int num) {
        int index = Arrays.binarySearch(arr, num);
        return index < 0 ? -1 : index;
    }

    public static void main(String[] args) {
        task1a_Printing("Stoyan", 12);
        System.out.println();
        System.out.println(task1b_AreEqual(1, 0));
        int[] arr = {1,2,3};
        System.out.println(task1c_IndexOf(arr, 2));
    }
}
