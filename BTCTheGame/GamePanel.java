import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.*;

/**
 * Write a description of class GamePanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GamePanel extends JPanel implements KeyListener
{
    // instance variables - replace the example below with your own
    //private CanvasClass canvas = new CanvasClass();
    private Canvas canvas;
    //PlayerClass player;
    int playerHistoricLoc;
    JLabel[][] labels;
    int background = 0;
    ImageIcon[] customers;
    ImageIcon playerIcon;
    UI ui;
    /**
     * Constructor for objects of class GamePanel
     */
    public GamePanel(ImageIcon playerIcon, ImageIcon[] customers, UI ui)
    {
        setLayout(new GridLayout(5,20));
        //esetBackgroundImage("Images/Background.png");
        //paintComponent();
        this.ui = ui;
        labels = new JLabel[5][18];
        playerHistoricLoc = 14;
        //addKeyListener(this);
        //getInputMap().put(KeyStroke.getKeyStroke());
        
        this.customers = customers;
        this.playerIcon = playerIcon;
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
                    labels[r][c].setIcon(playerIcon);
                } else if (r==3&&c==16){
                    labels[r][c].setIcon(customers[0]);
                } else if (r==3&&c==17) {
                    labels[r][c].setIcon(customers[1]);

                }
                else {
                    labels[r][c].setText("");
                }
                add(labels[r][c]);
            }
        }
    }
    public void toggleBackground(){
        background = (int) (Math.random()*20);
        repaint();
    }
    public void setPlayerLocation(int r) {
        labels[3][playerHistoricLoc].setIcon(resizeImage("BLANK.png"));
        labels[3][r].setIcon(ui.getModel().getPlayer().getIcon());
        playerHistoricLoc = r;
    }
    public void refreshCustomers(ImageIcon[] customers) {
        labels[3][16].setIcon(customers[0]);
        labels[3][17].setIcon(customers[1]);


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
    Image img;
    if (background != 1) {
        img = Toolkit.getDefaultToolkit().getImage("Images/Background1.png");
    } else {
        img = Toolkit.getDefaultToolkit().getImage("Images/Background2.png");

    }
    //Image img = new Image();
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
}
@Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e + "KEY TYPED: ");
    }

    /** Handle the key-pressed event from the text field. */
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e + "KEY PRESSED: ");
    }

    /** Handle the key-released event from the text field. */
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println( e+ "KEY RELEASED: ");
    }
    
}

