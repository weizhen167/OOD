package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * To represent a bakery
 * 
 * @author Zhenhuan Wu; Zhen Wei
 * @version 2014.6.18
 */
public class Bakery {
    private Inventory inventory;
    private CustomerManager customerManager;
    private OrderManager orderManager;

    private final String inventoryInputFile = "bakeryItems.txt";
    private final String ordersInputFile = "orders.txt";
    private final String inventoryOutputFile = "bakeryItemsOutput.txt";
    private final String ordersOutputFile = "ordersOutput.txt";

    /**
     * To construct a new empty bakery
     */
    public Bakery() {
        this.inventory = new Inventory();
        this.customerManager = new CustomerManager();
        this.orderManager = new OrderManager();
    }

    /**
     * To import inventory from the file
     */
    public void importInventory() {
        File file = new File(inventoryInputFile);
        try {
            Scanner input = new Scanner(file);
            input.useDelimiter("\t+");
            if (input.nextLine().equals(
                    "BakeryItemID" + "\t+" + "BakeryItemName" + "\t+"
                            + "Category" + "\t+" + "Price")) {
                input = new Scanner(input.nextLine());
            }
            input.useDelimiter("\t+");
            while (input.hasNextLine()) {
                int id = 0;
                String name = "";
                String category = "";
                double price = 0.0;
                id = input.nextInt();

                String l1 = input.nextLine();
                Scanner l1sanc = new Scanner(l1);
                l1sanc.useDelimiter("\t+");
                name = l1sanc.next();

                String l2 = l1sanc.nextLine();
                Scanner l2sanc = new Scanner(l2);
                l2sanc.useDelimiter("\t+");
                category = l2sanc.next();

                price = l2sanc.nextDouble();

                Product a = new Product(id, name, category, price);
                this.inventory.add(a);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * To import orders from file
     */
    public void importOrders() {
        File file = new File(ordersInputFile);
        try {
            Scanner input = new Scanner(file);
            input.useDelimiter(" \t+");
            if (input.nextLine().equals(
                    "CustomerID" + "\t+" + "LastName" + "\t+" + "Address"
                            + "\t+" + "City" + "\t+" + "State" + "\t+"
                            + "ZipCode" + "\t+" + "OrderID" + "\t+" + "Paid?"
                            + "\t+" + "OrderDate" + "\t+" + "PickupDate"
                            + "\t+" + "BakeryItemID" + "\t+" + "BakeryItemName"
                            + "\t+" + "BakeryItemCategory" + "\t+" + "Quantity"
                            + "\t+" + "Price" + "\t+" + "Total" + "\t+"
                            + "DiscountUsedOnOrder" + "\t+" + "TotalDue"
                            + "\t+" + "AvailableDiscount" + "\t+"
                            + "CurrentLoyalty")) {
                input = new Scanner(input.nextLine());
            }
            input.useDelimiter("\t+");
            while (input.hasNextLine()) {
                int customerID = 0;
                String lastName = "";
                String address = "";
                String city = "";
                String state = "";
                int zipCode = 0;
                int orderID = 0;
                boolean paid = true;
                String orderDate = "";
                String pickupDate = "";
                int itemID = 0;
                String itemName = "";
                String itemCategory = "";
                int quantity = 0;
                double price = 0.0;
                double total = 0.0;
                double discountUsedOnOrder = 0.0;
                double totalDue = 0.0;
                double availableDiscount = 0.0;
                double currentLoyalty = 0.0;

                customerID = input.nextInt();

                String l1 = input.nextLine();
                Scanner l1sanc = new Scanner(l1);
                l1sanc.useDelimiter("\t+");
                lastName = l1sanc.next();

                String l2 = l1sanc.nextLine();
                Scanner l2sanc = new Scanner(l2);
                l2sanc.useDelimiter("\t+");
                address = l2sanc.next();

                String l3 = l2sanc.nextLine();
                Scanner l3sanc = new Scanner(l3);
                l3sanc.useDelimiter("\t+");
                city = l3sanc.next();

                String l4 = l3sanc.nextLine();
                Scanner l4sanc = new Scanner(l4);
                l2sanc.useDelimiter("\t+");
                state = l4sanc.next();

                String l5 = l4sanc.nextLine();
                Scanner l5sanc = new Scanner(l5);
                l5sanc.useDelimiter("\t+");
                zipCode = l5sanc.nextInt();

                String l51 = l5sanc.nextLine();
                Scanner l51sanc = new Scanner(l51);
                l51sanc.useDelimiter("\t+");
                orderID = l51sanc.nextInt();

                String l52 = l51sanc.nextLine();
                Scanner l52sanc = new Scanner(l52);
                l52sanc.useDelimiter("\t+");
                if (l52sanc.next().equals("Yes")) {
                    paid = true;
                }
                else {
                    paid = false;
                }

                String l53 = l52sanc.nextLine();
                Scanner l53sanc = new Scanner(l53);
                l53sanc.useDelimiter("\t+");
                orderDate = l53sanc.next();

                String l54 = l53sanc.nextLine();
                Scanner l54sanc = new Scanner(l54);
                l54sanc.useDelimiter("\t+");
                pickupDate = l54sanc.next();

                String l6 = l54sanc.nextLine();
                Scanner l6sanc = new Scanner(l6);
                l6sanc.useDelimiter("\t+");
                itemID = l6sanc.nextInt();

                String l7 = l6sanc.nextLine();
                Scanner l7sanc = new Scanner(l7);
                l7sanc.useDelimiter("\t+");
                itemName = l7sanc.next();

                String l8 = l7sanc.nextLine();
                Scanner l8sanc = new Scanner(l8);
                l8sanc.useDelimiter("\t++");
                itemCategory = l8sanc.next();

                String l9 = l8sanc.nextLine();
                Scanner l9sanc = new Scanner(l9);
                l9sanc.useDelimiter("\t+");
                quantity = l9sanc.nextInt();

                String l10 = l9sanc.nextLine();
                Scanner l10sanc = new Scanner(l10);
                l10sanc.useDelimiter("\t+");
                price = l10sanc.nextDouble();

                String l11 = l10sanc.nextLine();
                Scanner l11sanc = new Scanner(l11);
                l11sanc.useDelimiter("\t+");
                total = l11sanc.nextDouble();

                String l12 = l11sanc.nextLine();
                Scanner l12sanc = new Scanner(l12);
                l12sanc.useDelimiter("\t+");
                discountUsedOnOrder = l12sanc.nextDouble();

                String l13 = l12sanc.nextLine();
                Scanner l13sanc = new Scanner(l13);
                l13sanc.useDelimiter("\t+");
                totalDue = l13sanc.nextDouble();

                String l14 = l13sanc.nextLine();
                Scanner l14sanc = new Scanner(l14);
                l14sanc.useDelimiter("\t+");
                availableDiscount = l14sanc.nextDouble();

                String l15 = l14sanc.nextLine();
                Scanner l15sanc = new Scanner(l15);
                l15sanc.useDelimiter("\t+");
                currentLoyalty = l15sanc.nextDouble();

                this.newOrder(customerID, lastName, address, city, state,
                        zipCode, orderID, paid, orderDate, pickupDate, itemID,
                        itemName, itemCategory, quantity, price, total,
                        discountUsedOnOrder, totalDue, availableDiscount,
                        currentLoyalty);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * add new order, need to fill all the information.
     * 
     * @param customerID
     *            integer
     * @param lastName
     *            String
     * @param address
     *            String
     * @param city
     *            String
     * @param state
     *            String
     * @param zipCode
     *            integer
     * @param orderID
     *            integer
     * @param paid
     *            String
     * @param orderDate
     *            String
     * @param pickupDate
     *            String
     * @param itemID
     *            integer
     * @param itemName
     *            String
     * @param itemCategory
     *            String
     * @param quantity
     *            integer
     * @param price
     *            Double
     * @param total
     *            Double
     * @param discountUsedOnOrder
     *            Double
     * @param totalDue
     *            Double
     * @param availableDiscount
     *            Double
     * @param currentLoyalty
     *            Double
     */
    void newOrder(int customerID, String lastName, String address, String city,
            String state, int zipCode, int orderID, boolean paid,
            String orderDate, String pickupDate, int itemID, String itemName,
            String itemCategory, int quantity, double price, double total,
            double discountUsedOnOrder, double totalDue,
            double availableDiscount, double currentLoyalty) {

        for (Customer c : this.customerManager.getAllCustomers()) {
            if (c.getCustomerID() == customerID) {
                for (Order o : c.getOrders()) {
                    if (o.getOrderID() == orderID) {
                        o.addProduct(this.inventory.get(itemID), quantity,
                                price);
                        return;
                    }
                }
                Order order = new Order(c, orderID, paid, orderDate,
                        pickupDate, discountUsedOnOrder).addProduct(
                        this.inventory.get(itemID), quantity, price);
                c.addOrder(order);
                this.orderManager.add(order);
                return;
            }
        }
        Customer customer = new Customer(customerID, lastName, address, city,
                state, zipCode, (currentLoyalty > 0) || (availableDiscount > 0)
                        || (discountUsedOnOrder > 0), currentLoyalty,
                availableDiscount, new ArrayList<Order>());
        this.customerManager.add(customer);
        Order order = new Order(customer, orderID, paid, orderDate, pickupDate,
                discountUsedOnOrder).addProduct(inventory.get(itemID),
                quantity, price);
        customer.getOrders().add(order);
        this.orderManager.add(order);
    }

    /**
     * EFFECT: To export the current inventory to the file
     */
    public void exportInventory() {
        try {
            PrintStream output = new PrintStream(
                    new File(inventoryOutputFile));
            output.println("BakeryItemID\tBakeryItemName\tCategory\tPrice");
            for (Product p : this.inventory.getAllProducts()) {
                output.print(p.getItemID() + "\t");
                output.print(p.getItemName() + "\t");
                output.print(p.getCategory() + "\t");
                output.print(p.getPrice() + "\t");
                output.println();
            }
            output.close();
        }
        catch (Exception e) {
            System.out.println("The following error occured"
                    + " during exporting inventory:\n" + e.toString());
        }
    }

    /**
     * EFFECT: To export the current orders to the file
     */
    public void exportOrders() {
        try {
            PrintStream output = new PrintStream(new File(ordersOutputFile));
            output.println(
                    "CustomerID\tLastName\tAddress\tCity\tState\tZipCode"
                    + "\tOrderID\tPaid?\tOrderDate\tPickupDate\tBakeryItemID"
                    + "\tBakeryItemName\tBakeryItemCategory\tQuantity\tPrice"
                    + "\tTotal\tDiscountUsedOnOrder\tTotalDue\t"
                    + "AvailableDiscount\tCurrentLoyalty");
            for (Order order : this.orderManager.getAllOrders()) {
                for (Order.Item item : order.getItems()) {
                    output.print(order.getCustomer().getCustomerID() + "\t");
                    output.print(order.getCustomer().getLastName() + "\t");
                    output.print(order.getCustomer().getAddress() + "\t");
                    output.print(order.getCustomer().getCity() + "\t");
                    output.print(order.getCustomer().getState() + "\t");
                    output.print(order.getCustomer().getZipCode() + "\t");
                    output.print(order.getOrderID() + "\t");
                    output.print(order.isPaid() ? "Yes\t" : "No\t");
                    output.print(order.getOrderDate() + "\t");
                    output.print(order.getPickDate() + "\t");
                    output.print(item.getProduct().getItemID() + "\t");
                    output.print(item.getProduct().getItemName() + "\t");
                    output.print(item.getProduct().getCategory() + "\t");
                    output.print(item.getQuantity() + "\t");
                    output.print(item.getPrice() + "\t");
                    output.print(order.getTotalPrice() + "\t");
                    output.print(order.getDiscountUsedOnOrder() + "\t");
                    output.print(order.getTotalDue() + "\t");
                    output.print(order.getCustomer().getAvailableDiscount()
                            + "\t");
                    output.print(order.getCustomer().getCurrentLoyalty());
                    output.println();
                }
            }
            output.close();
        }
        catch (Exception e) {
            System.out.println("The following error happened"
                    + " during exporting inventory:\n" + e.toString());
        }
    }

    /**
     * EFFECT: To export the current orders to the JTable
     * 
     * @return a 2D JTable array
     */
    public List<List<Object>> exportOrdersToJTable() {
        List<List<Object>> table = new ArrayList<List<Object>>();
        for (Order order : this.orderManager.getAllOrders()) {
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

    /**
     * EFFECT: To export the current inventory to JTable
     * 
     * @return 2D List for JTables
     */
    public List<List<Object>> exportInventoryToJTable() {
        List<List<Object>> table = new ArrayList<List<Object>>();

        for (Product p : this.inventory.getAllProducts()) {
            List<Object> row = new ArrayList<Object>();
            row.add(p.getItemID());
            row.add(p.getItemName());
            row.add(p.getCategory());
            row.add(p.getPrice());
            table.add(row);
        }
        return table;
    }

    /**
     * To add or edit a customer to this bakery
     * 
     * @param customerID
     *            the customerID of the customer
     * @param lastName
     *            the last name of the customer
     * @param address
     *            the address of the customer
     * @param city
     *            the city where the customer lives in
     * @param state
     *            the state where the customer lives in
     * @param zipCode
     *            the zip code
     * @param loyaltyCard
     *            if the customer has loyalty card
     * @param accumulatedConsumption
     *            the current loyalty
     * @param availableDiscount
     *            the discount that the cusomer may use
     */
    public void updateCustomer(int customerID, String lastName, String address,
            String city, String state, int zipCode, boolean loyaltyCard,
            double accumulatedConsumption, double availableDiscount) {
        if (this.customerManager.contains(customerID)) {
            Customer customer = this.customerManager.get(customerID);

            customer.setLastName(lastName);
            customer.setAddress(address);
            customer.setCity(city);
            customer.setState(state);
            customer.setZipCode(zipCode);
            customer.setLoyaltyCard(loyaltyCard);
            customer.setCurrentLoyalty(accumulatedConsumption);
            customer.setAvailableDiscount(availableDiscount);
        }
        else {
            this.customerManager.add(new Customer(customerID, lastName,
                    address, city, state, zipCode, loyaltyCard,
                    accumulatedConsumption, availableDiscount,
                    new ArrayList<Order>()));
        }

    }

    /**
     * To add or edit a product in the inventory
     * 
     * @param itemID
     *            the item ID of the product
     * @param itemName
     *            the product name
     * @param category
     *            the category of the product
     * @param price
     *            the price of the product. the changing of price does not
     *            affect old orders
     */
    public void updateInventory(int itemID, String itemName, String category,
            double price) {
        if (this.inventory.contains(itemID)) {
            Product product = this.inventory.get(itemID);

            product.setItemName(itemName);
            product.setCategory(category);
            product.setPrice(price);
        }
        else {
            this.inventory.add(new Product(itemID, itemName, category, price));
        }
    }

    /**
     * To export the customers to JTable so that GUI can take in
     * 
     * @return a 2 dimensional ArrayList as JTable needs
     */
    public List<List<Object>> exportCustomersToJTable() {
        List<List<Object>> table = new ArrayList<List<Object>>();
        for (Customer customer : this.customerManager.getAllCustomers()) {
            List<Object> row = new ArrayList<Object>();

            row.add(customer.getCustomerID());
            row.add(customer.getLastName());
            row.add(customer.getAddress());
            row.add(customer.getCity());
            row.add(customer.getState());
            row.add(customer.getZipCode());
            row.add(customer.hasLoyaltyCard() ? "Yes" : "No");
            row.add(customer.getAvailableDiscount());
            row.add(customer.getCurrentLoyalty());

            table.add(row);
        }
        return table;
    }

    /**
     * To get the customer manager of this bakery
     * 
     * @return the customer manager
     */
    public CustomerManager getCustomerManager() {
        return this.customerManager;
    }

    /**
     * To get the order manager of this bakery
     * 
     * @return the order manager
     */
    public OrderManager getOrderManager() {
        return this.orderManager;
    }

    /**
     * To get the order manager of this bakery
     * 
     * @return the order manager
     */
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * To process order updating from the user interface
     * 
     * @param customerID
     *            the customer ID of the order
     * @param orderID
     *            the order ID of the order
     * @param paid
     *            if the order has been paid
     * @param orderDate
     *            the order date of the order
     * @param pickupDate
     *            the pick up date of the order
     * @param discountUsedOnOrder
     *            the discountUsed on the order
     * @param items
     *            the items that user wants to add
     */
    public void userAddOrder(int customerID, int orderID, boolean paid,
            String orderDate, String pickupDate, double discountUsedOnOrder,
            List<List<Object>> items) {
        Customer customer = this.customerManager.get(customerID);

        if (this.orderManager.contains(orderID)) {
            // returns previous discount
            Order previous = this.orderManager.get(orderID);
            customer.setAvailableDiscount(customer.getAvailableDiscount()
                    + previous.getDiscountUsedOnOrder());
            customer.setCurrentLoyalty(customer.getCurrentLoyalty()
                    - previous.getTotalDue());
            while (customer.getCurrentLoyalty() < 0) {
                customer.setAvailableDiscount(
                        customer.getAvailableDiscount() - 10);
                customer.setCurrentLoyalty(
                        customer.getAvailableDiscount() + 100);
            }
        }

        // discount used on order must less or equal to available discount
        if (discountUsedOnOrder > customer.getAvailableDiscount()) {
            discountUsedOnOrder = customer.getAvailableDiscount();
        }
        Order order = new Order(customer, orderID, paid, orderDate, pickupDate,
                discountUsedOnOrder);

        for (List<Object> row : items) {
            if (row == null) {
                continue; // ignore illegal data
            }

            int itemID = Integer.valueOf(row.get(0).toString());
            int quantity = Integer.valueOf(row.get(1).toString());
            Product product = this.inventory.get(itemID);
            order.addProduct(product, quantity);

        }
        customer.addOrder(order);

        customer.setAvailableDiscount(customer.getAvailableDiscount()
                - order.getDiscountUsedOnOrder());
        if (customer.hasLoyaltyCard()) {
            customer.setCurrentLoyalty(customer.getCurrentLoyalty()
                    + order.getTotalDue());
            if (customer.getCurrentLoyalty() >= 100) {
                customer.setAvailableDiscount(customer.getAvailableDiscount()
                        + (int) (customer.getCurrentLoyalty() / 100) * 10);
                customer.setCurrentLoyalty(customer.getCurrentLoyalty() % 100);

            }
        }
        this.orderManager.add(order);
    }

    /**
     * To get all orders of a specific customer for JTable
     * 
     * @param customerID the customerID of the specific customer
     *            the customer ID of the specific customer
     * @return a JTable 2D list
     */
    public List<List<Object>> viewOrdersOfSpecificCustomerInJTable(
            int customerID) {
        return this.orderManager
                .getOrdersExpandedForJTable(new OrderOfSpecificCustomerFilter(
                        customerID));
    }

    /**
     * To get all orders placed on a specific date for JTable
     * 
     * @param orderDate
     *            the data when the order is placed.
     * @return a JTable 2D list
     */
    public List<List<Object>> viewOrdersPlacedOnSpecificDateInJTable(
            String orderDate) {
        return this.orderManager
                .getOrdersExpandedForJTable(new OrderDateFilter(orderDate));
    }

    /**
     * To get all orders placed on a specific date for JTable
     * 
     * @param pickupDate
     *            the date when the order is delivered.
     * @return a JTable 2D list
     */
    public List<List<Object>> viewOrdersDeliveredOnSpecificDateInJTable(
            String pickupDate) {
        return this.orderManager
                .getOrdersExpandedForJTable(new OrderPickupDateFilter(
                        pickupDate));
    }

    /**
     * To get all orders containing a specific product for JTable
     * 
     * @param productID
     *            the product ID of the specific product that the orders 
     *                  must have. 
     * @return a JTable 2D list
     */
    public List<List<Object>> viewOrdersContainingSpecificProductInJTable(
            int productID) {
        return this.orderManager
                .getOrdersExpandedForJTable(
                        new OrderContainingSpecificProductFilter(productID));
    }

    /**
     * To get all unpaid orders for JTable
     * @return a JTable 2D list
     */
    public List<List<Object>> viewUnpaidOrdersInJTable() {
        return this.orderManager
                .getOrdersExpandedForJTable(new UnpaidOrderFilter());
    }

    /**
     * To print the receipt of the given order
     * @param orderID the order ID of the order of which user wants to print
     *          the receipt
     * @return the receipt string
     */
    public String printReceipt(int orderID) {
        Order order = this.orderManager.get(orderID);
        String receipt = "<html>"
                + "<center><b>Bakery Receipt</b></center><br />" + "Customer: "
                + order.getCustomer().getLastName() + "<br />" + "Date: "
                + order.getOrderDate() + "<hr /><br /><ul>";
        for (Order.Item i : order.getItems()) {
            receipt += "<li>" + i.getProduct().getItemName() + "<br /><small>$"
                    + i.getPrice() + "*" + i.getQuantity() + "="
                    + i.getTotalPrice() + "</small></li>";
        }

        receipt += "</ul>Total Due: " + order.getTotalDue() + "<br />";
        receipt += "<small> + inital " + order.getTotalPrice() + "<br />";
        receipt += " - discount " + order.getDiscountUsedOnOrder()
                + "</small><br />";
        receipt += "</html>";
        return receipt;
    }
}
