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
     * Constructor for Autoclicker
     * Precondition: Cover.currentCover is not null
     */
    public Autoclicker()
    {
        super("Autoclicker 2000", 
        "Too lazy to install an autoclicker? This will perform 500 clicks for you. This may backfire.", 
        500, 1, "images/Autoclick.png");
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

        fakeTimer.scheduleAtFixedRate(new TimerTask(){
            private int tick = 500;
            public void run()
            {
                if (this.tick == 0)
                {
                    fakeTimer.cancel();
                }
                else
                {
                    PlayerActions.click();
                    this.tick -= 1;
                }
            }
        }, 0, 50);
    }
}
