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
    public static int OGSPAWN = 14;
    private String direction = "front";
    private double height;
    /**
     * Constructor for objects of class PlayerClass
     */
    public PlayerClass()
    {
        // spawn player
        System.out.print("blah");
        this.posY=3;
        this.posX=OGSPAWN;
    }
    public int moveLeft(){
        posX=posX-1;
        direction="left";
        return posX;
    }
    public int moveRight(){
        posX=posX+1;
        direction="right";
        return posX;
    }
    public void setDirection(){
        direction = "front";
    }
    public int getPosition() {
        return posX;
    }
    public void setPosition(){this.posX=15;}
    public ImageIcon getIcon() {
        if (direction.equals("left")){
        ImageIcon imageIcon = new ImageIcon("Images/" + "PlayerLeft.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(120, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
        } else if (direction.equals("right")){
            ImageIcon imageIcon = new ImageIcon("Images/" + "PlayerRight.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(90, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
        }
        ImageIcon imageIcon = new ImageIcon("Images/" + "PlayerForward.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(120, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
    }
}
