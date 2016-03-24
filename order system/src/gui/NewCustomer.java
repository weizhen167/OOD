package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.JCheckBox;

/**
 * 
 * @author ZHEN Wei / ZhenHuan Wu
 * @version 2014.6.18
 * 
 */
public class NewCustomer extends JFrame {

    /** element */
    public static JTextField avaidiscount = new JTextField();
    /** element */
    public static JTextField state = new JTextField();
    /** element */
    public static JTextField currentloy = new JTextField();
    /** element */
    public static JTextField zipcode = new JTextField();
    /** element */
    public static JTextField customerid = new JTextField();
    /** element */
    public static JTextField lastname = new JTextField();
    /** element */
    public static JTextField address = new JTextField();
    /** element */
    public static JTextField city = new JTextField();
    /** element */
    public static JCheckBox chckbxHaveLoyaltyCard = new JCheckBox(
            "Have Loyalty Card");

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
                    NewCustomer frame = new NewCustomer();
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
    public NewCustomer() {
        final TableModel myTableModel1 = CustomerList.myTableModel1;
        setTitle("New/Edit Item");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 567, 446);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        customerid.setBounds(135, 22, 100, 21);
        contentPane.add(customerid);
        customerid.setColumns(10);

        lastname.setBounds(135, 98, 100, 21);
        contentPane.add(lastname);
        lastname.setColumns(10);

        address.setBounds(403, 22, 85, 21);
        contentPane.add(address);
        address.setColumns(10);

        city.setBounds(403, 98, 85, 21);
        contentPane.add(city);
        city.setColumns(10);

        JLabel lblId = new JLabel("CustomerID");
        lblId.setBounds(10, 25, 140, 15);
        contentPane.add(lblId);

        JLabel lblItemname = new JLabel("LastName");
        lblItemname.setBounds(10, 100, 140, 15);
        contentPane.add(lblItemname);

        JLabel lblItem = new JLabel("City");
        lblItem.setBounds(323, 100, 54, 15);
        contentPane.add(lblItem);

        JLabel lblPrice = new JLabel("State");
        lblPrice.setBounds(323, 175, 54, 15);
        contentPane.add(lblPrice);

        JButton btnAdd = new JButton("add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isint(customerid.getText()) && isint(zipcode.getText())
                        && isDouble(currentloy.getText())
                        && isDouble(avaidiscount.getText())) {
                    OrderListModel.bakery.updateCustomer(
                            Integer.parseInt(customerid.getText()),
                            lastname.getText(), address.getText(),
                            city.getText(), state.getText(),
                            Integer.parseInt(zipcode.getText()),
                            chckbxHaveLoyaltyCard.isSelected(),
                            Double.parseDouble(currentloy.getText()),
                            Double.parseDouble(avaidiscount.getText()));
                    CustomerListModel.setFile();
                    ((AbstractTableModel) myTableModel1)
                    .fireTableDataChanged();
                    setVisible(false);
                } 
                else {
                    new CheckType().setVisible(true);
                }
            }
        });

        btnAdd.setBounds(108, 348, 93, 23);
        contentPane.add(btnAdd);

        JButton btnCancle = new JButton("back");
        btnCancle.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        btnCancle.setBounds(351, 348, 93, 23);
        contentPane.add(btnCancle);

        avaidiscount.setBounds(135, 172, 100, 21);
        contentPane.add(avaidiscount);
        avaidiscount.setColumns(10);

        state.setBounds(403, 172, 85, 21);
        contentPane.add(state);
        state.setColumns(10);

        currentloy.setBounds(135, 248, 100, 21);
        contentPane.add(currentloy);
        currentloy.setColumns(10);

        zipcode.setBounds(403, 248, 85, 21);
        contentPane.add(zipcode);
        zipcode.setColumns(10);

        JLabel lblZipcode = new JLabel("ZipCode");
        lblZipcode.setBounds(323, 251, 54, 15);
        contentPane.add(lblZipcode);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(323, 25, 54, 15);
        contentPane.add(lblAddress);

        JLabel lblNewLabel = new JLabel("Available Discount");
        lblNewLabel.setBounds(10, 175, 140, 15);
        contentPane.add(lblNewLabel);

        JLabel currenloy = new JLabel("Current Loyalty");
        currenloy.setBounds(10, 251, 140, 15);
        contentPane.add(currenloy);

        chckbxHaveLoyaltyCard.setBounds(207, 306, 159, 23);
        contentPane.add(chckbxHaveLoyaltyCard);

    }
}
