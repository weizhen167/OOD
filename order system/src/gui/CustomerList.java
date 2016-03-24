package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JTable;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ZHEN Wei / ZhenHuan Wu
 * @version 2014.6.18
 * 
 */
public class CustomerList extends JFrame {

    /** element */
    public static TableModel myTableModel1 = new CustomerListModel();
    /** element */
    static Point mousepoint;

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
                    CustomerList frame = new CustomerList();
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
    public CustomerList() {
        setTitle("Customer Manager");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 1300, 700);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        final JTable customer = new JTable(myTableModel1);
        customer.setBounds(10, 53, 1264, 598);
        contentPane.add(customer);
        customer.setPreferredScrollableViewportSize(new Dimension(600, 100));
        customer.setRowHeight(30);
        customer.setRowMargin(5);
        customer.setRowSelectionAllowed(true);
        customer.setSelectionBackground(Color.ORANGE);
        customer.setSelectionForeground(Color.BLACK);
        customer.setGridColor(Color.black);
        customer.setDragEnabled(true);
        customer.setShowGrid(false);
        customer.setShowHorizontalLines(true);
        customer.setShowVerticalLines(true);
        customer.setBackground(Color.white);

        customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                mousepoint = e.getPoint();
                customer.setRowSelectionInterval(
                        customer.rowAtPoint(mousepoint),
                        customer.rowAtPoint(mousepoint));
            }
        });

        JScrollPane pane2 = new JScrollPane(customer);

        pane2.setBounds(10, 43, 1264, 608);
        contentPane.setLayout(null);
        contentPane.add(pane2);

        JButton btnAddNewRow = new JButton("Add/Edit Customer");
        btnAddNewRow.setBounds(52, 10, 155, 23);
        contentPane.add(btnAddNewRow);

        JButton btnNewButton1 = new JButton("New Order");
        btnNewButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    NewOrder.lblNewLabel1.setText(myTableModel1.getValueAt(
                            customer.getSelectedRow(), 0).toString());
                    NewOrder.lblNewLabel3.setText(myTableModel1.getValueAt(
                            customer.getSelectedRow(), 1).toString());
                    NewOrder.lblNewLabel2.setText(myTableModel1.getValueAt(
                            customer.getSelectedRow(), 7).toString());
                    NewOrder.num = Integer.parseInt(myTableModel1.getValueAt(
                            customer.getSelectedRow(), 0).toString());
                    new NewOrder().setVisible(true);
                } 
                catch (Exception i) {
                    new NoSelectCustomer().setVisible(true);
                }
            }
        });
        btnNewButton1.setBounds(246, 10, 141, 23);
        contentPane.add(btnNewButton1);

        JButton btnNewButton = new JButton("Clear Selection");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NewCustomer.avaidiscount.setText("");
                NewCustomer.state.setText("");
                NewCustomer.currentloy.setText("");
                NewCustomer.zipcode.setText("");
                NewCustomer.customerid.setText("");
                NewCustomer.lastname.setText("");
                NewCustomer.address.setText("");
                NewCustomer.city.setText("");
                NewCustomer.chckbxHaveLoyaltyCard.setSelected(false);
                NewOrderTableModel.list = new ArrayList<List<Object>>();
                customer.clearSelection();
                CustomerListModel.setFile();
            }
        });
        btnNewButton.setBounds(426, 10, 155, 23);
        contentPane.add(btnNewButton);
        btnAddNewRow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent caonima) {
                try {

                    NewCustomer.avaidiscount.setText(myTableModel1.getValueAt(
                            customer.getSelectedRow(), 7).toString());
                    NewCustomer.state.setText(myTableModel1.getValueAt(
                            customer.getSelectedRow(), 4).toString());
                    NewCustomer.currentloy.setText(myTableModel1.getValueAt(
                            customer.getSelectedRow(), 8).toString());
                    NewCustomer.zipcode.setText(myTableModel1.getValueAt(
                            customer.getSelectedRow(), 5).toString());
                    NewCustomer.customerid.setText(myTableModel1.getValueAt(
                            customer.getSelectedRow(), 0).toString());
                    NewCustomer.lastname.setText(myTableModel1.getValueAt(
                            customer.getSelectedRow(), 1).toString());
                    NewCustomer.address.setText(myTableModel1.getValueAt(
                            customer.getSelectedRow(), 2).toString());
                    NewCustomer.city.setText(myTableModel1.getValueAt(
                            customer.getSelectedRow(), 3).toString());
                    if (myTableModel1.getValueAt(customer.getSelectedRow(), 6)
                            .toString().equals("Yes")) {
                        NewCustomer.chckbxHaveLoyaltyCard.setSelected(true);
                    }
                    new NewCustomer().setVisible(true);
                } 
                catch (Exception e) {
                    new NewCustomer().setVisible(true);
                }
            }
        });

    }
}
