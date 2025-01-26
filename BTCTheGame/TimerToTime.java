import java.util.*;
import javax.swing.JLabel;

/**
 * Write a description of class TimerToTime here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TimerToTime extends Observable
{
    public long startTime;
    public long elapsedtime;
    public long elapsedSeconds;
    public long secondsDisplay;
    public long elapsedMinutes;
    public long elapsedTime2 = 0;
    public String status;
    private JLabel displayedSeconds, displayedMinutes;
    public TimerToTime(JLabel displayedSeconds, JLabel displayedMinutes, UI ui) {
        status="running";
        this.displayedSeconds = displayedSeconds;
        this.displayedMinutes = displayedMinutes;
        addObserver(ui);
    }
    
    public void calculateCurrent(){
        elapsedTime2 = 0;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                elapsedTime2 +=1;
                //System.out.print(elapsedTime2);
                secondsDisplay = (60 - elapsedTime2) % 60;
                elapsedMinutes = secondsDisplay / 60;
                displayedSeconds.setText(secondsDisplay + "");
                displayedMinutes.setText(elapsedMinutes + "");
                if (secondsDisplay == 0) {
                    timer.cancel();
                    status="stopped";
                    setChanged();
                    notifyObservers(this);
                    //model = new GameModel();
                } else {
                    
                }
            }
        },0,1000);
        
        
        
    }
    public String getCurrentTime() {
        return ""+secondsDisplay;
    }
    public void addToTimer() {
        this.elapsedTime2 -= 10;
    }
    public String getStatus() {
        return status;
    }
}
