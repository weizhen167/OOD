package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;

import javax.swing.ImageIcon;

import controller.controller;

import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class Welcom extends JFrame {

    private JPanel contentPane;
    private JTextField Xvalue;
    private JTextField Yvalue;

    public void setBak() {
        ((JPanel) this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("./src/welcome.jpg");
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }

    /**
     * Create the frame.
     */
    public Welcom() {
        setBak();
        Container c = getContentPane();
        setBounds(100, 100, 415, 335);
        contentPane = new JPanel();
        contentPane.setOpaque(false);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        c.add(contentPane);
        Xvalue = new JTextField();
        Xvalue.setBounds(170, 170, 43, 21);
        contentPane.add(Xvalue);
        Xvalue.setColumns(10);

        Yvalue = new JTextField();
        Yvalue.setBounds(170, 201, 43, 21);
        contentPane.add(Yvalue);
        Yvalue.setColumns(10);

        ImageIcon button = new ImageIcon("./src/play.jpg");
        JButton Start = new JButton(button);
        Start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int x = Integer.parseInt(Xvalue.getText());
                int y = Integer.parseInt(Yvalue.getText());
                JFrame frame = new JFrame();
                JPanel ZvsMushroom = new ZvsMushroom(x, y);
                ZvsMushroom.setBackground(UIManager.getColor("Table.gridColor"));
                frame.getContentPane().add(ZvsMushroom);
                frame.setLocation(0, 0);
                frame.setTitle("Zombie Looking For Mushrooms");
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                controller il = new controller(ZvsMushroom);
                ZvsMushroom.setLayout(null);
                frame.addKeyListener(il);
            }
        });
        Start.setBounds(123, 232, 100, 35);
        contentPane.add(Start);

        JLabel Xlable = new JLabel("X");
        Xlable.setFont(new Font("Calibri", Font.BOLD, 20));
        Xlable.setForeground(Color.WHITE);
        Xlable.setBounds(133, 167, 27, 26);
        contentPane.add(Xlable);

        JLabel Ylabel = new JLabel("Y");
        Ylabel.setFont(new Font("Calibri", Font.BOLD, 20));
        Ylabel.setForeground(Color.WHITE);
        Ylabel.setBounds(135, 198, 27, 26);
        contentPane.add(Ylabel);
        
        JLabel lblPleaseInputMap = new JLabel("<html><p>  Please Input<br> Map Size To Play<p/></html>");
        lblPleaseInputMap.setForeground(Color.WHITE);
        lblPleaseInputMap.setFont(new Font("Calibri", Font.BOLD, 28));
        lblPleaseInputMap.setBounds(84, 58, 219, 87);
        contentPane.add(lblPleaseInputMap);
    }
}
