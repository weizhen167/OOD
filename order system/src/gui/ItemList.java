package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author ZHEN Wei / ZhenHuan Wu
 * @version 2014.6.18
 * 
 */
public class ItemList extends JFrame {

    /** element */
    public static TableModel myTableModel1 = new ItemListModel();

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
                    ItemList frame = new ItemList();
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
    public ItemList() {
        setTitle("Item Manger");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 1300, 700);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JTable items = new JTable(myTableModel1);
        items.setPreferredScrollableViewportSize(new Dimension(600, 100));
        items.setRowHeight(30);
        items.setRowMargin(5);
        items.setRowSelectionAllowed(true);
        items.setSelectionBackground(Color.ORANGE);
        items.setSelectionForeground(Color.BLACK);
        items.setGridColor(Color.black);
        items.selectAll();
        items.clearSelection();
        items.setDragEnabled(true);
        items.setShowGrid(false);
        items.setShowHorizontalLines(true);
        items.setShowVerticalLines(true);
        items.setBackground(Color.white);

        JScrollPane pane2 = new JScrollPane(items);
        pane2.setBounds(10, 43, 1264, 608);
        contentPane.setLayout(null);
        contentPane.add(pane2);

        JButton btnAddNewRow = new JButton("Add/Edit Item");
        btnAddNewRow.setBounds(56, 10, 155, 23);
        contentPane.add(btnAddNewRow);
        btnAddNewRow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent caonima) {
                new NewItem().setVisible(true);
            }
        });

    }
}
