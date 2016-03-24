package code;

/**
 * @author Zhenhuan Wu; Zhen Wei
 * @version 2014.6.18
 */
public class OrderOfSpecificCustomerFilter implements IOrderFilter {
    private int customerID;

    /**
     * To construct this filter
     * 
     * @param customerID
     *            the customer ID of the certain customer
     */
    public OrderOfSpecificCustomerFilter(int customerID) {
        super();
        this.customerID = customerID;
    }

    /**
     * To filter the order if the order belongs to the given customer
     * 
     * @param o
     *            the given order
     * @return the boolean result
     */
    public boolean filter(Order o) {
        return o.getCustomer().getCustomerID() == this.customerID;
    }
}
