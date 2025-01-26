import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout; 
import java.util.concurrent.ScheduledExecutorService;
import java.util.Observable;
import java.util.Observer;
import java.awt.GraphicsEnvironment;
import java.awt.Font;

//import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Write a description of class Timer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TimerClass extends JPanel
{
    // instance variables - replace the example below with your own
    public JLabel displayedSeconds, displayedMinutes, colon;
    
    private TimerToTime timer;
    //private GameModel model;
    /**
     * Constructor for objects of class Timer
     */
    public TimerClass(UI ui)
    {
        displayedSeconds = new JLabel("00");
        displayedSeconds.setFont(new Font("Chalkduster", Font.BOLD,22));
        colon = new JLabel(":");
                colon.setFont(new Font("Chalkduster", Font.BOLD,22));

        displayedMinutes = new JLabel("00");
                displayedMinutes.setFont(new Font("Chalkduster", Font.BOLD,22));

        setLayout(new GridLayout(1,3));
        displayTimer();
        setOpaque(false);
        
        timer = new TimerToTime(displayedSeconds, displayedMinutes, ui);
    }
    public TimerToTime getTimer() {
        return timer;
    }
    public void displayTimer() {
        add(displayedMinutes);
        add(colon);
        add(displayedSeconds);
    }
    
}