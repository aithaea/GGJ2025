import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 * Write a description of class GamePanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GamePanel extends JPanel
{
    // instance variables - replace the example below with your own
    //private CanvasClass canvas = new CanvasClass();
    private Canvas canvas;
    JLabel[][] labels;
    //variables for drink rowse
    /**
     * Constructor for objects of class GamePanel
     */
    public GamePanel()
    {
        setLayout(new GridLayout(5,20));
        setBackground(Color.red);
        labels = new JLabel[5][20];
        for (int r=0;r<5;r++){
            for(int c=0;c<20;c++){
                labels[r][c] = new JLabel();
                labels[r][c].setFont(new Font("Serif", Font.PLAIN, 20));
                if(r==3 && c==0){
                    labels[r][c].setIcon(new ImageIcon("Images/ICE.png"));

                } else if (r==3 && c==1){
                    labels[r][c].setIcon(new ImageIcon("Images/SUGAR.png"));

                } else if (r==3 && c==2) {
                    labels[r][c].setIcon(new ImageIcon("Images/POB_Apple.png"));

                }
                else if (r==3 && c==3) {
                    labels[r][c].setIcon(new ImageIcon("Images/POB_Blueberry.png"));

                }else if (r==3 && c==4) {
                    labels[r][c].setIcon(new ImageIcon("Images/POB_Lemon.png"));

                }else if (r==3 && c==5) {
                    labels[r][c].setIcon(new ImageIcon("Images/POB_Mango.png"));

                }else if (r==3 && c==6) {
                    labels[r][c].setIcon(new ImageIcon("Images/POB_Peach.png"));

                }
                else if (r==3 && c==7) {
                    labels[r][c].setIcon(new ImageIcon("Images/POB_Tapioca.png"));

                }
                else if (r==3 && c==8) {
                    labels[r][c].setIcon(new ImageIcon("Images/BT_Apple.png"));

                }else if (r==3 && c==9) {
                    labels[r][c].setIcon(new ImageIcon("Images/BT_Lemon.png"));

                }else if (r==3&& c==10) {
                    labels[r][c].setIcon(new ImageIcon("Images/BT_Milk.png"));

                }else if (r==3 && c==11) {
                    labels[r][c].setIcon(new ImageIcon("Images/BT_Passion.png"));

                }
                else if (r==3 && c==12) {
                    
                    labels[r][c].setIcon(new ImageIcon("Images/BT_Peach.png"));

                }else if (r==3 && c==12) {
                    labels[r][c].setIcon(new ImageIcon("Images/BT_Strawberry.png"));

                }
                else {
                    labels[r][c].setText("b");
                }
                add(labels[r][c]);
            }
        }
    }
    
    public void setPlayerLocation(int r) {
        labels[r][8].setText("Player");
    }
    
    public void addCanvas() {
        //System.out.println("Adding the game panel");
        add(canvas);
    }
    
    private ImageIcon resizeImage(String img) {
        ImageIcon imageIcon = new ImageIcon("/img/" + img); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
    }
}

