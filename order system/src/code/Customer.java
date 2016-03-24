package code;
import java.util.ArrayList;

/**
 * 
 */

/**
 * To represent a customer of the bakery
 * @author Zhenhuan Wu; Zhen Wei
 * @version 2014.6.18
 */
public class Customer {
    private int customerID;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private boolean loyaltyCard;
    private double currentLoyalty;
    private double availableDiscount;
    
    private ArrayList<Order> orders;

    /**
     * @param customerID the customer ID
     * @param lastName the last name
     * @param address the address
     * @param city the city where the customer live in
     * @param state the state where the customer live in
     * @param zipCode the zip code
     * @param loyaltyCard if the customer has loyalty card
     * @param accumulatedConsumption the accumulated consumption
     * @param availableDiscount the available discount
     * @param orders the orders that has been placed
     */
    Customer(int customerID, String lastName, String address, String city,
            String state, int zipCode, boolean loyaltyCard,
            double accumulatedConsumption, double availableDiscount,
            ArrayList<Order> orders) {
        super();
        this.customerID = customerID;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.loyaltyCard = loyaltyCard;
        this.currentLoyalty = accumulatedConsumption;
        this.availableDiscount = availableDiscount;
        this.orders = orders;
    }
    /**
     * To add the given order to this customer
     * @param order the given order
     * @return the customer after adding order 
     */
    Customer addOrder(Order order) {
        for (int i = 0; i < this.orders.size(); i++) {
            if (this.orders.get(i).getOrderID() == order.getOrderID()) {
                this.orders.set(i, order);
                return this;
            }
        }
        this.orders.add(order);
        return this;
    }
    /**
     * To get the customer ID
     * @return the customer ID
     */
    public int getCustomerID() {
        return this.customerID;
    }
    /**
     * To get the last name of this customer
     * @return the last name
     */
    public String getLastName() {
        return this.lastName;
    }
    /**
     * To get the address of this customer
     * @return the address
     */
    public String getAddress() {
        return this.address;
    }
    /**
     * To get the city of this customer
     * @return the city
     */
    public String getCity() {
        return this.city;
    }
    /**
     * To get the state of this customer
     * @return the state
     */
    public String getState() {
        return this.state;
    }
    /**
     * To get the ZIP code of this customer
     * @return the ZIP code
     */
    public int getZipCode() {
        return this.zipCode;
    }
    /**
     * To get all orders that has been placed
     * @return the orders
     */
    public ArrayList<Order> getOrders() {
        return this.orders;
    }
    /**
     * To determine if this customer has loyaty card
     * @return the boolean result
     */
    public boolean hasLoyaltyCard() {
        return this.loyaltyCard;
    }
    /**
     * To get the available discount of this customer
     * @return the available discount of this customer
     */
    public double getAvailableDiscount() {
        return this.availableDiscount;
    }
    /**
     * To get the current accumulated consumption at this bakery
     * @return the accumulated consumption at this bakery
     */
    public double getCurrentLoyalty() {
        return this.currentLoyalty;
    }
    /**
     * To determine if this customer has the order with the given order ID
     * @param orderID the given order ID 
     * @return the boolean result
     */
    public boolean containsOrder(int orderID) {
        for (Order o : this.orders) {
            if (o.getOrderID() == orderID) {
                return true;
            }            
        }
        return false;
    }

    /**
     * EFFECT:
     * To set the last name of this customer
     * @param lastName the new lastName the last name of this customer
     */
    void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * EFFECT:
     * To set the address of this customer
     * @param address the new address of this customer
     */
    void setAddress(String address) {
        this.address = address;
    }
    /**
     * EFFECT:
     * To set the city of this customer
     * @param city the new city where this customer lives
     */
    void setCity(String city) {
        this.city = city;
    }
    /**
     * EFFECT:
     * To set the state of this customer
     * @param state the new state where this customer lives
     */
    void setState(String state) {
        this.state = state;
    }
    /**
     * EFFECT:
     * To set the ZIP code of this customer
     * @param zipCode the new zip code
     */
    void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
    /**
     * EFFECT:
     * To set all orders that has been placed
     * @param orders the new orders
     */
    void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
    /**
     * EFFECT:
     * To set if this customer has loyalty card
     * @param loyaltyCard the new loyalty state
     */
    void setLoyaltyCard(boolean loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }
    /**
     * EFFECT:
     * To set the current accumulated consumption at this bakery
     * @param accumulatedConsumption the new current loyalty
     */
    void setCurrentLoyalty(double accumulatedConsumption) {
        this.currentLoyalty = accumulatedConsumption;
    }
    /**
     * EFFECT:
     * To set the current accumulated consumption at this bakery
     * @param availableDiscount the new available discount
     */
    void setAvailableDiscount(double availableDiscount) {
        this.availableDiscount = availableDiscount; 
    }
}
