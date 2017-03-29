package swiftacademy.lesson4;

/**
 *
 * @author aizeeck
 */
public class Task1e_Print2dArray {

    public static void main(String[] args) {
        int counter = 0;
        int[][] arr = new int[4][4];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = ++counter;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%2d " ,arr[i][j]);
            }
            System.out.println();
        }
        
    }
}
