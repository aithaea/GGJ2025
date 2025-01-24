import javax.swing.JFrame;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observer;
import java.util.Observable;

/**
 * Write a description of class UI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UI extends JFrame implements Observer
{
    // instance variables - replace the example below with your own
    GameModel model;
    
    JPanel orderPanel = new JPanel();
    JPanel currentDrinkPanel = new JPanel(new GridLayout(2,4));
    JPanel gamePanel;
    
    //orderpanel
    JTextArea orderToMake = new JTextArea(5,50);
    
    //drink panel
    JLabel Ice, currentIce, Tea, currentTea, sugar, currentSugar, pobbles, currentPobbles;
    public UI(GameModel model) {
        this.model = model;
        gamePanel = new GamePanel();
        
        makeOrderPanel();
        makeDrinkPanel();
        makeFrame();
        showFrame();
    }
    public void populateOrderPanel() {
        String orderString = "";
        orderString += "Ice" + " " + model.goalIce();
        orderString += "Tea" + " " + model.goalTea();
        orderString += "Pobble" + " " + model.randomPobble();
        orderString += "Sugar" + " " + model.goalSuiker();
        orderToMake.setText(orderString);
    }
    
    public void makeOrderPanel() {
        populateOrderPanel();
        orderToMake.setEditable(false);
        orderPanel.add(orderToMake);
    }
    public void makeDrinkPanel() {
        //currentDrinkPanel.layout(new GridLayout(2,4));
        Ice =new JLabel("Ice");
        currentDrinkPanel.add(Ice);
        
        currentIce = new JLabel("0");
        currentDrinkPanel.add(currentIce);
        
        Tea = new JLabel("Tea");
        currentDrinkPanel.add(Tea);
    }
    public void makeFrame() {
        
        add(orderPanel, BorderLayout.NORTH);
        add(currentDrinkPanel,BorderLayout.WEST);
        add(gamePanel, BorderLayout.CENTER);
        
        setSize(900,900);
        
    }
    public void showFrame() {
        this.setVisible(true);
    }
    @Override
    public void update(Observable o, Object obj) {
        
    }
}
