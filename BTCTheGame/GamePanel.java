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
    PlayerClass player;
    int playerHistoricLoc;
    JLabel[][] labels;
    //variables for drink rowse
    /**
     * Constructor for objects of class GamePanel
     */
    public GamePanel(PlayerClass player)
    {
        setLayout(new GridLayout(5,20));
        //esetBackgroundImage("Images/Background.png");
        //paintComponent();
        labels = new JLabel[5][18];
        playerHistoricLoc = 15;
        
        for (int r=0;r<5;r++){
            for(int c=0;c<18;c++){
                labels[r][c] = new JLabel();
                labels[r][c].setFont(new Font("Serif", Font.PLAIN, 20));
                if(r==2 && c==0){
                    labels[r][c].setIcon(resizeImage("ICE.png"));

                } else if (r==2 && c==1){
                    labels[r][c].setIcon(resizeImage("SUGAR.png"));

                } else if (r==2 && c==2) {
                    labels[r][c].setIcon(resizeImage("POB_Apple.png"));

                }
                else if (r==2 && c==3) {
                    labels[r][c].setIcon(resizeImage("POB_Blueberry.png"));

                }else if (r==2 && c==4) {
                    labels[r][c].setIcon(resizeImage("POB_Lemon.png"));

                }else if (r==2 && c==5) {
                    labels[r][c].setIcon(resizeImage("POB_Mango.png"));

                }else if (r==2 && c==6) {
                    labels[r][c].setIcon(resizeImage("POB_Peach.png"));

                }
                else if (r==2 && c==7) {
                    labels[r][c].setIcon(resizeImage("POB_Tapioca.png"));

                }
                else if (r==2 && c==8) {
                    labels[r][c].setIcon(resizeImage("BT_Apple.png"));

                }else if (r==2 && c==9) {
                    labels[r][c].setIcon(resizeImage("BT_Lemon.png"));

                }else if (r==2&& c==10) {
                    labels[r][c].setIcon(resizeImage("BT_Milk.png"));

                }else if (r==2 && c==11) {
                    labels[r][c].setIcon(resizeImage("BT_Passion.png"));

                }
                else if (r==2 && c==12) {
                    
                    labels[r][c].setIcon(resizeImage("BT_Peach.png"));

                }else if (r==2 && c==12) {
                    labels[r][c].setIcon(resizeImage("BT_Strawberry.png"));

                } else if (r==3 && c==playerHistoricLoc){
                    labels[r][c].setIcon(player.getIcon());
                }
                else {
                    labels[r][c].setText("");
                }
                add(labels[r][c]);
            }
        }
    }
    
    public void setPlayerLocation(int r, PlayerClass player) {
        labels[3][playerHistoricLoc].setIcon(resizeImage("BLANK.png"));
        labels[3][r].setIcon(player.getIcon());
        playerHistoricLoc = r;
    }
    
    public void addCanvas() {
        //System.out.println("Adding the game panel");
        add(canvas);
    }
    
    private ImageIcon resizeImage(String img) {
        ImageIcon imageIcon = new ImageIcon("Images/" + img); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(120, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
    }
    @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);
    Image img = Toolkit.getDefaultToolkit().getImage("Images/Background.png");

    //Image img = new Image();
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
}

}

