package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

import model.Location;
import model.Maps;
import model.Zombie;

@SuppressWarnings("serial")
public class ZvsMushroom extends JPanel {

    
    private Cursor cursors;
    int[][] kk;
    private int[][] map;
    private Zombie c;

    public ZvsMushroom(int y, int x) {
        if (Maps.buildmap(x, y)) {
            this.map = Maps.MAP;
            int width = 50 * map[0].length;
            int height = 50 * map.length;
            this.setPreferredSize(new Dimension(width, height));
            this.setLayout(null);
            this.setBackground(Color.GRAY);
            cursors = new Cursor(y-3, 0,x,y);
            Location lo = new Location(y-3, 0);
            c = new Zombie(lo);
        }

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(50);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    repaint();
                }
            }
        }).start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawMap(g);
        drawCharacter(g);
        drawCursor(g);
    }

    private void drawMap(Graphics g) {
        int type = 0;
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                type = map[row][col];
                Image img = ImageManager.getInstance().getImageByType(type);
                if (img != null)
                    g.drawImage(img, col * 50, row * 50, this);
            }
        }
    }

    private void drawCursor(Graphics g) {
        cursors.drawSelf((Graphics2D) g);
    }

    private void drawCharacter(Graphics g) {
        c.drasSelf((Graphics2D) g);
    }

    public Cursor getCursors() {
        return cursors;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public Zombie getC() {
        return c;
    }

}
