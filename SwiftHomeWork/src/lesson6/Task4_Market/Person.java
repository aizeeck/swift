package lesson6.Task4_Market;

/**
 *
 * @author aizeeck
 */
public class Person {

    private String name;
    private double balance;
    private Product[] products = new Product[500];
    private int productCounter = 0;
    public Person(String name, double balance) {
        setName(name);
        setBalance(balance);
    }

    public void addProduct (Product product) {
        products[productCounter] = product;
        productCounter++;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 1) {
            System.out.println("Person name has not been set");
        } else {
            this.name = name;
        }
    }

    public double getBalance() {
        return balance;
    }

    public Product[] getProducts() {
        return products;
    }
    
    public void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("Balance has not been set");
        } else {
            this.balance = balance;
        }
    }

    public int getProductCounter() {
        return productCounter;
    }

    
}
