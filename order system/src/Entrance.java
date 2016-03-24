

import gui.OrderList;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author ZHEN Wei / ZhenHuan Wu
 * @version 2014.6.18
 * 
 */
public class Entrance extends JFrame {

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
                    Entrance frame = new Entrance();
                    frame.setVisible(true);
                } 
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ImageIcon loadImg(String imgUrl) {
        ImageIcon icon = new ImageIcon(getClass().getResource(imgUrl));
        // ImageIcon icon = new ImageIcon(imgUrl);
        return icon;
    }
    
    /**
     * Create the frame.
     */
    public Entrance() {
        setTitle("WelCome");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 501, 359);
        JPanel contentPane = new JPanel();
        ImageIcon p1;
        p1 = loadImg("/Hello-Kitty-hello-kitty-181853_500_375.gif");
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Log In");
        btnNewButton.setBackground(Color.PINK);
        btnNewButton.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent caonima) {
                new OrderList().setVisible(true);
                setVisible(false);
            }
        });
        btnNewButton.setBounds(138, 229, 216, 39);

        JTextField txtAdmin = new JTextField();
        txtAdmin.setFont(new Font("Dotum", Font.ITALIC, 16));
        txtAdmin.setText("admin");
        txtAdmin.setBounds(252, 106, 197, 31);

        txtAdmin.setColumns(10);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setText("jiexikanimabi");
        passwordField.setBounds(252, 162, 197, 31);

        JLabel lblNewLabel = new JLabel("UserName:");
        lblNewLabel.setOpaque(true);
        lblNewLabel.setBackground(Color.WHITE);
        lblNewLabel.setForeground(Color.PINK);
        lblNewLabel.setFont(new Font("Dotum", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel.setBounds(74, 105, 122, 31);

        JLabel lblNewLabel1 = new JLabel("Password:");
        lblNewLabel1.setOpaque(true);
        lblNewLabel1.setBackground(Color.WHITE);
        lblNewLabel1.setForeground(Color.PINK);
        lblNewLabel1.setFont(new Font("Dotum", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel1.setBounds(74, 160, 122, 31);

        JLabel lblNewLabel2 = new JLabel("Welcome To the Bakery System");
        lblNewLabel2.setOpaque(true);
        lblNewLabel2.setBackground(Color.WHITE);
        lblNewLabel2.setForeground(Color.PINK);
        lblNewLabel2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel2.setBounds(124, 10, 265, 39);

        JLabel lblNewLabel3 = new JLabel(p1);
        lblNewLabel3.setOpaque(false);
        lblNewLabel3.setBounds(10, 10, 464, 300);
        contentPane.add(btnNewButton);
        lblNewLabel3.add(txtAdmin);
        lblNewLabel3.add(passwordField);
        lblNewLabel3.add(lblNewLabel);
        lblNewLabel3.add(lblNewLabel1);
        lblNewLabel3.add(lblNewLabel2);
        contentPane.add(lblNewLabel3);
    }
}
