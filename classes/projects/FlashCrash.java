package classes.projects;

import java.awt.Color;
import gameNav.*;

/**
 * Purposely create a stock market crash using high speed trading software. 
 * A flash crash will damage stock value for a few turns, but it might come with benefits...
 * @author Justin
 * @since 10/1/21
 */
public class FlashCrash extends Project
{
    /**
     * Constructs a flash crash ig
     */
    public FlashCrash()
    {
        super("Flash Crash", "Execute high speed Linux trading software to create a massive flash crash. Investors panic sell over the next 10 turns.", 
        10000, 1, "images/FlashCrash.png", Color.RED);
    }

    /**
     * Determines whether CycleSuspension will display. 
     * This project is only available in Bitcoin and Dank Memer
     */
    public boolean determineDisplay()
    {
        String pName = Player.getCoin().getName();
        return pName.equalsIgnoreCase("Bitcoin") || pName.equalsIgnoreCase("Pepecoin");
    }

    
    /**
     * There's a 2% chance this will recalibrate
     * @return whether or not the calibration is 0
     */
    public boolean recalibrate()
    {
        if ((int)(Math.random() * 50) == 5)
        {
            this.numClicked = 0;
            return true;
        }
        
        return false;
    }

    /**
     * Summon a flash crash!
     * There will be no taxes for the next 5 turns
     */
    public void initiate()
    {
        PlayerActions.taskQueue.add(new FCCmd());
    }
}

/**
 * Flash crash timed command
 */
class FCCmd extends TimedCommand
{
    /**
     * Forced price calc
     */
    private double forceTally = 0;

    /**
     * Constructs flash crash
     */
    public FCCmd()
    {
        super(5);
        this.forceTally = Player.getCoin().calculatePrice();
    }

    /**
     * Has the player summon a flash crash
     * @return Continue performing
     */
    public boolean execute()
    {
        Player.getCoin().setSupply((int)(Player.getCoin().getSupply() * Math.random()));
        Player.getCoin().setInvestors((int)(Player.getCoin().getInvestors() * Math.max(0.75, Math.random())));

        if (this.getTimer() == 1)
        {
            Player.getCoin().setForcedPrice(-1);
        }
        else
        {
            this.forceTally *= Math.random() + 0.2;
            Player.getCoin().setForcedPrice(this.forceTally);
        }

        return true;
    }
}