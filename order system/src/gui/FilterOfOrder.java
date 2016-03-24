package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author ZHEN Wei / ZhenHuan Wu
 * @version 2014.6.18
 * 
 */
public class FilterOfOrder extends JFrame {

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
                    FilterOfOrder frame = new FilterOfOrder();
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
    public FilterOfOrder() {
        setTitle("Order Filter");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 586, 422);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(SystemColor.inactiveCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        final JTextField txtPleaseInputCustomer = new JTextField();
        txtPleaseInputCustomer.setText("Please input customer id");
        txtPleaseInputCustomer.setBounds(51, 80, 168, 21);
        contentPane.add(txtPleaseInputCustomer);
        txtPleaseInputCustomer.setColumns(10);

        final JTextField txtPleaseInputOrder = new JTextField();
        txtPleaseInputOrder.setText("Please input Order Date");
        txtPleaseInputOrder.setBounds(51, 143, 168, 21);
        contentPane.add(txtPleaseInputOrder);
        txtPleaseInputOrder.setColumns(10);

        final JTextField txtPleaseInputPickup = new JTextField();
        txtPleaseInputPickup.setText("Please input Pickup Date");
        txtPleaseInputPickup.setBounds(51, 200, 168, 21);
        contentPane.add(txtPleaseInputPickup);
        txtPleaseInputPickup.setColumns(10);

        final JTextField txtPleaseInputItem = new JTextField();
        txtPleaseInputItem.setText("Please input Item ID");
        txtPleaseInputItem.setBounds(51, 255, 168, 21);
        contentPane.add(txtPleaseInputItem);
        txtPleaseInputItem.setColumns(10);

        JButton btnNewButton = new JButton("Search By Customer ID");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent caonima) {
                try {
                    OrderFilterModel.list = OrderListModel.bakery
                            .viewOrdersOfSpecificCustomerInJTable(Integer
                                .parseInt(txtPleaseInputCustomer.getText()));
                    ((AbstractTableModel) OrderFilter.myTableModel1)
                            .fireTableDataChanged();
                    new OrderFilter().setVisible(true);
                } 
                catch (Exception e) {
                    new CheckType().setVisible(true);
                }
            }
        });
        btnNewButton.setBounds(317, 79, 168, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton1 = new JButton("Search By Pickup Date");
        btnNewButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent caonima) {
                try {
                    OrderFilterModel.list = OrderListModel
                            .bakery.viewOrdersDeliveredOnSpecificDateInJTable(
                                    txtPleaseInputPickup.getText());
                    ((AbstractTableModel) OrderFilter.myTableModel1)
                            .fireTableDataChanged();
                    new OrderFilter().setVisible(true);
                } 
                catch (Exception e) {
                    new CheckType().setVisible(true);
                }
            }
        });
        btnNewButton1.setBounds(317, 199, 168, 23);
        contentPane.add(btnNewButton1);

        JButton btnNewButton2 = new JButton("Search By Order Date");
        btnNewButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent caonima) {
                try {
                    OrderFilterModel.list = OrderListModel.bakery
                            .viewOrdersPlacedOnSpecificDateInJTable(
                                    txtPleaseInputOrder.getText());
                    ((AbstractTableModel) OrderFilter.myTableModel1)
                            .fireTableDataChanged();
                    new OrderFilter().setVisible(true);
                } 
                catch (Exception e) {
                    new CheckType().setVisible(true);
                }
            }
        });
        btnNewButton2.setBounds(317, 142, 168, 23);
        contentPane.add(btnNewButton2);

        JButton btnNewButton3 = new JButton("Search By Item ID");
        btnNewButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent caonima) {
                try {
                    OrderFilterModel.list = OrderListModel.bakery
                            .viewOrdersContainingSpecificProductInJTable(
                                    Integer.parseInt(
                                            txtPleaseInputItem.getText()));
                    ((AbstractTableModel) OrderFilter.myTableModel1)
                            .fireTableDataChanged();
                    new OrderFilter().setVisible(true);
                } 
                catch (Exception e) {
                    new CheckType().setVisible(true);
                }
            }
        });
        btnNewButton3.setBounds(317, 254, 168, 23);
        contentPane.add(btnNewButton3);

        JLabel lblNewLabel = new JLabel("Order Filter");
        lblNewLabel.setBackground(SystemColor.inactiveCaption);
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 39));
        lblNewLabel.setForeground(Color.ORANGE);
        lblNewLabel.setBounds(161, 10, 295, 49);
        contentPane.add(lblNewLabel);

        JButton btnNewButton4 = new JButton("Show Me All Unpaid Orders");
        btnNewButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OrderFilterModel.list = OrderListModel.bakery
                        .viewUnpaidOrdersInJTable();
                ((AbstractTableModel) OrderFilter.myTableModel1)
                        .fireTableDataChanged();
                new OrderFilter().setVisible(true);
            }
        });
        btnNewButton4.setBounds(142, 306, 256, 23);
        contentPane.add(btnNewButton4);
    }
}
