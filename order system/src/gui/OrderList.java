package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import java.awt.SystemColor;

/**
 * 
 * @author ZHEN Wei / ZhenHuan Wu
 * @version 2014.6.18
 * 
 */
public class OrderList extends JFrame {

    /** element */
    static JTable orders;
    /** element */
    public static TableModel myTableModel12 = new OrderListModel();

    /**
     * Launch the application.
     * 
     * @param args
     *            String[]
     */
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    OrderList frame = new OrderList();
                    frame.setVisible(true);
                } 
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public OrderList() {
        setBackground(new Color(255, 140, 0));
        setTitle("Order List");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 1300, 700);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 191, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        orders = new JTable(myTableModel12);
        orders.setPreferredScrollableViewportSize(new Dimension(600, 100));
        orders.setRowHeight(30);
        orders.setRowMargin(5);
        orders.setRowSelectionAllowed(true);
        orders.setSelectionBackground(Color.ORANGE);
        orders.setSelectionForeground(Color.BLACK);
        orders.setGridColor(Color.black);
        orders.setShowGrid(true);
        orders.setShowHorizontalLines(true);
        orders.setShowVerticalLines(true);

        /*
         * DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
         * public Component getTableCellRendererComponent(JTable table, Object
         * value, boolean isSelected, boolean hasFocus, int row, int column) {
         * Component cell = super.getTableCellRendererComponent(table, value,
         * isSelected, hasFocus, row, column);
         * cell.setBackground(Color.LIGHTGRAY); return cell; } };
         * 
         * 
         * orders.getColumn("BakeryItemName").setCellRenderer(tcr);
         * orders.getColumn("LastName").setCellRenderer(tcr);
         * orders.getColumn("Address").setCellRenderer(tcr);
         * orders.getColumn("City").setCellRenderer(tcr);
         * orders.getColumn("State").setCellRenderer(tcr);
         * orders.getColumn("ZipCode").setCellRenderer(tcr);
         * orders.getColumn("BakeryItemCategory").setCellRenderer(tcr);
         * orders.getColumn("Price").setCellRenderer(tcr);
         * orders.getColumn("Total").setCellRenderer(tcr);
         * orders.getColumn("TotalDue").setCellRenderer(tcr);
         * orders.getColumn("AvailableDiscount").setCellRenderer(tcr);
         * orders.getColumn("CurrentLoyalty").setCellRenderer(tcr);
         */

        orders.setBackground(Color.white);
        JScrollPane pane2 = new JScrollPane(orders);
        pane2.setBounds(10, 84, 1264, 567);

        JButton btnAddNewRow = new JButton("Order Filter");
        btnAddNewRow.setBounds(208, 10, 119, 64);
        btnAddNewRow.setHorizontalAlignment(SwingConstants.LEFT);
        btnAddNewRow.setBackground(new Color(255, 140, 0));
        btnAddNewRow.setForeground(SystemColor.desktop);
        btnAddNewRow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent caonima) {
                new FilterOfOrder().setVisible(true);
            }
        });
        contentPane.setLayout(null);
        contentPane.add(btnAddNewRow);

        JButton button = new JButton("New button");
        pane2.setColumnHeaderView(button);

        JLabel label = new JLabel("");
        label.setBounds(338, 21, 0, 0);
        contentPane.add(label);

        JButton btnNewButton = new JButton("<html>" + "importData" + "<br>"
                + "(please click just one time)" + "</html>");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(144, 238, 144));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent caonima) {
                OrderListModel.importFile();
                OrderListModel.setFile();
                ((AbstractTableModel) myTableModel12).fireTableDataChanged();
            }
        });
        btnNewButton.setBounds(31, 10, 151, 64);
        contentPane.add(btnNewButton);

        JLabel label1 = new JLabel("");
        label1.setBounds(461, 21, 0, 0);
        contentPane.add(label1);

        JButton btnNewButton2 = new JButton("<html>" + "Export Oders &&"
                + "<br>" + "ItemList to File" + "</html>");
        btnNewButton2.setForeground(new Color(255, 250, 250));
        btnNewButton2.setBackground(new Color(189, 183, 107));
        btnNewButton2.setBounds(1091, 9, 141, 57);
        btnNewButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent caonima) {
                OrderListModel.bakery.exportInventory();
                OrderListModel.bakery.exportOrders();
            }
        });
        contentPane.add(btnNewButton2);

        JLabel label2 = new JLabel("");
        label2.setBounds(692, 21, 0, 0);
        contentPane.add(label2);

        contentPane.add(pane2);

        JButton btnNewButton3 = new JButton("Customer Manager");
        btnNewButton3.setBackground(new Color(255, 99, 71));
        btnNewButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CustomerListModel.setFile();
                ((AbstractTableModel) CustomerList.myTableModel1)
                        .fireTableDataChanged();
                new CustomerList().setVisible(true);
            }
        });
        btnNewButton3.setBounds(908, 43, 151, 23);
        contentPane.add(btnNewButton3);

        JButton btnNewButton4 = new JButton("Items Manager");
        btnNewButton4.setBackground(new Color(255, 99, 71));
        btnNewButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ItemListModel.setFile();
                ((AbstractTableModel) ItemList.myTableModel1)
                        .fireTableDataChanged();
                new ItemList().setVisible(true);
            }
        });
        btnNewButton4.setBounds(908, 10, 151, 23);
        contentPane.add(btnNewButton4);

        final JTextField orderid = new JTextField();
        orderid.setText("InPut Order Id To Edit");
        orderid.setBounds(374, 10, 141, 21);
        contentPane.add(orderid);
        orderid.setColumns(10);

        JButton btnEditOrder = new JButton("Edit Order");

        btnEditOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new NewOrder().setVisible(true);
                    code.Order order = OrderListModel.bakery.getOrderManager()
                            .get(Integer.valueOf(orderid.getText()));
                    NewOrder.num = order.getCustomer().getCustomerID();
                    NewOrder.lblNewLabel1.setText(new Integer(order
                            .getCustomer().getCustomerID()).toString());
                    NewOrder.lblNewLabel3.setText(order.getCustomer()
                            .getLastName());
                    NewOrder.textField1.setText(orderid.getText());
                    NewOrder.txtDdmmdd.setText(order.getPickDate());
                    NewOrder.txtDdmmyy.setText(order.getOrderDate());
                    NewOrder.textField7.setText(new Double(order
                            .getDiscountUsedOnOrder()).toString());
                    NewOrder.lblNewLabel2.setText(new Double(order
                            .getCustomer().getAvailableDiscount()).toString());
                    NewOrderTableModel.list = order.getItemsInJTable();
                    if (order.isPaid()) {
                        NewOrder.checkBox.setSelected(true);
                    }
                } 
                catch (Exception i) {
                    new NoSelectCustomer().setVisible(true);
                }
            }

        });
        btnEditOrder.setBounds(374, 31, 141, 43);
        contentPane.add(btnEditOrder);

    }
}
