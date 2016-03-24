package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author ZHEN Wei / ZhenHuan Wu
 * @version 2014.6.18
 * 
 */
public class NoSelectCustomer extends JFrame {

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
                    NoSelectCustomer frame = new NoSelectCustomer();
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
    public NoSelectCustomer() {
        setAlwaysOnTop(true);
        setTitle("Warring");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(350, 300, 307, 213);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel(
                "Please Select A Customer To Begin New Order");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 13));
        lblNewLabel.setBounds(10, 73, 271, 76);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel1 = new JLabel("WARRING!!");
        lblNewLabel1.setFont(new Font("Engravers MT", Font.BOLD, 15));
        lblNewLabel1.setForeground(new Color(255, 0, 0));
        lblNewLabel1.setBounds(90, 20, 148, 42);
        contentPane.add(lblNewLabel1);
    }

}
