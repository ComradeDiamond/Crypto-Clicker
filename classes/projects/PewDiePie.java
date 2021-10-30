package classes.projects;

import java.awt.Color;

import classes.coin.Dogecoin;
import gameNav.*;

/**
 * Have PewDiePie drop his diss track
 * @author Justin
 * @since 10/27/21
 * @category classes.projects
 */
public class PewDiePie extends Project
{
    public PewDiePie()
    {
        super("PewDiePie", "Contract PewDiePie and have him drop the T-Series diss track! Diverts attention from Dogecoin hype and halves your investor and supply accumulation.", 
            5000, 1, "/images/PewDiePie.jpg", Color.PINK);
    }

    public double calculateCost()
    {
        return Math.max(5000, 0.2 * Player.getCash());
    }

    /*
     * @return Whether it's dogecoin
    */
    public boolean determineDisplay()
    {
        return Player.getCoin().getName().equals("Dogecoin!!!");
    }

    /**
     * 2% chance
     */
    public boolean recalibrate()
    {
        boolean booldet = (int)(Math.random() * 50) == 5;
        if (booldet)
        {
            this.numClicked = 0;
        }
        return booldet;
    }

    public void initiate()
    {
        PlayerActions.taskQueue.add(new Pewds());
    }
}

/**
 * Precondition to class: this is dogecoin - which it is
 */
class Pewds extends TimedCommand
{
    public Pewds()
    {
        super(10);
        ((Dogecoin)Player.getCoin()).setMechanics(2);
    }

    /**
     * Continue to run
     */
    public boolean execute()
    {
        if (Player.getCoin().getName().equals("Dogecoin!!!"))
        {
            ((Dogecoin)Player.getCoin()).setMechanics(1);
        }

        return true;
    }
}