package lesson4;

/**
 *
 * @author aizeeck
 */
public class Task2c_PrintMatrix {

    public static void main(String[] args) {
        int size = 4;
        int counter = 0;
        int[][] arr = new int[size][size];

        int row = 0;
        int col = 0;
        int correctorX = 1;
        int correctorY = 1;


        printMe(arr);
    }

    private static void printMe(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%4d ", arr[i][j]);
            }
            System.out.println();
        }
    }
}
