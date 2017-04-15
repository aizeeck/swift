package lesson6.Task4_Market;

import java.util.Scanner;

/**
 *
 * @author aizeeck
 */
public class Task4_Market {

    public static void main(String[] args) {

        MarketManager marketManager = new MarketManager();
        Scanner scanner = new Scanner(System.in);
        String createReport = "";
        //creare persones
        String personeLine = scanner.nextLine();
        createReport = marketManager.createPersones(personeLine);
        if (!createReport.equals("OK")) {
            System.out.println(createReport);
            return;
        }
        //create products
        String productLine = scanner.nextLine();
        createReport = marketManager.createProducts(productLine);
        if (!createReport.equals("OK")) {
            System.out.println(createReport);
            return;
        }
        //buy products
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("END")) {
                break;
            }
            marketManager.buyProduct(line);
        }
        
        marketManager.printReport();
    }

}
