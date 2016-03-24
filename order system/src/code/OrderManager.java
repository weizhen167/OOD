package code;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * @author Zhenhuan Wu; Zhen Wei
 * @version 2014.6.17
 */
public class OrderManager {
    private ArrayList<Order> orders;
    
    /**
     * To construct a empty order manager
     */
    OrderManager() {
        super();
        this.orders = new ArrayList<Order>();
    }
    /**
     * Effect:
     * To add an order to order manager
     *  - if the given order id already exists than replace with the newer one 
     * @param order the given order
     */
    void add(Order order) {
        for (int i = 0; i < this.orders.size(); i++) {
            if (this.orders.get(i).getOrderID() == order.getOrderID()) {
                this.orders.set(i, order);
                return;
            }
        }
        this.orders.add(order);
    }
    /**
     * To get the customer associated to the given customer ID
     * @param orderID the order ID of which user wants the order
     * @return the associated customer
     */
    public Order get(int orderID) {
        for (Order o : this.orders) {
            if (o.getOrderID() == orderID) {
                return o;
            }
        }
        throw new NoSuchElementException("Order " + orderID +
                " is not found in " + this.toString() + ".");
    }
    /**
     * To get an ArrayList of all orders available
     * @return an ArrayList of all orders available
     */
    ArrayList<Order> getAllOrders() {
        return this.orders;
    }
    /**
     * To get the orders that meet the requirement of the given order filter
     * @param of the given order filter
     * @return a list of orders
     */
    ArrayList<Order> getOrders(IOrderFilter of) {
        ArrayList<Order> result = new ArrayList<Order>();
        for (Order o : this.orders) {
            if (of.filter(o)) {
                result.add(o);
            }
        }
        return result;
    } 
    /**
     * To get the orders expanded that
     *  meet the requirement of the given order filter
     * @param of the given order filter
     * @return 2D list for JTable
     */
    List<List<Object>> getOrdersExpandedForJTable(IOrderFilter of) {
        ArrayList<Order> orderList = (of == null) ? 
                this.getAllOrders() : this.getOrders(of);
        List<List<Object>> table = new ArrayList<List<Object>>();
        for (Order order : orderList) {
            for (Order.Item item : order.getItems()) {
                ArrayList<Object> row = new ArrayList<Object>();
                row.add(order.getCustomer().getCustomerID());
                row.add(order.getCustomer().getLastName());
                row.add(order.getCustomer().getAddress());
                row.add(order.getCustomer().getCity());
                row.add(order.getCustomer().getState());
                row.add(order.getCustomer().getZipCode());
                row.add(order.getOrderID());
                row.add(order.isPaid() ? "Yes" : "No");
                row.add(order.getOrderDate());
                row.add(order.getPickDate());
                row.add(item.getProduct().getItemID());
                row.add(item.getProduct().getItemName());
                row.add(item.getProduct().getCategory());
                row.add(item.getQuantity());
                row.add(item.getPrice());
                row.add(order.getTotalPrice());
                row.add(order.getDiscountUsedOnOrder());
                row.add(order.getTotalDue());
                row.add(order.getCustomer().getAvailableDiscount());
                row.add(order.getCustomer().getCurrentLoyalty());
                table.add(row);
            }
        }
        return table;
    }
//    /**
//     * To get the orders unexpanded 
//     *  that meet the requirement of the given order filter
//     * @param of the given order filter
//     * @return 2D list for JTable
//     */
//    List<List<Object>> getOrdersForJTable(IOrderFilter of) {
//        ArrayList<Order> orderList = (of == null) ? 
//                this.getAllOrders() : this.getOrders(of);
//        List<List<Object>> table = new ArrayList<List<Object>>();
//        for (Order order : orderList) {
//            ArrayList<Object> row = new ArrayList<Object>();
//            
//            row.add(order.getCustomer().getCustomerID());
//            row.add(order.getCustomer().getLastName());
//            row.add(order.getCustomer().getAddress());
//            row.add(order.getCustomer().getCity());
//            row.add(order.getCustomer().getState());
//            row.add(order.getCustomer().getZipCode());
//            row.add(order.getOrderID());
//            row.add(order.isPaid() ? "Yes" : "No");
//            row.add(order.getOrderDate());
//            row.add(order.getPickDate());
//            row.add(order.getTotalPrice());
//            row.add(order.getDiscountUsedOnOrder());
//            row.add(order.getTotalDue());
//            row.add(order.getCustomer().getAvailableDiscount());
//            row.add(order.getCustomer().getCurrentLoyalty());
//            
//            table.add(row);
//        }
//        return table;
//    }
    /**
     * To determine if this order manager contains the product 
     *      with the given order ID
     * @param orderID the given order ID
     * @return the boolean result
     */
    boolean contains(int orderID) {
        for (Order o : this.orders) {
            if (o.getOrderID() == orderID) {
                return true;
            }
        }
        return false;
    }
}
