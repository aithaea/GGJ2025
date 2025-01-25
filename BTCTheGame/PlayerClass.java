import javax.swing.ImageIcon;
import java.awt.Image;

/**
 * Write a description of class PlayerClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayerClass
{
    // instance variables - replace the example below with your own
    private int posX, posY;
    public static int OGSPAWN = 15;
    /**
     * Constructor for objects of class PlayerClass
     */
    public PlayerClass()
    {
        // spawn player
        this.posY=3;
        this.posX=OGSPAWN;
    }
    public int moveLeft(){
        posX=posX-1;
        return posX;
    }
    public int moveRight(){
        posX=posX+1;
        return posX;
    }
    public int getPosition() {
        return posX;
    }
    public ImageIcon getIcon() {
        ImageIcon imageIcon = new ImageIcon("Images/" + "SUGAR.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(120, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
    }
}
