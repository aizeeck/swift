package lesson7.Task1_PeoplePresentation;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task1_PeoplePresentation {

    public static void main(String[] args) {

        
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("END")) {
                break;
            }
            Persone p = createPersone(line.split(" "));
            System.out.println(p + "\n");
        }
    }
    
    private static Persone createPersone(String[] personeStrings) {
        if (personeStrings.length == 5) {
            return new Student(personeStrings[0],
                    personeStrings[1], 
                    personeStrings[2],
                    Integer.parseInt(personeStrings[3]),
                    Integer.parseInt(personeStrings[4])
                    );
        } else {
            return new Worker(personeStrings[0],
                    personeStrings[1],
                    Double.parseDouble(personeStrings[2]),
                    Double.parseDouble(personeStrings[3])
                    );
        }
    }
}
