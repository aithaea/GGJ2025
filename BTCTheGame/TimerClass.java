import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout; 
import java.util.concurrent.ScheduledExecutorService;
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
    public long startTime;
    public long elapsedtime;
    public long elapsedSeconds;
    public long secondsDisplay;
    public long elapsedMinutes;
    public long elapsedTime2 = 0;
    /**
     * Constructor for objects of class Timer
     */
    public TimerClass()
    {
        displayedSeconds = new JLabel("00");
        colon = new JLabel(":");
        displayedMinutes = new JLabel("00");
        setLayout(new GridLayout(1,3));
        displayTimer();
        setOpaque(false);
        startTime = System.currentTimeMillis();
    }

    public void calculateCurrent() {
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
                repaint();
            }
        },0,1000);
        
        
        
    }

    public void displayTimer() {

        add(displayedMinutes);
        add(colon);
        add(displayedSeconds);

    }
}