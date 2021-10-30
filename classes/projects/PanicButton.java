package classes.projects;

import java.awt.Color;
import gameNav.*;

public class PanicButton extends Project
{
    public PanicButton()
    {
        super("Panic Button", "Are the stock markets going out of control? Is Gamestop down 500%? Hit the panic button to freeze the current price!", 
            3000, 1, "/images/PanicButton.png", Color.RED);
    }

    public double calculateCost()
    {
        return Math.max(this.cost, Player.getCash() * .78);
    }

    /**
     * 1% chance to recalibrate
     */
    public boolean recalibrate()
    {
        boolean yet = (int)(Math.random() * 100) == 5;
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

    public void initiate()
    {
        if (Player.getCoin().getName().equals("Dogecoin!!!"))
        {
            PlayerActions.taskQueue.add(new PriceControl());
        }
    }
}

class PriceControl extends TimedCommand
{
    public PriceControl()
    {
        super(20);
        Player.getCoin().setForcedPrice(Player.getCoin().calculatePrice());
    }

    /**
     * @return continue
     */
    public boolean execute()
    {
        if (this.getTimer() == 1)
        {
            Player.getCoin().setForcedPrice(-1);
        }
        return true;
    }
}