package view;

import java.awt.Image;
import javax.swing.ImageIcon;

public class ImageManager {

    private Image ground1;
    private Image ground2;
    private Image Wall1;
    private Image Wall2;
    private Image Wall3;
    private Image Wall4;
    private Image Wall5;
    private Image cursor;
    private Image Zombie;
    private Image target;


    private static ImageManager instance;

    public static ImageManager getInstance() {
        if (instance == null) {
            return new ImageManager();
        }
        return instance;
    }

    private ImageManager() {
        ground1 = loadImg("./src/pic/ground1.jpg");
        ground2 = loadImg("./src/pic/ground2.jpg");
        Wall1 = loadImg("./src/pic/wall2.jpg");
        Wall2 = loadImg("./src/pic/wall2.jpg");
        Wall3 = loadImg("./src/pic/wall3.jpg");
        Wall4 = loadImg("./src/pic/wall4.jpg");
        Wall5 = loadImg("./src/pic/wall5.jpg");
        cursor = loadImg("./src/pic/select.png");
        Zombie = loadImg("./src/pic/Zombie.jpg");
        target = loadImg("./src/pic/target.jpg");
    }

    public Image loadImg(String imgUrl) {
        ImageIcon icon = new ImageIcon(imgUrl);
        return icon.getImage();
    }

    public Image getImageByType(int type) {
        Image img = null;
        switch (type) {
        case 0:
            img = ground1;
            break;

        case 1:
            img = ground2;
            break;

        case 2:
            img = Wall1;
            break;
        case 3:
            img = Wall2;
            break;
        case 4:
            img = Wall3;
            break;
        case 5:
            img = Wall4;
            break;
        case 6:
            img = Wall5;
            break;
        case 7:
            img = target;
            break;

        }
        return img;
    }

    public Image getGround() {
        return ground1;
    }

    public Image getCursor() {
        return cursor;
    }

    public Image getZombie() {
        return Zombie;
    }

    public Image getTarget() {
        return target;
    }

    public void setTarget(Image target) {
        this.target = target;
    }
}
