package classes.projects;

import java.awt.Color;
import gameNav.Player;
import gameNav.PlayerActions;
import gameNav.TimedCommand;

/**
 * Totally not stolen from PlagueINC LMAO
 * Cycle Suspension gets rid of taxes for a short while
 * @author Justin
 * @since 9/25/21
 * @category classes.projects
 */
public class CycleSuspension extends Project
{
    /**
     * Constructs a cycle suspension
     */
    public CycleSuspension()
    {
        super("Cycle Suspension", "Remotely inject command code 068101108097121 to halt all tax collection for the next 5 turns. Nanovirus activity is also disabled.", 
        Math.max(Player.getCash() * 0.2, 5000), 1, "/images/CycleSuspension.png", Color.GREEN);
    }

    /**
     * Determines whether CycleSuspension will display. 
     * This project is only available in Bitcoin and Dank Memer
     */
    public boolean determineDisplay()
    {
        String pName =  Player.getCoin().getName();
        return !pName.equalsIgnoreCase("Litecoin");
    }

    /**
     * @return Cost of Cycle Suspension
     */
    public double getCost()
    {
        return Math.max(Player.getCash() * 0.1, 5000);
    }
    
    /**
     * There's a 2.5% chance this will recalibrate
     * @return whether or not the calibration is 0
     */
    public boolean recalibrate()
    {
        if ((int)(Math.random() * 40) == 5)
        {
            this.numClicked = 0;
            return true;
        }
        
        return false;
    }

    /**
     * Initiate Cycle Suspension!
     * There will be no taxes for the next 5 turns
     */
    public void initiate()
    {
        PlayerActions.taskQueue.add(0, new CSCmd());
    }
}

/**
 * Cycle Suspension Command
 */
class CSCmd extends TimedCommand
{
    /**
     * Constructor for CSCmd
     */
    public CSCmd()
    {
        super(5);
    }

    /**
     * Has the player click with no tax
     * @return Do not continue performing
     */
    public boolean execute()
    {
        PlayerActions.clickNoTax();
        return false;
    }
}