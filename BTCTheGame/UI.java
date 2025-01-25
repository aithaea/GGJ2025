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
    
    JPanel orderPanel = new CustomPanel("Frame1.png");
    JPanel currentDrinkPanel = new CustomPanel("Frame2.png");
    GamePanel gamePanel;
    JPanel testButtons = new CustomPanel("Frame1.png");
    JLabel scoreLabel = new JLabel();
    JPanel conditionalPanel = new CustomPanel("Frame2.png");
    int score = 000000;
    JPanel panelToHoldPanels = new JPanel(new GridLayout(1,3));
    //orderpanel
    JTextArea orderToMake = new JTextArea(5,30);
    
    //drink panel
    JLabel Ice, currentIce, Tea, currentTea, sugar, currentSugar, pobbles, currentPobbles;
    public UI(GameModel model) {
        this.model = model;
        gamePanel = new GamePanel(model.getPlayer());
        panelToHoldPanels = new CustomPanel("Frame1.png");
        panelToHoldPanels.setLayout(new GridLayout(1,3));
        currentDrinkPanel.setLayout(new GridLayout(4,2));
            //Image img = new Image();
        testButtonPanel();
        makeOrderPanel();
        makeDrinkPanel();
        scoreConditionsPanel();
        makeFrame();
        showFrame();
    }
    
    public void populateOrderPanel() {
        String orderString = "Customer's Order:\n";
        orderString += "Ice" + " " + model.getDrinks().getGoalIce();
        orderString += "\nTea" + " " + model.getDrinks().getGoalTea();
        orderString += "\nPobble" + " " + model.getDrinks().getGoalPobbles();
        orderString += "\nSugar" + " " + model.getDrinks().getGoalSugar();
        orderToMake.setText(orderString);
    }
    
    public void makeOrderPanel() {
        populateOrderPanel();
        orderToMake.setEditable(false);
        orderToMake.setOpaque(false);
        orderPanel.add(orderToMake);
    }
    
    public void makeDrinkPanel() {
        //currentDrinkPanel.layout(new GridLayout(2,4));
        JLabel currentCupStateTitle = new JLabel("Current Cup State");
        
        Ice =new JLabel("Ice");
        currentDrinkPanel.add(Ice);
        
        currentIce = new JLabel("" + model.getDrinks().getCurrentIce());
        currentDrinkPanel.add(currentIce);
        
        Tea = new JLabel("Tea");
        currentDrinkPanel.add(Tea);
        
        currentTea = new JLabel(model.getDrinks().getCurrentTea());
        currentDrinkPanel.add(currentTea);
        
        sugar = new JLabel("Sugar");
        currentDrinkPanel.add(sugar);
        
        currentSugar = new JLabel("" + model.getDrinks().getCurrentSugar());
        currentDrinkPanel.add(currentSugar);
        
        pobbles = new JLabel("Pobbles");
        currentDrinkPanel.add(pobbles);
        
        currentPobbles = new JLabel(model.getDrinks().getCurrentPobbles());
        currentDrinkPanel.add(currentPobbles);
        
    }
    public void scoreConditionsPanel() {
        conditionalPanel.setLayout(new GridLayout(2,2));
        JLabel scoreTitle = new JLabel("Score");
        conditionalPanel.add(scoreTitle);
        scoreLabel = new JLabel("00"+score);
        conditionalPanel.add(scoreLabel);
    }
    public void makeFrame() {
        panelToHoldPanels.add(orderPanel);
        panelToHoldPanels.add(currentDrinkPanel);
        panelToHoldPanels.add(conditionalPanel);
        add(panelToHoldPanels, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);
        
        //setSize(900,900);
        setExtendedState(this.MAXIMIZED_BOTH);
    }
    public void showFrame() {
        this.setVisible(true);
    }
    @Override
    public void update(Observable o, Object obj) {
        //System.out.println("Observers are notified");
        
        currentPobbles.setText(model.getDrinks().getCurrentPobbles());
        currentSugar.setText(""+model.getDrinks().getCurrentSugar());
        currentIce.setText(""+model.getDrinks().getCurrentIce());
        currentTea.setText(model.getDrinks().getCurrentTea());
        
        int r = model.getPlayer().getPosition();
        //System.out.print(r);
        gamePanel.setPlayerLocation(r,model.getPlayer());
        
        scoreLabel.setText(""+model.getDrinks().getScore());
        if (model.getDrinks().getChangeDrinks() == true){
            model.getDrinks().setChangeDrinks(false);
            populateOrderPanel();
        }
        gamePanel.toggleBackground();
        gamePanel.repaint();
        //generate textarea string
        
        
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
        //System.out.println(event.getActionCommand());
        if (event.getActionCommand().equals("Left")) {
            model.playerMove('a');
        } else if (event.getActionCommand().equals("Right")) {
            model.playerMove('d');
        } else if (event.getActionCommand().equals("Interact")) {
            model.makeDrinks();
        }
        
    }
}
