import javax.swing.JFrame;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observer;
import java.util.Observable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Write a description of class UI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UI extends JFrame implements Observer, ActionListener
{
    // instance variables - replace the example below with your own
    GameModel model;
    
    JPanel orderPanel = new JPanel();
    JPanel currentDrinkPanel = new JPanel(new GridLayout(4,2));
    GamePanel gamePanel;
    JPanel testButtons = new JPanel();
    
    //orderpanel
    JTextArea orderToMake = new JTextArea(5,50);
    
    //drink panel
    JLabel Ice, currentIce, Tea, currentTea, sugar, currentSugar, pobbles, currentPobbles;
    public UI(GameModel model) {
        this.model = model;
        gamePanel = new GamePanel();
        testButtonPanel();
        makeOrderPanel();
        makeDrinkPanel();
        makeFrame();
        showFrame();
    }
    
    public void populateOrderPanel() {
        String orderString = "";
        orderString += "Ice" + " " + model.getGoalIce();
        orderString += "\nTea" + " " + model.getGoalTea();
        orderString += "\nPobble" + " " + model.getGoalPobbles();
        orderString += "\nSugar" + " " + model.getGoalSugar();
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
        
        currentIce = new JLabel("" + model.getCurrentIce());
        currentDrinkPanel.add(currentIce);
        
        Tea = new JLabel("Tea");
        currentDrinkPanel.add(Tea);
        
        currentTea = new JLabel(model.getCurrentTea());
        currentDrinkPanel.add(currentTea);
        
        sugar = new JLabel("Sugar");
        currentDrinkPanel.add(sugar);
        
        currentSugar = new JLabel("" + model.getCurrentSugar());
        currentDrinkPanel.add(currentSugar);
        
        pobbles = new JLabel("Pobbles");
        currentDrinkPanel.add(pobbles);
        
        currentPobbles = new JLabel(model.getCurrentPobbles());
        currentDrinkPanel.add(currentPobbles);
        
    }
    public void makeFrame() {
        
        add(orderPanel, BorderLayout.NORTH);
        add(currentDrinkPanel,BorderLayout.WEST);
        add(gamePanel, BorderLayout.CENTER);
        
        //setSize(900,900);
        setExtendedState(this.MAXIMIZED_BOTH);
    }
    public void showFrame() {
        this.setVisible(true);
    }
    @Override
    public void update(Observable o, Object obj) {
        currentPobbles.setText(model.getCurrentPobbles());
        currentSugar.setText(""+model.getCurrentSugar());
        currentIce.setText(""+model.getCurrentIce());
        currentTea.setText(model.getCurrentTea());
        
        int r = model.getPlayerLocation();
        gamePanel.setPlayerLocation(r);
        
        //generate textarea string
        populateOrderPanel();
        
    }
    public void testButtonPanel() {
        testButtons = new JPanel();
        
        
        JButton leftButton = new JButton("Left");
        JButton rightButton = new JButton("Right");
        JButton interactButton = new JButton("Interact");
        
        leftButton.addActionListener(this);
        rightButton.addActionListener(this);
        interactButton.addActionListener(this);
        
        testButtons.add(leftButton);
        testButtons.add(rightButton);
        testButtons.add(interactButton);
        add(testButtons, BorderLayout.SOUTH);
    }
    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getActionCommand());
        if (event.getActionCommand().equals("left")) {
            model.playerMove('a');
            
        } else if (event.getActionCommand().equals("right")) {
            model.playerMove('d');
        }
        
    }
}
