import java.util.Random;
import java.util.Observable;

/**
 * Write a description of class GameModel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameModel extends Observable
{
    // instance variables - replace the example below with your own
    double goalIce;
    String goalPobble;
    String goalTea;
    double goalSugar;
    
    String currentTea, currentPobble;
    double currentSugar, currentIce;
    UI model;
    PlayerClass player;
    public GameModel() {
        model = new UI(this);
        
        addObserver(model);
        currentIce = 0.0;
        currentPobble = "";
        currentTea = "";
        currentSugar = 0.0;
        player=new PlayerClass();
    }
    public String randomPobble(){
        String[] pobbleOptions = {"Tapioka","Mango","Apple","Passion Fruit","Lemon"};
        int pobble = (int) (Math.random() * 5);
        //System.out.println(pobble + " " + pobbleOptions[pobble]);
        goalPobble = pobbleOptions[pobble];
        return goalPobble;
    }
    public String goalTea() {
        String[] teaOptions = {"Milk","Mango","Lemon","Fruit Salad","Nuclear Apple","Passion Fruit","Peach"};
        int tea = (int) (Math.random()*7);
        goalTea = teaOptions[tea];
        return goalTea;
    }
    public double goalIce() {
        double[] iceOptions ={0.0,0.25,0.50,0.75,1.0};
        int ice = (int)(Math.random()*5);
        goalIce = iceOptions[ice];
        return goalIce;
    }
    public double goalSuiker() {
        double[] sugarOptions ={0.0,0.25,0.50,0.75,1.0};
        int sugar = (int)(Math.random()*5);
        goalSugar = sugarOptions[sugar];
        return goalSugar;
    }
    
    public boolean checkDrinkAtCounter(double ice, double sugar, String tea, String pobble) {
        if (ice == goalIce && sugar == goalSugar && tea.equals(goalTea) && pobble.equals(goalPobble)){
            return true;
        } else {
            return false;
        }
    }
    
    public void playerMove(char move) {
        if (move == 'a') {
            player.moveLeft();
        } else if (move == 'd') {
            player.moveRight();
        }
    }
    public int getPlayerLocation() {
        return player.getPosition();
    }
    //getters
    public String getCurrentTea() {return currentTea;}
    public String getCurrentPobbles(){return currentPobble;}
    public double getCurrentIce(){return currentIce;}
    public double getCurrentSugar(){return currentSugar;}
    public String getGoalTea(){return goalTea;}
    public String getGoalPobbles(){return goalPobble;}
    public double getGoalIce(){return goalIce;}
    public double getGoalSugar(){return goalSugar;}
    //setters
    public void setCurrentTea(String tea){this.currentTea = tea;}
    public void setCurrentPPobbles(String pobbles){this.currentPobble = pobbles;}
    public void setCurrentIce(double ice){this.currentIce = ice;}
    public void setCurrentSugar(double sugar){this.currentSugar = sugar;}
    
    
}

