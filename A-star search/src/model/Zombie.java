package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import view.ImageManager;

public class Zombie {
    private Location lo;
    private Map<String, String> route = new LinkedHashMap<String, String>();
    private Image img;
    private boolean blink;
    private int count;
    private int x;
    private int y;

    public Zombie(Location lo) {
        this.lo = lo;
        img = ImageManager.getInstance().getZombie();
        x = lo.getX() * 50;
        y = lo.getY() * 50;

    }

    public void drasSelf(Graphics2D g2d) {
        int times = 5;
        if (!blink) {
            g2d.drawImage(img, x, y, null);
        } else {
            if (count <= times) {
                g2d.drawImage(img, x, y, null);
                count++;
            }
            if (count == times * 2) {
                count = 0;
            }
        }
    }

    public void moveForward(int[][] map, Location dest) {
        AstarPathFinder apf = new AstarPathFinder();
        List<Location> paths = apf.findPath(this.getLo(), dest, map);
        int index = paths.size() - 1;
        Location loc = null;
        for (; index >= 0; index--) {
            loc = paths.get(index);
            this.setLocationX(loc.getX());
            this.setLocationY(loc.getY());
        }
    }

    public void setLocationY(int nextY) {
        lo.setY(nextY);
        int yPixel = nextY * 50;
        if (yPixel >= y) {
            while (y < yPixel) {
                y += 2;
                try {
                    Thread.sleep(20);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            while (y > yPixel) {
                y -= 2;
                try {
                    Thread.sleep(20);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setLocationX(int nextX) {
        lo.setX(nextX);
        int xPixel = nextX * 50;
        if (xPixel >= x) {
            while (x < xPixel) {
                x += 2;
                try {
                    Thread.sleep(20);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            while (x > xPixel) {
                x -= 2;
                try {
                    Thread.sleep(20);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Location getLo() {
        return lo;
    }

    public void setLo(Location lo) {
        this.lo = lo;
    }

    public Map<String, String> getRoute() {
        return route;
    }

    public void setBlink(boolean blink) {
        this.blink = blink;
    }

    public void setRoute(Map<String, String> route) {
        this.route = route;
    }
}
