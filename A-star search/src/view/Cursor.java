package view;

import java.awt.Graphics2D;
import java.awt.Image;

public class Cursor {

    private int x;
    private int y;
    private Image img;
    private int limitx;
    private int limity;

    public Cursor(int x, int y, int x2, int y2) {
        this.x = x;
        this.y = y;
        this.limitx=y2;
        this.limity=x2;
        img = ImageManager.getInstance().getCursor();
    }

    public void drawSelf(Graphics2D g2d) {
        int horizon = x * 50;
        int vertical = y * 50;
        g2d.drawImage(img, horizon, vertical, null);
    }

    public void move(int direction) {
        switch (direction) {
        case 1:
            if (x + 1 < limitx) {
                x += 1;
            }
            return;
        case -1:
            if (x - 1 > -1) {
                x -= 1;
            }
            return;
        case 2:
            if (y + 1 < limity) {
                y += 1;
            }
            return;
        case -2:
            if (y - 1 > -1) {
                y -= 1;
            }
            return;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
