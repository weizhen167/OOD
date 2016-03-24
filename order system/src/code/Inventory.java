package code;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * @author Zhenhuan Wu; Zhen Wei
 * @version 2014.6.18
 */
public class Inventory {
    private ArrayList<Product> products;

    /**
     * To construct an empty inventory
     */
    Inventory() {
        super();
        this.products = new ArrayList<Product>();
    }
    /**
     * Effect:
     * To add a product to inventory
     * @param p the given product
     */
    void add(Product p) {
        this.products.add(p);
    }
    /**
     * To get the product associated to the given product ID
     * @param productID the given product ID, integer
     * @return the associated product
     */
    Product get(int productID) {
        for (Product p : this.products) {
            if (p.getItemID() == productID) {
                return p;
            }
        }
        throw new NoSuchElementException("Product " + productID +
                " is not found in " + this.toString() + ".");
    }
    /**
     * To get an ArrayList of all products available
     * @return an ArrayList of all products available
     */
    ArrayList<Product> getAllProducts() {
        return this.products;
    }
    /**
     * To determine if this inventory contains the product 
     *      with the given product ID
     * @param productID the given product ID
     * @return the boolean result
     */
    public boolean contains(int productID) {
        for (Product p : this.products) {
            if (p.getItemID() == productID) {
                return true;
            }
        }
        return false;
    }
}
