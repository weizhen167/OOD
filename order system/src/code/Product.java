package code;

/**
 * @author Zhenhuan Wu; Zhen Wei
 * @version 2014.6.18
 */
class Product {
    private int itemID;
    private String itemName;
    private String category;
    private double price;
    /**
     * @param itemID BakeryItemID
     * @param itemName BakeryItemName
     * @param category Category
     * @param price Price
     */
    Product(int itemID, String itemName, String category, double price) {
        super();
        this.itemID = itemID;
        this.itemName = itemName;
        this.category = category;
        this.price = price;
    }
    /**
     * To get the item ID of this product
     * @return the Product ID
     */
    int getItemID() {
        return this.itemID;
    }
    /**
     * To get the item name of this product
     * @return the Product name
     */
    String getItemName() {
        return this.itemName;
    }
    /**
     * To get the item name of this product
     * @return the category
     */
    String getCategory() {
        return this.category;
    }
    /**
     * To get the item name of this product
     * @return the price
     */
    double getPrice() {
        return this.price;
    }
    /**
     * EFFECT: 
     * To set the item ID of this product
     * @param itemID the product ID
     */
    void setItemID(int itemID) {
        this.itemID = itemID;
    }
    /**
     * To set the item name of this product
     * @param itemName the product name
     */
    void setItemName(String itemName) {
        this.itemName = itemName;
    }
    /**
     * To set the item name of this product
     * @param category the new category of this product
     */
    void setCategory(String category) {
        this.category = category;
    }
    /**
     * To set the item name of this product but does not affect old orders
     * @param price the new price of this product
     */
    void setPrice(double price) {
        this.price = price;
    }
}
