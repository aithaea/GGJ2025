
/**
 * Write a description of class DrinkMaking here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DrinkMaking
{
    // instance variables - replace the example below with your own
    private double currentIce, currentSugar;
    private String currentTea, currentPobble;
    
    double goalIce;
    String goalPobble;
    String goalTea;
    double goalSugar;
    
    boolean changeDrinks;
    
    int score;
    /**
     * Constructor for objects of class DrinkMaking
     */
    public DrinkMaking()
    {
        currentIce = 0.0;
        currentPobble = "";
        currentTea = "";
        currentSugar = 0.0;
        score = 0;
        randomPobble();
        goalTea();
        goalIce();
        goalSuiker();
        
    }
    public String randomPobble(){
        String[] pobbleOptions = {"Tapioka","Mango","Apple","Passion Fruit","Lemon","Peach","Blueberry"};
        int pobble = (int) (Math.random() * 7);
        //System.out.println(pobble + " " + pobbleOptions[pobble]);
        goalPobble = pobbleOptions[pobble];
        return goalPobble;
    }
    public String goalTea() {
        String[] teaOptions = {"Milk","Lemon","Passion Fruit","Nuclear Apple","Peach"};
        int tea = (int) (Math.random()*5);
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
    public void generateDrinks() {
        goalSuiker();
        goalTea();
        goalIce();
        randomPobble();
        System.out.print(goalTea + " " + goalPobble + " " + goalIce + " " + goalSugar + " ");
    }
    public boolean checkDrinkAtCounter() {
        if (currentIce == goalIce && currentSugar == goalSugar && currentTea.equals(goalTea) && currentPobble.equals(goalPobble)){
            generateDrinks();
            score += 10;
            changeDrinks = true;
            clearcup();
            return true;
        } else {
            if (score > 0)
                score -=10;
            return false;
        }
    }
    public int getScore() {return score;}
    public void clearcup(){currentTea="";currentIce=0.0;currentSugar=0.0;currentPobble="";}
    public void interactControls(int r) {
        switch (r){
            case 0:currentIce+=0.25;break;
            case 1:currentSugar+=0.25;break;
            case 2:currentPobble = "Apple";break;
            case 3: currentPobble = "Blueberry";break;
            case 4: currentPobble = "Lemon";break;
            case 5: currentPobble = "Mango";break;
            case 6: currentPobble = "Peach";break;
            case 7: currentPobble = "Tapioka";break;
            case 8: currentTea = "Nuclear Apple";break;
            case 9: currentTea = "Lemon";break;
            case 10: currentTea = "Milk";break;
            case 11: currentTea="Passion Fruit";break;
            case 12: currentTea="Peach";break;
            case 14: checkDrinkAtCounter();break;
    }
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
    public boolean getChangeDrinks() {return changeDrinks;}
    //setters
    public void setCurrentTea(String tea){this.currentTea = tea;}
    public void setCurrentPPobbles(String pobbles){this.currentPobble = pobbles;}
    public void setCurrentIce(double ice){this.currentIce = ice;}
    public void setCurrentSugar(double sugar){this.currentSugar = sugar;}
    public void setChangeDrinks(boolean change){this.changeDrinks = change;}
    
}
