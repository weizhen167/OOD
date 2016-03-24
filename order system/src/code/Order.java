package code;

import java.util.ArrayList;
import java.util.List;

/**
 * To represent the order made by a customer
 * 
 * @author Zhenhuan Wu; Zhen Wei
 * @version 2014.6.13
 */
public class Order {
    private Customer customer;
    private int orderID;
    private boolean paid;

    private String orderDate;
    private String pickupDate;

    private ArrayList<Item> items;
    private double discountUsedOnOrder;

    /**
     * @param customer
     *            the given customer
     * @param orderID
     *            the Order ID
     * @param paid
     *            if the order has been paid
     * @param orderDate
     *            the date when the order is placed
     * @param pickupDate
     *            the date when the order is picked up
     * @param discountUsedOnOrder
     *            unused discount, double type
     */
    Order(Customer customer, int orderID, boolean paid, String orderDate,
            String pickupDate, double discountUsedOnOrder) {
        super();
        this.customer = customer;
        this.orderID = orderID;
        this.paid = paid;
        this.orderDate = orderDate;
        this.pickupDate = pickupDate;
        this.items = new ArrayList<Item>();
        this.discountUsedOnOrder = discountUsedOnOrder;
    }

    /**
     * To get the customer who placed this order
     * 
     * @return the customer who placed this order
     */
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * To get the orderID of this order
     * 
     * @return the order ID
     */
    public int getOrderID() {
        return this.orderID;
    }

    /**
     * To determine if the order is paid
     * 
     * @return the boolean result
     */
    public boolean isPaid() {
        return this.paid;
    }

    /**
     * To get the Order Date of this order
     * 
     * @return the Order Date
     */
    public String getOrderDate() {
        return this.orderDate;
    }

    /**
     * To get the Order Date of this order
     * 
     * @return the Order Date
     */
    public String getPickDate() {
        return this.pickupDate;
    }

    /**
     * To calculate the total price
     * 
     * @return the total price
     */
    public double getTotalPrice() {
        double sum = 0;
        for (Item i : items) {
            sum += i.getTotalPrice();
        }
        return sum;
    }

    /**
     * To calculate the total due
     * 
     * @return the total due
     */
    public double getTotalDue() {
        return this.getTotalPrice() - this.discountUsedOnOrder;
    }

    /**
     * To get all items in this order
     * 
     * @return all items in this order
     */
    public ArrayList<Item> getItems() {
        return this.items;
    }

    /**
     * To get all items in this order in JTable
     * 
     * @return all items in this order in JTable
     */
    public List<List<Object>> getItemsInJTable() {
        List<List<Object>> table = new ArrayList<List<Object>>();
        for (Item i : this.items) {
            List<Object> row = new ArrayList<Object>();
            row.add(i.getProduct().getItemID());
            row.add(i.getQuantity());

            table.add(row);
        }
        return table;
    }

    /**
     * To get the discount used on order
     * 
     * @return the discount used on order
     */
    public double getDiscountUsedOnOrder() {
        return this.discountUsedOnOrder;
    }

    /**
     * EFFECT: To add the given product to this order
     * 
     * @param product
     *            the given product
     * @param quantity
     *            the quantity of the given product
     * @return this order
     */
    public Order addProduct(Product product, int quantity) {
        this.items.add(new Item(product, quantity));
        return this;
    }

    /**
     * EFFECT: To add the given product to this order
     * 
     * @param product
     *            the given product
     * @param quantity
     *            the quantity of the given product
     * @param price
     *            the given price that may be different from the inventory
     *             price
     * @return the order after adding a product
     */
    public Order addProduct(Product product, int quantity, double price) {
        this.items.add(new Item(product, quantity, price));
        return this;
    }

    /**
     * To represent an item of this order
     * 
     * @author Zhenhuan Wu; Zhen Wei
     * @version 2014.6.13
     */
    class Item {
        private Product product;
        private double price; // price in the inventory may change
                              // but here keep the same
        private int quantity;

        /**
         * To construct a item of this order
         * 
         * @param product
         *            the product that is being added
         * @param quantity
         *            the quantity of the product that is being added
         * @param price the
         *            price at that time when the order was placed
         */
        Item(Product product, int quantity, double price) {
            super();
            this.product = product;
            this.quantity = quantity;
            this.price = price;
        }

        /**
         * To construct a item of this order, price is the inventory price
         * 
         * @param product
         *            the product that is being added
         * @param quantity
         *            the quantity of the product that is being added
         */
        Item(Product product, int quantity) {
            super();
            this.product = product;
            this.quantity = quantity;
            this.price = product.getPrice();
        }

        /**
         * To obtain the product of this item
         * 
         * @return the product
         */
        Product getProduct() {
            return this.product;
        }

        /**
         * To obtain the quantity of this item
         * 
         * @return the quantity
         */
        int getQuantity() {
            return this.quantity;
        }

        /**
         * To get the price of this
         * 
         * @return the price of this
         */
        double getPrice() {
            return this.price;
        }

        /**
         * To calculate the total price (before discount) of this item
         * 
         * @return the total price before discount
         */
        double getTotalPrice() {
            return this.getPrice() * this.quantity;
        }
    }
}
