package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

/**
 * 
 * @author ZHEN Wei / ZhenHuan Wu
 * @version 2014.6.18
 * 
 */
public class Receipt extends JFrame {

    /** element */
    static JLabel lblNewLabel = new JLabel("New label");

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
                    Receipt frame = new Receipt();
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
    public Receipt() {
        JPanel contentPane = new JPanel();
        setBackground(Color.WHITE);
        setAlwaysOnTop(true);
        setTitle("Receipt");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 271, 471);
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setBackground(new Color(255, 250, 250));

        lblNewLabel.setBounds(10, 10, 235, 412);
        contentPane.add(lblNewLabel);
    }
}
