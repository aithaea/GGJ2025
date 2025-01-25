
/**
 * Write a description of class PlayerClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayerClass
{
    // instance variables - replace the example below with your own
    private int posX, posY;
    public static int OGSPAWN = 17;
    /**
     * Constructor for objects of class PlayerClass
     */
    public PlayerClass()
    {
        // spawn player
        this.posY=8;
        this.posX=OGSPAWN;
    }

    public int moveLeft(){
        posX=posX-1;
        return posX;
    }
    public int moveRight(){
        posX=posX+1;
        return posX;
    }
    public int getPosition() {
        return posX;
    }
}
