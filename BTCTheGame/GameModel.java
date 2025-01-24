import java.util.Random;

/**
 * Write a description of class GameModel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameModel
{
    // instance variables - replace the example below with your own
    double goalIce;
    String goalPobble;
    String goalTea;
    double goalSugar;
    
    public String randomPobble(){
        String[] pobbleOptions = {"Tapioka","Mango","Apple","Passion Fruit","Lemon"};
        int pobble = (int) (Math.random() * 5);
        //System.out.println(pobble + " " + pobbleOptions[pobble]);
        return pobbleOptions[pobble];
    }
    public String goalTea() {
        String[] teaOptions = {"Milk","Mango","Lemon","Fruit Salad","Nuclear Apple","Passion Fruit","Peach"};
        int tea = (int) (Math.random()*7);
        return teaOptions[tea];
    }
    public double goalIce() {
        double[] iceOptions ={0.0,0.25,0.50,0.75,1.0};
        int ice = (int)(Math.random()*5);
        return iceOptions[ice];
    }
    public double goalSuiker() {
        double[] sugarOptions ={0.0,0.25,0.50,0.75,1.0};
        int sugar = (int)(Math.random()*5);
        return sugarOptions[sugar];
    }
}

