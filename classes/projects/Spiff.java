package classes.projects;

import java.awt.Color;
import classes.coin.Dogecoin;
import gameNav.Player;
import gameNav.PlayerActions;
import gameNav.TimedCommand;

/**
 * Spiffin' Brit will use his Yorkshire tea powers to generate clout while... hmm... let's say modify the algorithm.
 * Watch this: https://www.youtube.com/watch?v=zKpMEX9Ml2E&ab_channel=TheSpiffingBrit
 * @author Justin
 * @since 10/26/21
 * @category classes.projects
 */
public class Spiff extends Project
{
    public Spiff()
    {
        super("Spiffin' Brit", "The stock market is a perfectly balanced game with no exploits! I may or may not have intentionally programmed a stack overflow - use at your own discretion...", 
            50, 1, "/images/Spiff.jpg", Color.YELLOW);
    }

    public double calculateCost()
    {
        return Math.max(50, 0.62 * Player.getCash());
    }

    public boolean recalibrate()
    {
        boolean yet = (int)(Math.random() * 50) == 2;
        if (yet)
        {
            this.numClicked = 0;
        }
        return yet;
    }

    /**
     * @return Whether it's dogecoin
     */
    public boolean determineDisplay()
    {
        return Player.getCoin().getName().equals("Dogecoin!!!");
    }

    /**
     * Spiff exploits the algorithm - and some zeroes are now missing. Do what you will.
     */
    public void initiate()
    {
        Player.getCoin().changeModify(0.1);
        PlayerActions.taskQueue.add(new Corrupted());
    }
}

/**
 * For 5s, corrupt the thing
 */
class Corrupted extends TimedCommand
{
    public Corrupted()
    {
        super(6);
        ((Dogecoin)Player.getCoin()).setCorrupted(true);
    }

    /**
     * @return Should continue running
     */
    public boolean execute()
    {
        if (this.getTimer() == 1)
        {
            ((Dogecoin)Player.getCoin()).setCorrupted(false);
        }

        return true;
    }
}
