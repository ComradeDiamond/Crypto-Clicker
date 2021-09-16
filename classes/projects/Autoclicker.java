package classes.projects;

import java.util.Timer;
import java.util.TimerTask;
import gameNav.PlayerActions;
import frontend.choiceBar.displays.Cover;

/**
 * The Autoclicker project will automatically click the coins for you.
 * Well, at a set price. This is basically designed to backfire.
 * @author Justin
 * @since 9/16/21
 * @category classes.projects
 */
public class Autoclicker extends Project
{
    /**
     * How many times the autoclicker clicks
     */
    protected int tickerations = 250;

    /**
     * Constructor for Autoclicker
     * Precondition: Cover.currentCover is not null
     */
    public Autoclicker()
    {
        super("Autoclicker 2000", 
        "Too lazy to install an autoclicker? This will perform 250 clicks for you. The JustinWare Corporation is not liable for any stock market crashes.", 
        500, 1, "images/Autoclicker.png");
    }

    /**
     * Activate the autoclicker.
     * It will exit the screen and quickly do the animation to display 500 clicks
     */
    public void initiate()
    {
        if (!this.canClick()) return;

        Cover.getCover().exit();
        Timer fakeTimer = new Timer();
        Autoclicker thing = this;

        fakeTimer.scheduleAtFixedRate(new TimerTask(){
            private int tick = thing.tickerations;
            public void run()
            {
                if (this.tick == 0)
                {
                    fakeTimer.cancel();
                }
                else
                {
                    PlayerActions.autoclick();
                    this.tick -= 1;
                }
            }
        }, 0, 30);
    }

    /**
     * Recalibrates use of the autoclicker.
     * Every click has a 10% chance of restoring the autoclicker.
     * @return whether this is already calibrated
     */
    public boolean recalibrate()
    {
        if ((int)(Math.random() * 10) == 5) 
        {
            this.numClicked = 0;
        }

        return this.numClicked == 0;
    }
}
