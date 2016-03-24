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
public class Failed extends JFrame {

    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public Failed() {
        setTitle("IS4900 Icon Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 300, 192, 201);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setForeground(Color.RED);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        this.setAlwaysOnTop(true);
        JButton btnNewButton = new JButton("Exit");
        btnNewButton.setFont(new Font("Calibri", Font.BOLD, 30));
        btnNewButton.setBackground(Color.ORANGE);
        btnNewButton.setBorder(null);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {         
                System.exit(0);
            }
        });
        btnNewButton.setBounds(30, 106, 118, 46);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("Failed:(");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setBounds(30, 10, 176, 71);
        contentPane.add(lblNewLabel);
    }
}
