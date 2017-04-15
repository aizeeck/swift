package lesson6.Task4_Market;

/**
 *
 * @author aizeeck
 */
public class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 1) {
            System.out.println("Product name has not been set");
        } else {
            this.name = name;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Price has not been set");
        } else {
            this.price = price;
        }
    }

}
