import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.*;
import javax.swing.border.EmptyBorder;

/**
 * Write a description of class CustomPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CustomPanel extends JPanel
{
    private String background;
    public CustomPanel(String background){
        this.background = background;
        setBorder(new EmptyBorder(10, 10, 10, 10));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image img;

        img = Toolkit.getDefaultToolkit().getImage("Images/" + background);

        //img = Toolkit.getDefaultToolkit().getImage("Images/Background2.png");

        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);

    }
}
