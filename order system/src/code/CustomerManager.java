package code;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * To represent a customer manager of this bakery
 * @author Zhenhuan Wu; Zhen Wei
 * @version 2014.6.18
 */
public class CustomerManager {
    private ArrayList<Customer> customers;
    /**
     * To construct a empty customer manager
     */
    CustomerManager() {
        super();
        this.customers = new ArrayList<Customer>();
    }
    /**
     * Effect:
     * To add a customer to customer manager
     * @param c the given customer
     */
    void add(Customer c) {
        this.customers.add(c);
    }
    /**
     * To get the customer associated to the given customer ID
     * @param customerID the customer ID of this customer
     * @return the associated customer
     */
    public Customer get(int customerID) {
        for (Customer c : this.customers) {
            if (c.getCustomerID() == customerID) {
                return c;
            }
        }
        throw new NoSuchElementException("Customer " + customerID +
                "is not found in " + this.toString() + ".");
    }
    /**
     * To get an ArrayList of all customers available
     * @return an ArrayList of all customers available
     */
    public ArrayList<Customer> getAllCustomers() {
        return this.customers;
    }

    /**
     * To determine if this customer manager contains the product 
     *      with the given product ID
     * @param customerID the given customer ID integer
     * @return the boolean result
     */
    public boolean contains(int customerID) {
        for (Customer c : this.customers) {
            if (c.getCustomerID() == customerID) {
                return true;
            }
        }
        return false;
    }
}