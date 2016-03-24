package code;

/**
 * To represent a filter checking if a order is unpaid
 * @author Zhenhuan Wu; Zhen Wei
 * @version 2014.6.18
 */
public class UnpaidOrderFilter implements IOrderFilter {
    /**
     * To determine if is unpaid
     * @param o the given order
     * @return the boolean result
     */
    public boolean filter(Order o) {
        return !o.isPaid();
    }
}
