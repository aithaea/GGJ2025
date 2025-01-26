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
    
    
    
    UI view;
    PlayerClass player;
    CustomerClass customer;
    DrinkMaking makeDrink;
    public GameModel() {
        
        player = new PlayerClass();
        customer = new CustomerClass();
        makeDrink = new DrinkMaking();
        view = new UI(this);
        addObserver(view);
        //System.out.println(countObservers()+"");
        
        
    }
    
    
    
    public void playerMove(char move) {
        //System.out.println("PlayerMove");
        
        if (move == 'a') {
            //System.out.println("a");
            if (player.getPosition()!=0)
                player.moveLeft();
        } else if (move == 'd' ){
            //System.out.println("d");
            if (player.getPosition() != 17)
                player.moveRight();
        } 
        setChanged();
        notifyObservers(this);
    }
    public PlayerClass getPlayer() {
        return player;
    }
    public CustomerClass getCustomer() {
        return customer;
    }
    public DrinkMaking getDrinks() {
        return makeDrink;
    }
    public void makeDrinks() {
        player.setDirection();
        makeDrink.interactControls(player.getPosition());
        setChanged();
        notifyObservers(this);
    }
    
    
}

