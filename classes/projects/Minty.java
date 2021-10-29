package classes.projects;

import java.awt.Color;

import classes.coin.Dogecoin;
import gameNav.Player;

public class Minty extends Project
{
    public Minty()
    {
        super("Minty", "After defying the monarchy of Lord Spiff by setting up an illegal trading company, Minty now continues to steal competition ... for a price.", 
            5000, 1, "Images/Minty.png", Color.RED);
    }   

    public double calculateCost()
    {
        return Math.max(5000, Player.getCash() * 0.15);
    }
    
    /** 
     * @return Whether it's dogecoin
     */
    public boolean determineDisplay()
    {
        return Player.getCoin().getName().equals("Dogecoin!!!");
    }

    /**
     * 3% chance to minty
     */
    public boolean recalibrate()
    {
        boolean yet = (int)(Math.random() * 33) == 5;
        if (yet)
        {
            this.numClicked = 0;
        }

        return yet;
    }

    public void initiate()
    {
        if (Player.getCoin().getName().equals("Dogecoin!!!"))
        {
            Player.getCoin().changeModify(1);
            int currSupply = Player.getCoin().getSupply();
            Player.getCoin().setSupply(currSupply / (int)(Math.log(currSupply) + 1));
        }
    }
}
