package code;
/**
 * 
 */

/**
 * @author Zhenhuan Wu; Zhen Wei
 * @version 2014.6.18
 */
public interface IOrderFilter {
    /**
     * To filter the given order
     * @param o the given order
     * @return - true if the given order is qualified
     *         - false if the given order is not qualified
     */
    public boolean filter(Order o);
}
