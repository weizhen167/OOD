package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 * 
 * @author ZHEN Wei / ZhenHuan Wu
 * @version 2014.6.18
 * 
 */
public class NewOrder extends JFrame {

    /** element */
    static JTextField textField1 = new JTextField();
    /** element */
    static JTextField txtDdmmdd = new JTextField();
    /** element */
    static JTextField txtDdmmyy = new JTextField();
    /** element */
    static JTextField textField7 = new JTextField();
    /** element */
    public static JLabel lblNewLabel1 = new JLabel("\"\"");
    /** element */
    public static JLabel lblNewLabel2 = new JLabel("0.0");
    /** element */
    public static JLabel lblNewLabel3 = new JLabel("\"\"");
    /** element */
    public static int num = 0;
    /** element */
    static JCheckBox checkBox = new JCheckBox("");
    /** element */
    public static TableModel myTableModel1 = new NewOrderTableModel();

    /**
     * 
     * @param s
     *            String
     * @return boolean
     */
    public boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } 
        catch (NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    /**
     * 
     * @param s
     *            String
     * @return boolean
     */
    public boolean isint(String s) {
        try {
            Integer.parseInt(s);
        } 
        catch (NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

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
                    NewOrder frame = new NewOrder();
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
    public NewOrder() {
        setTitle("New Order");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 608, 467);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(176, 196, 222));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Confirm");
        btnNewButton.setBackground(new Color(51, 204, 102));
        btnNewButton.setFont(new Font("Dotum", Font.BOLD | Font.ITALIC, 15));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent caonima) {
                try {
                    int size = OrderList.myTableModel12.getRowCount();
                    OrderListModel.bakery.userAddOrder(num,
                            Integer.parseInt(textField1.getText()),
                            checkBox.isSelected(), txtDdmmdd.getText(),
                            txtDdmmyy.getText(),
                            Double.parseDouble(textField7.getText()),
                            NewOrderTableModel.list);
                    OrderListModel.setFile();
                    ((AbstractTableModel) OrderList.myTableModel12)
                            .fireTableDataChanged();
                    ((AbstractTableModel) CustomerList.myTableModel1)
                            .fireTableDataChanged();
                    try {
                        OrderList.orders.setRowSelectionInterval(size,
                                OrderList.myTableModel12.getRowCount() - 1);
                    } 
                    catch (Exception e) {
                        // Does nothing.
                    }
                    Receipt.lblNewLabel.setText(OrderListModel
                            .bakery.printReceipt(Integer
                                    .parseInt(textField1.getText())));
                    setVisible(false);
                    new OrderList().setVisible(true);
                    new Receipt().setVisible(true);
                } 
                catch (Exception e) {
                    new CheckType().setVisible(true);
                }
            }
        });
        btnNewButton.setBounds(111, 349, 108, 42);
        contentPane.add(btnNewButton);

        JButton btnNewButton1 = new JButton("Back");
        btnNewButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnNewButton1.setBackground(new Color(255, 102, 102));
        btnNewButton1.setFont(new Font("Dotum", Font.BOLD | Font.ITALIC, 15));
        btnNewButton1.setBounds(359, 349, 108, 42);
        contentPane.add(btnNewButton1);

        textField1.setBounds(125, 75, 70, 20);
        contentPane.add(textField1);
        textField1.setColumns(10);

        txtDdmmdd.setText("dd/mm/yy");
        txtDdmmdd.setBounds(125, 110, 70, 20);
        contentPane.add(txtDdmmdd);
        txtDdmmdd.setColumns(10);

        txtDdmmyy.setText("dd/mm/yy");
        txtDdmmyy.setBounds(125, 145, 70, 20);
        contentPane.add(txtDdmmyy);
        txtDdmmyy.setColumns(10);

        textField7.setText("0.0");
        textField7.setBounds(125, 180, 70, 20);
        contentPane.add(textField7);
        textField7.setColumns(10);

        JLabel lblOrderId = new JLabel("CusTomer ID:");
        lblOrderId.setBackground(new Color(102, 153, 204));
        lblOrderId.setBounds(38, 28, 90, 15);
        contentPane.add(lblOrderId);

        JLabel lblNewLabel = new JLabel("Order ID");
        lblNewLabel.setBackground(Color.LIGHT_GRAY);
        lblNewLabel.setBounds(38, 75, 72, 20);
        contentPane.add(lblNewLabel);

        JLabel lblPaid = new JLabel("Paid?");
        lblPaid.setFont(new Font("Calibri", Font.BOLD, 17));
        lblPaid.setBounds(38, 281, 72, 23);
        contentPane.add(lblPaid);

        JLabel lblOrderDate = new JLabel("Order Date");
        lblOrderDate.setBounds(38, 110, 72, 20);
        contentPane.add(lblOrderDate);

        JLabel lblDeveliverDaate = new JLabel("PickUp Date");
        lblDeveliverDaate.setBounds(38, 145, 72, 20);
        contentPane.add(lblDeveliverDaate);

        JLabel lblDiscount = new JLabel("Discount");
        lblDiscount.setBounds(38, 180, 72, 20);
        contentPane.add(lblDiscount);

        JLabel lblAvaliableDiscoutIs = new JLabel("Avaliable discout is:");
        lblAvaliableDiscoutIs.setBounds(24, 222, 131, 20);
        contentPane.add(lblAvaliableDiscoutIs);

        checkBox.setBounds(107, 281, 21, 23);
        contentPane.add(checkBox);
        lblNewLabel1.setForeground(new Color(255, 69, 0));
        lblNewLabel1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));

        lblNewLabel1.setBounds(125, 27, 108, 18);
        contentPane.add(lblNewLabel1);
        lblNewLabel2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel2.setForeground(new Color(0, 128, 0));

        lblNewLabel2.setBounds(165, 223, 108, 20);
        contentPane.add(lblNewLabel2);

        JTable table = new JTable(myTableModel1);
        table.setBounds(301, 83, 206, 134);

        JScrollPane pane2 = new JScrollPane(table);
        pane2.setBounds(316, 106, 211, 208);
        contentPane.add(pane2);

        JButton btnNewButton2 = new JButton("Add New Item");
        btnNewButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer[] obj = { null, null };
                ((NewOrderTableModel) myTableModel1).addrow(obj);
            }
        });
        btnNewButton2.setBounds(316, 72, 211, 23);
        contentPane.add(btnNewButton2);

        JLabel lblCustomerName = new JLabel("Customer Last Name:");
        lblCustomerName.setBounds(254, 28, 131, 15);
        contentPane.add(lblCustomerName);

        lblNewLabel3.setForeground(new Color(255, 69, 0));
        lblNewLabel3.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel3.setBounds(383, 29, 118, 15);
        contentPane.add(lblNewLabel3);
    }
}
