package ui;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JButton;

import model.ImageManager;
import model.NumMaker;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class Welcome extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    /**
     * Create the frame.
     */
    public Welcome() {
        setTitle("IS4900 Icon Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 0, 380, 667);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel Gender = new JLabel("Please Select Your Gender");
        Gender.setFont(new Font("Calibri", Font.BOLD, 15));
        Gender.setBounds(10, 260, 174, 46);
        contentPane.add(Gender);

        JLabel Hand = new JLabel("Please Select Your Hand Preference");
        Hand.setFont(new Font("Calibri", Font.BOLD, 15));
        Hand.setBounds(10, 310, 236, 46);
        contentPane.add(Hand);

        JRadioButton Male = new JRadioButton("Male");
        Male.setSelected(true);
        Male.setBackground(Color.WHITE);
        Male.setBounds(222, 271, 65, 23);
        contentPane.add(Male);

        JRadioButton Female = new JRadioButton("Female");
        Female.setBackground(Color.WHITE);
        Female.setBounds(289, 271, 69, 23);
        contentPane.add(Female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(Male);
        bg.add(Female);

        JRadioButton left = new JRadioButton("Left");
        left.setBackground(Color.WHITE);
        left.setBounds(243, 321, 50, 23);
        contentPane.add(left);

        JRadioButton right = new JRadioButton("Right");
        right.setSelected(true);
        right.setBackground(Color.WHITE);
        right.setBounds(303, 321, 55, 23);
        contentPane.add(right);

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(left);
        bg1.add(right);

        JLabel lblDataStore = new JLabel("DataBase path:");
        lblDataStore.setFont(new Font("Calibri", Font.BOLD, 15));
        lblDataStore.setBounds(10, 360, 109, 46);
        contentPane.add(lblDataStore);

        textField = new JTextField("C:/Users/Zhen/Desktop/is4900/IS4900data1.xls");
        textField.setBounds(113, 371, 245, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel(
                "Example: C:/Users/ZHEN/Desktop/IS4900data.xls");
        lblNewLabel.setBounds(10, 402, 283, 15);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel(ImageManager.getInstance()
                .getImageByType(403));
        lblNewLabel_1.setBackground(Color.RED);
        lblNewLabel_1.setBounds(84, 22, 200, 203);
        contentPane.add(lblNewLabel_1);

        JLabel lblZhenWei = new JLabel("-Zhen Wei, NorthEastern University");
        lblZhenWei.setBounds(60, 598, 220, 15);
        contentPane.add(lblZhenWei);

        JLabel lblWeizhehuskyneuedu = new JLabel("-wei.zhe@husky.neu.edu");
        lblWeizhehuskyneuedu.setBounds(60, 607, 212, 15);
        contentPane.add(lblWeizhehuskyneuedu);

        JButton btnNewButton = new JButton(ImageManager.getInstance()
                .getImageByType(404));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                String gen = "";
                String hand = "";

                if (Male.isSelected()) {
                    gen = "Male";
                }
                if (Female.isSelected()) {
                    gen = "Female";
                }
                if (left.isSelected()) {
                    hand = "Left";
                }
                if (right.isSelected()) {
                    hand = "Right";
                }
                openNewScreen(gen, hand);
            }
        });
        btnNewButton.setBounds(84, 464, 195, 70);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBorder(null);
        contentPane.add(btnNewButton);
    }

    public void openNewScreen(String gen, String hand) {
        int g = 0;
        int h = 0;
        if ((gen != "") && (hand != "")) {
            if (gen.equals("Male")) {
                g = 1;
            }
            if (gen.equals("Female")) {
                g = 2;
            }
            if (hand.equals("Left")) {
                h = 1;
            }
            if (hand.equals("Right")) {
                h = 2;
            }
            NumMaker nm = new NumMaker(400);
            ArrayList<Integer> l1 = nm.mkUniqueArray();
            // (screen, gender,hand, ArrayList<Integer> l1)
            ArrayList<String> l2 = new ArrayList<String>();
            String database = textField.getText();
            Mainscreen frame = new Mainscreen(1, g, h, l1, l2, database);
            System.out.println("screen|gender|hand|location|icon");
            frame.setVisible(true);
            this.setVisible(false);
        }
    }
}
