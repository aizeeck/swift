package lesson4;

/**
 *
 * @author aizeeck
 */
public class Task2b_PrintMatrix {

    public static void main(String[] args) {
        int counter = 0;
        int[][] arr = new int[4][4];

        for (int col = 0; col < arr.length;) {
            int row = 0;
            for (; row < arr[col].length; row++) {
                arr[row][col] = ++counter;
            }
            //printMe(arr);

            row--;
            col++;
            for (; row >= 0; row--) {
                arr[row][col] = ++counter;
            }
            col++;
            //printMe(arr);
        }
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
