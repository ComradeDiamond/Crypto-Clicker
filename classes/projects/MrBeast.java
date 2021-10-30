package classes.projects;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import gameNav.PlayerActions;
import gameNav.Player;
import gameNav.TimedCommand;

/**
 * Possessing an insane amount of wealth, Mr. Beast basically doubles and triples your clicks for the next 20 turns
 * Well... there's a chance.
 * @author Justin
 * @since 10/27/21
 * @category classes.projects
 */
public class MrBeast extends Project
{
    public MrBeast()
    {
        super("Mr. Beast", "Mr. Beast will basically throw money at your cause for the next 20 turns... well provided you win his Squid Game stuff.", 
        2000, 2, "/images/MrBeast.jpg", Color.ORANGE);
    }

    public double calculateCost()
    {
        return Math.max(this.cost, 0.15 * Player.getCash());
    }

    /**
     * @return Whether it's dogecoin
     */
    public boolean determineDisplay()
    {
        return Player.getCoin().getName().equals("Dogecoin!!!");
    }

    /**
     * Has a 1/40% chance of resetting or subtracing 1 from numClicked
     */
    public boolean recalibrate()
    {
        boolean yet = (int)(Math.random() * 40) == 2;
        if (yet)
        {
            this.numClicked = Math.max(0, this.numClicked - 1);
        }
        return yet;
    }

    public void initiate()
    {
        PlayerActions.taskQueue.add(new BeastTimed());
    }
}

/**
 * 25% chance to Gain 1-10x extra clicks
 * 5% chance to gain 1-50x extra clicks
 * 1% chance for Mr. Beast to just yeet you 500-1000x the current price
 */
class BeastTimed extends TimedCommand
{
    public BeastTimed()
    {
        super(20);
    }

    /**
     * @return Continue
     */
    public boolean execute()
    {
        if ((int)(Math.random() * 100) == 2)
        {
            //System.out.println('a');
            Player.changeCash(Player.getCoin().calculatePrice() * (int)(Math.random() * 500 + 500));
        }
        else if ((int)(Math.random() * 20) == 5)
        {
            //System.out.println('b');
            Timer fakeTimer = new Timer();
            fakeTimer.scheduleAtFixedRate(new TimerTask(){
                private int tick = (int)(Math.random() * 50);
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
        else if ((int)(Math.random() * 4) == 1)
        {
            //System.out.println('c');
            Timer fakeTimer = new Timer();
            fakeTimer.scheduleAtFixedRate(new TimerTask(){
                private int tick = (int)(Math.random() * 10);
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
        return true;
    }
}