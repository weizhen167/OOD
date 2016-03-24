package ui;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;

import model.DataWriter;
import model.ImageManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("serial")
public class Mainscreen extends JFrame {

    private JPanel contentPane;
    private ArrayList<Integer> screenlist = new ArrayList<Integer>();
    private Color jjc;
    private int hand = 0;
    private int sex = 0;
    private int screen;
    private ArrayList<Integer> iconlist = new ArrayList<Integer>();
    private ArrayList<String> datastore = new ArrayList<String>();
    private String database = "";
    Random random = new Random();
    int xxc = random.nextInt(4);
    
    public void initialize(ArrayList<Integer> l) {
        int ns = this.screen * 20;
        ArrayList<Integer> nl = new ArrayList<Integer>();
        int i = ns - 20;
        while (i < ns) {
            nl.add(l.get(i));
            i++;
        }
        this.screenlist = nl;  
        if (this.xxc == 0) {
            this.jjc = Color.RED;
        }
        if (this.xxc == 1) {
            this.jjc = Color.BLUE;
        }
        if (this.xxc == 2) {
            this.jjc = Color.WHITE;
        }
        if (this.xxc == 3) {
            this.jjc = Color.BLACK;
        }
    }

    /**
     * c Create the frame.
     */
    public Mainscreen(int screen, int sex, int hand, ArrayList<Integer> l1,
            ArrayList<String> datastore, String database) {
        this.hand = hand;
        this.sex = sex;
        this.screen = screen;
        this.iconlist = l1;
        this.datastore = datastore;
        this.database = database;
        initialize(l1);
        setTitle("IS4900 Icon Test");
        Container con = getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 0, 380, 667);
        contentPane = new JPanel();
        contentPane.setBackground(jjc);
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        contentPane.setLayout(null);
        con.add(contentPane);

        JButton button_1 = new JButton(ImageManager.getInstance()
                .getImageByType(screenlist.get(0)));
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                publish(1, screenlist.get(0));
            }
        });
        button_1.setBounds(17, 50, 70, 70);
        button_1.setOpaque(true);
        button_1.setContentAreaFilled(false);
        button_1.setBorder(null);
        contentPane.add(button_1);

        JButton button_2 = new JButton(ImageManager.getInstance()
                .getImageByType(screenlist.get(1)));
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                publish(2, screenlist.get(1));
            }
        });
        button_2.setBounds(106, 50, 70, 70);
        button_2.setOpaque(true);
        button_2.setContentAreaFilled(false);
        button_2.setBorder(null);
        contentPane.add(button_2);

        JButton button_3 = new JButton(ImageManager.getInstance()
                .getImageByType(screenlist.get(2)));
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                publish(3, screenlist.get(2));
            }
        });
        button_3.setBounds(194, 50, 70, 70);
        button_3.setOpaque(true);
        button_3.setContentAreaFilled(false);
        button_3.setBorder(null);
        contentPane.add(button_3);

        JButton button_4 = new JButton(ImageManager.getInstance()
                .getImageByType(screenlist.get(3)));
        button_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                publish(4, screenlist.get(3));
            }
        });
        button_4.setBounds(280, 50, 70, 70);
        button_4.setOpaque(true);
        button_4.setContentAreaFilled(false);
        button_4.setBorder(null);
        contentPane.add(button_4);

        JButton button_5 = new JButton(ImageManager.getInstance()
                .getImageByType(screenlist.get(4)));
        button_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                publish(5, screenlist.get(4));
            }
        });
        button_5.setBounds(17, 140, 70, 70);
        button_5.setOpaque(true);
        button_5.setContentAreaFilled(false);
        button_5.setBorder(null);
        contentPane.add(button_5);

        JButton button_6 = new JButton(ImageManager.getInstance()
                .getImageByType(screenlist.get(5)));
        button_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                publish(6, screenlist.get(5));
            }
        });
        button_6.setBounds(106, 140, 70, 70);
        button_6.setOpaque(true);
        button_6.setContentAreaFilled(false);
        button_6.setBorder(null);
        contentPane.add(button_6);

        JButton button_7 = new JButton(ImageManager.getInstance()
                .getImageByType(screenlist.get(6)));
        button_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                publish(7, screenlist.get(6));
            }
        });
        button_7.setBounds(194, 140, 70, 70);
        button_7.setOpaque(true);
        button_7.setContentAreaFilled(false);
        button_7.setBorder(null);
        contentPane.add(button_7);

        JButton button_8 = new JButton(ImageManager.getInstance()
                .getImageByType(screenlist.get(7)));
        button_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                publish(8, screenlist.get(7));
            }
        });
        button_8.setBounds(280, 140, 70, 70);
        button_8.setOpaque(true);
        button_8.setContentAreaFilled(false);
        button_8.setBorder(null);
        contentPane.add(button_8);

        JButton button_9 = new JButton(ImageManager.getInstance()
                .getImageByType(screenlist.get(8)));
        button_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                publish(9, screenlist.get(8));
            }
        });
        button_9.setBounds(17, 230, 70, 70);
        button_9.setOpaque(true);
        button_9.setContentAreaFilled(false);
        button_9.setBorder(null);
        contentPane.add(button_9);

        JButton button_10 = new JButton(ImageManager.getInstance()
                .getImageByType(screenlist.get(9)));
        button_10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                publish(10, screenlist.get(9));
            }
        });
        button_10.setBounds(106, 230, 70, 70);
        button_10.setOpaque(true);
        button_10.setContentAreaFilled(false);
        button_10.setBorder(null);
        contentPane.add(button_10);

        JButton button_11 = new JButton(ImageManager.getInstance()
                .getImageByType(screenlist.get(10)));
        button_11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                publish(11, screenlist.get(10));
            }
        });
        button_11.setBounds(194, 230, 70, 70);
        button_11.setOpaque(true);
        button_11.setContentAreaFilled(false);
        button_11.setBorder(null);
        contentPane.add(button_11);

        JButton button_12 = new JButton(ImageManager.getInstance()
                .getImageByType(screenlist.get(11)));
        button_12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                publish(12, screenlist.get(11));
            }
        });
        button_12.setBounds(280, 230, 70, 70);
        button_12.setOpaque(true);
        button_12.setContentAreaFilled(false);
        button_12.setBorder(null);
        contentPane.add(button_12);

        JButton button_13 = new JButton(ImageManager.getInstance()
                .getImageByType(screenlist.get(12)));
        button_13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                publish(13, screenlist.get(12));
            }
        });
        button_13.setBounds(17, 320, 70, 70);
        button_13.setOpaque(true);
        button_13.setContentAreaFilled(false);
        button_13.setBorder(null);
        contentPane.add(button_13);

        JButton button_14 = new JButton(ImageManager.getInstance()
                .getImageByType(screenlist.get(13)));
        button_14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                publish(14, screenlist.get(13));
            }
        });
        button_14.setBounds(106, 320, 70, 70);
        button_14.setOpaque(true);
        button_14.setContentAreaFilled(false);
        button_14.setBorder(null);
        contentPane.add(button_14);

        JButton button_15 = new JButton(ImageManager.getInstance()
                .getImageByType(screenlist.get(14)));
        button_15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                publish(15, screenlist.get(14));
            }
        });
        button_15.setBounds(194, 320, 70, 70);
        button_15.setOpaque(true);
        button_15.setContentAreaFilled(false);
        button_15.setBorder(null);
        contentPane.add(button_15);

        JButton button_16 = new JButton(ImageManager.getInstance()
                .getImageByType(screenlist.get(15)));
        button_16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                publish(16, screenlist.get(15));
            }
        });
        button_16.setBounds(280, 320, 70, 70);
        button_16.setOpaque(true);
        button_16.setContentAreaFilled(false);
        button_16.setBorder(null);
        contentPane.add(button_16);

        JButton button_17 = new JButton(ImageManager.getInstance()
                .getImageByType(screenlist.get(16)));
        button_17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                publish(17, screenlist.get(16));
            }
        });
        button_17.setBounds(17, 410, 70, 70);
        button_17.setOpaque(true);
        button_17.setContentAreaFilled(false);
        button_17.setBorder(null);
        contentPane.add(button_17);

        JButton button_18 = new JButton(ImageManager.getInstance()
                .getImageByType(screenlist.get(17)));
        button_18.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                publish(18, screenlist.get(17));
            }
        });
        button_18.setBounds(106, 410, 70, 70);
        button_18.setOpaque(true);
        button_18.setContentAreaFilled(false);
        button_18.setBorder(null);
        contentPane.add(button_18);

        JButton button_19 = new JButton(ImageManager.getInstance()
                .getImageByType(screenlist.get(18)));
        button_19.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                publish(19, screenlist.get(18));
            }
        });
        button_19.setBounds(194, 410, 70, 70);
        button_19.setOpaque(true);
        button_19.setContentAreaFilled(false);
        button_19.setBorder(null);
        contentPane.add(button_19);

        JButton button_20 = new JButton(ImageManager.getInstance()
                .getImageByType(screenlist.get(19)));
        button_20.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                publish(20, screenlist.get(19));
            }
        });
        button_20.setBounds(280, 410, 70, 70);
        button_20.setOpaque(true);
        button_20.setContentAreaFilled(false);
        button_20.setBorder(null);
        contentPane.add(button_20);

        ImageIcon head = ImageManager.getInstance().getImageByType(402);
        JLabel lblNewLabel = new JLabel(head);
        lblNewLabel.setBounds(0, 519, 366, 109);
        contentPane.add(lblNewLabel);

        ImageIcon tail = ImageManager.getInstance().getImageByType(401);
        JLabel lblNewLabel_1 = new JLabel(tail);
        lblNewLabel_1.setBounds(0, 0, 366, 22);
        contentPane.add(lblNewLabel_1);
    }

    public String publish(int location, int icon) {
        if (icon > 200){
            icon = icon - 200;
        }
        System.out
                .println("   "+Integer.toString(this.xxc) + "  |  "
                        + Integer.toString(this.sex) + "   |  "
                        + Integer.toString(this.hand) + " | "
                        + Integer.toString(location) + "    | "
                        + Integer.toString(icon));

        this.datastore.add(Integer.toString(this.xxc));
        this.datastore.add(Integer.toString(this.sex));
        this.datastore.add(Integer.toString(this.hand));
        this.datastore.add(Integer.toString(location));
        this.datastore.add(Integer.toString(icon));

        this.screen = this.screen + 1;

        if (this.screen == 21) {
            System.out.println("Writing...");            
            w2excel(this.database, this.datastore);
            this.setVisible(false);
            System.out.println("Competle!!!");
            
        } else {
            Mainscreen frame = new Mainscreen(this.screen, this.sex, this.hand,
                    this.iconlist, this.datastore, this.database);
            this.setVisible(false);      
            frame.setVisible(true);
        }
        return null;
    }

    public void w2excel(String database, ArrayList<String> data) {
        DataWriter w = new DataWriter(database, data);
        w.writeData();
    }
}
