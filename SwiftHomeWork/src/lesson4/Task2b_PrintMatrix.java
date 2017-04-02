package lesson4;

/**
 *
 * @author aizeeck
 */
public class Task2b_PrintMatrix {

    public static void main(String[] args) {
        int size = 4;
        int counter = 0;
        int[][] arr = new int[size][size];
        
        int row = 0;
        int col = 0;
        int correctorY = 1;
        int visits = size;
        
        for (int i = 0; i < (size * size); i++) {
            arr[row][col] = ++counter;
            if (--visits == 0) {
                col++;
                row += correctorY;
                correctorY *= -1;
                visits = size;
            }
            //printMe(arr);
            //System.out.println();
            row += correctorY;
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
