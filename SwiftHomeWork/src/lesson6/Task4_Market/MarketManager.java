package lesson6.Task4_Market;

/**
 *
 * @author aizeeck
 */
public class MarketManager {

    Person[] persones = new Person[200];
    Product[] products = new Product[200];

    String createPersones(String personeLine) {
        String[] personeSet = personeLine.split(";");
        for (int i = 0; i < personeSet.length; i++) {
            String[] personeCharacteristics = personeSet[i].split("=");
            String name = personeCharacteristics[0];
            double balance = Double.parseDouble(personeCharacteristics[1]);
            if (name.length() < 1) {
                return "Name can’t be empty";
            } else if (balance < 0) {
                return "Balance can’t be negative";
            } else {
                persones[i] = new Person(personeCharacteristics[0], Double.parseDouble(personeCharacteristics[1]));
            }
        }
        return "OK";
    }

    String createProducts(String personeLine) {
        String[] productSet = personeLine.split(";");
        for (int i = 0; i < productSet.length; i++) {
            String[] productCharacteristics = productSet[i].split("=");
            String name = productCharacteristics[0];
            double price = Double.parseDouble(productCharacteristics[1]);
            if (name.length() < 1) {
                return "Name can’t be empty";
            } else if (price < 0) {
                return "Price can’t be negative.";
            } else {
                products[i] = new Product(productCharacteristics[0], Double.parseDouble(productCharacteristics[1]));
            }
        }
        return "OK";
    }

    void buyProduct(String application) {
        Product product = getProductFromString(application);
        Person buyer = getPersoneByName(application.substring(0, application.length() - product.getName().length() - 1));
        if (buyer != null && buyer.getBalance() >= product.getPrice()) {
            buyer.addProduct(product);
            buyer.setBalance(buyer.getBalance() - product.getPrice());
            System.out.println(buyer.getName() + " bought " + product.getName());
            return;
        }
        if (buyer != null && buyer.getBalance() < product.getPrice()) {
            System.out.println(buyer.getName() + " can’t afford " + product.getName());
        }
    }

    private Person getPersoneByName(String name) {
        for (Person persone : persones) {
            if (persone != null && persone.getName().equals(name)) {
                return persone;
            }
        }
        return null;
    }

    private Product getProductFromString(String applicaton) {
        for (Product product : products) {
            if (product != null && applicaton.indexOf(product.getName()) > 0) {
                return product;
            }
        }
        return null;
    }

    void printReport() {
        String info = "";
        for (Person persone : persones) {
            if (persone == null) {
                break;
            }
            if (persone.getProductCounter() > 0) {
                info += persone.getName() + " ";
                for (Product product : persone.getProducts()) {
                    if (product == null) {
                        break;
                    }
                    info += product.getName() + ", ";
                }
                info = info.substring(0, info.length() - 2);
                info += "\n";
            } else {
                info += persone.getName() + " - Nothing bought\n";
            }
        }
        System.out.println(info);
    }
}
