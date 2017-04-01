package lesson4;

/**
 *
 * @author aizeeck
 */
public class Task2d_PrintMatrix {

    public static void main(String[] args) {
        int size = 4;
        int counter = 0;
        int[][] arr = new int[size][size];

        int row = 0;
        int col = 0;
        int correctorX = 1;
        int correctorY = 0;
        int directionCchangeCounter = 0;
        int targets = size;

        for (int i = 0; i < (size * size); i++) {
            arr[row][col] = ++counter;
            if (--targets == 0) {
                //printMe(arr);
                //System.out.println();
                targets = size * (directionCchangeCounter % 2) + size * ((directionCchangeCounter + 1) % 2) - (directionCchangeCounter / 2 - 1) - 2;
                //System.out.println("targets: " + targets);
                int tmp = correctorX;
                correctorX = -correctorY;
                correctorY = tmp;
                directionCchangeCounter++;
            }
            col += correctorX;
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
