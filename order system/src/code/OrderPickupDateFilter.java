package code;

/**
 * To represent a order pick-up data filter checking 
 *      if a order is placed on the given date
 * @author Zhenhuan
 * @version 2014.6.17
 */
public class OrderPickupDateFilter implements IOrderFilter {
    private String givenDate;    
    /**
     * To represent a order pick-up data filter
     * @param givenDate the given date
     */
    OrderPickupDateFilter(String givenDate) {
        super();
        this.givenDate = givenDate;
    }    
    /**
     * To filter the order if the order is picked up on the given date
     * @param o the given order
     * @return the boolean result
     */
    public boolean filter(Order o) {
        return o.getPickDate().equals(this.givenDate);
    }

}
