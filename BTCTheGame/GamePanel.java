import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.*;

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
    /**
     * Constructor for objects of class GamePanel
     */
    public GamePanel()
    {
        canvas = new Canvas() {
            public void paint(Graphics g) {
                // set color to red
                g.setColor(Color.red);
 
                // set Font
                g.setFont(new Font("Bold", 1, 20));
 
                // draw a string
                g.drawString("This is a canvas", 100, 100);
            }
        };
        
        canvas.setBackground(Color.black);
        
        
        
        //leaveAtTheBottom
        addCanvas();
    }
    
    public void addCanvas() {
        System.out.println("Adding the game panel");
        add(canvas);
    }

}
