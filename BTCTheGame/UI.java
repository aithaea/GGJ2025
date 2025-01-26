import javax.swing.JFrame;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observer;
import java.util.Observable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Image;

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
    
    TimerClass timerPanel;
   
    
    //drink panel
    JLabel Ice, currentIce, Tea, currentTea, sugar, currentSugar, pobbles, currentPobbles;
    public UI(GameModel model) {
        super("Bubble Tea Club the Game");
        this.model = model;
        gamePanel = new GamePanel(model.getPlayer().getIcon(),model.getCustomer().customerImages(), this);
        //addKeyListener(this);

        int start = JOptionPane.showConfirmDialog(null, "Welcome to BTC the game, your mission is to create customer's orders before time runs out. Each drink you make will earn you extra time, and some money. But don't get the drink wrong!\n Are you ready?","Welcome",JOptionPane.INFORMATION_MESSAGE);
        if (start != 0) {
            System.exit(0);
        }
        
        
        
        panelToHoldPanels = new CustomPanel("Frame1.png");
        panelToHoldPanels.setLayout(new GridLayout(1,3));
        currentDrinkPanel.setLayout(new GridLayout(4,2));
            //Image img = new Image();
        testButtonPanel();
        makeOrderPanel();
        makeDrinkPanel();
        
        scoreConditionsPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        makeFrame();
        showFrame();
    }
    public void makeTimerPanel() {
        timerPanel = new TimerClass(this);
        try{
        timerPanel.getTimer().calculateCurrent();
    } catch (Exception e) {}
    }
    public void populateOrderPanel() {
        String orderString = "Customer's Order:\n";
        orderString += "Ice" + " " + model.getDrinks().getGoalIce();
        orderString += "\nTea" + " " + model.getDrinks().getGoalTea();
        orderString += "\nPobble" + " " + model.getDrinks().getGoalPobbles();
        orderString += "\nSugar" + " " + model.getDrinks().getGoalSugar();
        orderToMake.setText(orderString);
    }
    
    public ImageIcon populateOrderIcon() {
        if (model.getDrinks().getGoalTea().equals("Nuclear Apple")) {
            if (model.getDrinks().getGoalPobbles().equals("Apple")) {
                return resizeBubbleTea("AppleApple.png");

            } else if (model.getDrinks().getGoalPobbles().equals("Tapioka") ){
                return resizeBubbleTea("AppleTapioca.png");
                
            }else if (model.getDrinks().getGoalPobbles().equals("Mango") ){
                
                return resizeBubbleTea("AppleMango.png");
            }else if (model.getDrinks().getGoalPobbles().equals("Peach") ){
                
                return resizeBubbleTea("ApplePeach.png");
            }else if (model.getDrinks().getGoalPobbles().equals("Lemon") ){
                
                return resizeBubbleTea("AppleLemon.png");
            }else if (model.getDrinks().getGoalPobbles().equals("Blueberry") ){
                
                return resizeBubbleTea("AppleBlueberry.png");
            }
        } else if(model.getDrinks().getGoalTea().equals("Peach")) {
            if (model.getDrinks().getGoalPobbles().equals("Apple")) {
                return resizeBubbleTea("PeachApple.png");

            } else if (model.getDrinks().getGoalPobbles().equals("Tapioka") ){
                return resizeBubbleTea("PeachTapioca.png");
                
            }else if (model.getDrinks().getGoalPobbles().equals("Mango") ){
                
                return resizeBubbleTea("PeachMango.png");
            }else if (model.getDrinks().getGoalPobbles().equals("Peach") ){
                
                return resizeBubbleTea("PeachPeach.png");
            }else if (model.getDrinks().getGoalPobbles().equals("Lemon") ){
                
                return resizeBubbleTea("PeachLemon.png");
            }else if (model.getDrinks().getGoalPobbles().equals("Blueberry") ){
                
                return resizeBubbleTea("PeachBlueberry.png");
            }  
        }    else if(model.getDrinks().getGoalTea().equals("Passionfruit")) {
            if (model.getDrinks().getGoalPobbles().equals("Apple")) {
                return resizeBubbleTea("PassionfruitApple.png");

            } else if (model.getDrinks().getGoalPobbles().equals("Tapioka") ){
                return resizeBubbleTea("PassionfruitTapioca.png");
                
            }else if (model.getDrinks().getGoalPobbles().equals("Mango") ){
                
                return resizeBubbleTea("PassionfruitMango.png");
            }else if (model.getDrinks().getGoalPobbles().equals("Peach") ){
                
                return resizeBubbleTea("PassionfruitPeach.png");
            }else if (model.getDrinks().getGoalPobbles().equals("Lemon") ){
                
                return resizeBubbleTea("PassionfruitLemon.png");
            }else if (model.getDrinks().getGoalPobbles().equals("Blueberry") ){
                
                return resizeBubbleTea("PassionfruitBlueberry.png");
            }  
        }    else if(model.getDrinks().getGoalTea().equals("Milk")) {
            if (model.getDrinks().getGoalPobbles().equals("Apple")) {
                return resizeBubbleTea("MilkApple.png");

            } else if (model.getDrinks().getGoalPobbles().equals("Tapioka") ){
                return resizeBubbleTea("MilkTapioca.png");
                
            }else if (model.getDrinks().getGoalPobbles().equals("Mango") ){
                
                return resizeBubbleTea("MilkMango.png");
            }else if (model.getDrinks().getGoalPobbles().equals("Peach") ){
                
                return resizeBubbleTea("MilkPeach.png");
            }else if (model.getDrinks().getGoalPobbles().equals("Lemon") ){
                
                return resizeBubbleTea("MilkLemon.png");
            }else if (model.getDrinks().getGoalPobbles().equals("Blueberry") ){
                
                return resizeBubbleTea("MilkBlueberry.png");
            }  
        }else if(model.getDrinks().getGoalTea().equals("Lemon")) {
            if (model.getDrinks().getGoalPobbles().equals("Apple")) {
                return resizeBubbleTea("LemonApple.png");

            } else if (model.getDrinks().getGoalPobbles().equals("Tapioka") ){
                return resizeBubbleTea("LemonTapioca.png");
                
            }else if (model.getDrinks().getGoalPobbles().equals("Mango") ){
                
                return resizeBubbleTea("LemonMango.png");
            }else if (model.getDrinks().getGoalPobbles().equals("Peach") ){
                
                return resizeBubbleTea("LemonPeach.png");
            }else if (model.getDrinks().getGoalPobbles().equals("Lemon") ){
                
                return resizeBubbleTea("LemonLemon.png");
            }else if (model.getDrinks().getGoalPobbles().equals("Blueberry") ){
                
                return resizeBubbleTea("LemonBlueberry.png");
            }  
        }
        return null;
    }
    public ImageIcon resizeBubbleTea(String image) {
        ImageIcon imageIcon = new ImageIcon("Images/" + image); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(120, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);
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
        makeTimerPanel();
        JLabel timeLabel = new JLabel("Time Remaining");
        conditionalPanel.add(timeLabel);
        conditionalPanel.add(timerPanel);
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
        if (timerPanel.getTimer().getStatus().equals("stopped")){
            int start = JOptionPane.showConfirmDialog(null, "Game over!\n Your end score was " + score + ".\n Would you like to play again?","Welcome",JOptionPane.INFORMATION_MESSAGE);
        if (start != 0) {
            System.exit(0);
        } else{
            try{
            timerPanel.getTimer().calculateCurrent();
        }catch (Exception e){}
            model.getDrinks().setChangeDrinks(false);
            populateOrderPanel();
            gamePanel.refreshCustomers(model.customer.incrementCustomers());
        
            int r =  model.getPlayer().getPosition();
            gamePanel.setPlayerLocation(r);
            gamePanel.repaint();
        }
        } else {
        currentPobbles.setText(model.getDrinks().getCurrentPobbles());
        currentSugar.setText(""+model.getDrinks().getCurrentSugar());
        currentIce.setText(""+model.getDrinks().getCurrentIce());
        currentTea.setText(model.getDrinks().getCurrentTea());
        
        
        int r = model.getPlayer().getPosition();
        //System.out.print(r);
        gamePanel.setPlayerLocation(r);
        
        scoreLabel.setText(""+model.getDrinks().getScore());
        if (model.getDrinks().getChangeDrinks() == true){
            model.getDrinks().setChangeDrinks(false);
            
            gamePanel.refreshCustomers(model.customer.incrementCustomers());
            timerPanel.getTimer().addToTimer();
            populateOrderPanel();
        } 
        gamePanel.toggleBackground();
        gamePanel.repaint();
        //generate textarea string
        
    }
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
        //timerPanel.calculateCurrent();
        if (event.getActionCommand().equals("Left")) {
            model.playerMove('a');
        } else if (event.getActionCommand().equals("Right")) {
            model.playerMove('d');
        } else if (event.getActionCommand().equals("Interact")) {
            model.makeDrinks();
        }
        
    }
    
    public GameModel getModel() {
        return model;
    }
}




