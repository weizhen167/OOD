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

/**
 * 
 * @author ZHEN Wei / ZhenHuan Wu
 * @version 2014.6.18
 * 
 */
public class OrderFilter extends JFrame {

    /** element */
    public static TableModel myTableModel1 = new OrderFilterModel();

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
                    OrderFilter frame = new OrderFilter();
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
    public OrderFilter() {
        setTitle("Order Filter");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 1300, 700);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTable table = new JTable(myTableModel1);
        table.setPreferredScrollableViewportSize(new Dimension(600, 100));
        table.setRowHeight(30);
        table.setRowMargin(5);
        table.setRowSelectionAllowed(true);
        table.setSelectionBackground(Color.ORANGE);
        table.setSelectionForeground(Color.BLACK);
        table.setGridColor(Color.black);
        table.selectAll();
        table.clearSelection();
        table.setDragEnabled(true);
        table.setShowGrid(false);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setBackground(Color.white);

        table.setBounds(10, 10, 1264, 641);
        JScrollPane pane2 = new JScrollPane(table);
        pane2.setBounds(10, 10, 1264, 641);
        contentPane.add(pane2);
    }
}
