package code;

/**
 * To represent a order filter that checks if a order contains
 *   a certain product
 * 
 * @author Zhenhuan Wu; Zhen Wei
 * @version 2014.6.17
 */
public class OrderContainingSpecificProductFilter implements IOrderFilter {
    private int productID;

    /**
     * To construct this filter
     * 
     * @param productID
     *            the given product ID
     */
    OrderContainingSpecificProductFilter(int productID) {
        super();
        this.productID = productID;
    }

    /**
     * To determine if the given order has the certain product in which/it.
     * @param o the given order
     * @return the boolean result
     */
    public boolean filter(Order o) {
        for (Order.Item i : o.getItems()) {
            if (i.getProduct().getItemID() == productID) {
                return true;
            }
        }
        return false;
    }
}
