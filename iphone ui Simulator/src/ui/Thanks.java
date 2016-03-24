package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class Thanks extends JFrame {

    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public Thanks() {
        setTitle("IS4900 Icon Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 300, 227, 250);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setForeground(Color.RED);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        this.setAlwaysOnTop(true);
        JButton btnNewButton = new JButton("Exit");
        btnNewButton.setFont(new Font("Calibri", Font.BOLD, 30));
        btnNewButton.setBackground(Color.GREEN);
        btnNewButton.setBorder(null);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
          
                System.exit(0);
            }
        });
        btnNewButton.setBounds(45, 155, 118, 46);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("Thank You!");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setBounds(35, 10, 176, 71);
        contentPane.add(lblNewLabel);
        
        JButton btnAnotherOne = new JButton("another one");
        btnAnotherOne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Welcome frame = new Welcome();
                    frame.setVisible(true);  
                    closewindow();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btnAnotherOne.setFont(new Font("Calibri", Font.BOLD, 17));
        btnAnotherOne.setBackground(Color.ORANGE);
        btnAnotherOne.setForeground(Color.WHITE);
        btnAnotherOne.setBounds(38, 83, 131, 46);
        contentPane.add(btnAnotherOne);
    }
    
    public void closewindow(){
        this.setVisible(false);
    }
}
