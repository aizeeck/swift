package lesson4;

/**
 *
 * @author aizeeck
 */
public class Тask2b_PrintMatrix {

    public static void main(String[] args) {
        int counter = 0;
        int[][] arr = new int[4][4];

        for (int col = 0; col < arr.length; col++) {
            for (int row = 0; row < arr[col].length; row++) {
                arr[row][col] = ++counter;
            }
//            counter = counter + arr.length;
//            for (int row = 0; row < arr[col].length; row++) {
//                arr[col][row] = --counter;
//            }
        }

        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%4d ", arr[i][j]);
            }
            System.out.println();
        }

    }
}
