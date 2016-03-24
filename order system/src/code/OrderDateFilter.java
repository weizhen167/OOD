package code;

/**
 * To represent a order data filter checking if a order is placed on the given
 * date
 * 
 * @author Zhenhuan Wu; Zhen Wei
 * @version 2014.6.17
 */
public class OrderDateFilter implements IOrderFilter {
    private String givenDate;

    /**
     * To represent a order date filter
     * 
     * @param givenDate
     *            the given date
     */
    OrderDateFilter(String givenDate) {
        super();
        this.givenDate = givenDate;
    }

    /**
     * To filter the order if the order is placed on the given date
     * @param o the given order to be filtered
     * @return the boolean result
     */
    public boolean filter(Order o) {
        return o.getOrderDate().equals(this.givenDate);
    }

}