package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author ZHEN Wei / ZhenHuan Wu
 * @version 2014.6.18
 * 
 */
public class NewItem extends JFrame {

    /** element */

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
                    NewItem frame = new NewItem();
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
    public NewItem() {
        final TableModel myTableModel1 = ItemList.myTableModel1;

        setTitle("New/Edit Item");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        final JTextField id = new JTextField();
        id.setBounds(91, 22, 85, 21);
        contentPane.add(id);
        id.setColumns(10);

        final JTextField itemname = new JTextField();
        itemname.setBounds(96, 98, 80, 21);
        contentPane.add(itemname);
        itemname.setColumns(10);

        final JTextField category = new JTextField();
        category.setBounds(292, 22, 85, 21);
        contentPane.add(category);
        category.setColumns(10);

        final JTextField price = new JTextField();
        price.setBounds(292, 98, 85, 21);
        contentPane.add(price);
        price.setColumns(10);

        final JLabel lblId = new JLabel("id");
        lblId.setBounds(10, 25, 54, 15);
        contentPane.add(lblId);

        final JLabel lblItemname = new JLabel("ItemName");
        lblItemname.setBounds(10, 101, 54, 15);
        contentPane.add(lblItemname);

        final JLabel lblItem = new JLabel("Category");
        lblItem.setBounds(223, 25, 54, 15);
        contentPane.add(lblItem);

        final JLabel lblPrice = new JLabel("price");
        lblPrice.setBounds(223, 101, 54, 15);
        contentPane.add(lblPrice);

        JButton btnAdd = new JButton("add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isint(id.getText()) && isDouble(price.getText())) {
                    OrderListModel.bakery.updateInventory(
                            Integer.parseInt(id.getText()),
                            itemname.getText(), category.getText(),
                            Double.parseDouble(price.getText()));
                    ItemListModel.setFile();
                    ((AbstractTableModel) myTableModel1)
                    .fireTableDataChanged();
                    setVisible(false);
                } 
                else {
                    new CheckType().setVisible(true);
                }
            }
        });

        btnAdd.setBounds(83, 187, 93, 23);
        contentPane.add(btnAdd);

        JButton btnCancle = new JButton("back");
        btnCancle.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        btnCancle.setBounds(251, 187, 93, 23);
        contentPane.add(btnCancle);

    }
}
