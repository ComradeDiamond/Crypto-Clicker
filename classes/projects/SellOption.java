package classes.projects;

import java.awt.Color;

import gameNav.Player;

/**
 * Sell your future clicks 
 * @author Justin 
 * @since 10/24/21
 * @category classes.project
 */
public class SellOption extends Project
{
    public SellOption()
    {
        super("Sell Option", "Are you tired of #HODL-ing on to your falling crypto coins? Sell them to investors! You'll get a random multiplier from your current stock value, but the supply might just skyrocket...", 
        0, 1, "/images/SellOption.png", Color.CYAN);
    }

    /**
     * 2% chance of recalibrating a sell option because they're that rare.
     * @return Will this recalibrate?
     */
    public boolean recalibrate()
    {
        boolean willFix = (int)(Math.random() * 50) == 4;
        if (willFix)
        {
            this.numClicked = 0;
        }

        return willFix;
    }

    /**
     * Gives you a cash injection and changes the supply
     */
    public void initiate()
    {
        int multiplier = (int)(Math.random() * 20) + 10;
        double cashInjection = Player.getCoin().calculatePrice() * multiplier;
        Player.getCoin().changeSupply(Player.getCoin().getInvestors() * multiplier * 3);
        Player.changeCash(cashInjection, true);
    }

    /**
     * @return Whether it's dogecoin or pepecoin
     */
    public boolean determineDisplay()
    {
        String coinName = Player.getCoin().getName();
        return coinName.equals("Pepecoin") || coinName.equals("Dogecoin!!!");
    }
}