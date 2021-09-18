package classes.projects;

import java.awt.Color;

import gameNav.Player;

/**
 * Computing power upgrade! 
 * This further solidifies crypto as a function of computing time. 
 * Since crypto is a means of exchanging computing time, CPU enhancements increase the base value.
 * @author Justin
 * @since 9/17/21
 */
public class CPUpgrade extends Project
{
    /**
     * Constructs a CPUgrade object
     */
    public CPUpgrade()
    {
        super("Computing Optimization", "Heavy investments in CPU optimization enhances your cryptocurrency's means of exchanging computing power.",
        100, 1, "images/GamerGirl.jpg", Color.YELLOW);
    }

    /**
     * The price of computing optimizations increase exponentially. 
     * But that might be worth it as the crypto returns also increase exponentially.
     * @return Current cost to update crypto
     */
    public double calculateCost()
    {
        return Player.getCoin().getUnlockPrice() * Math.pow(2, Player.getCoin().getUpdate());
        //return Math.pow(Player.getCoin().getUnlockPrice(), Player.getCoin().getUpdate() + 1);
    }

    /**
     * Recalibrates the numClicked, or in other words, resets that thing. 
     * There's a 5% chance
     * @return whether or not the calibration is 0
     */
    public boolean recalibrate()
    {
        if ((int)(Math.random() * 20) == 2)
        {
            this.numClicked = 0;
            return true;
        }

        return false;
    }

    /**
     * COIN GOES STONKS
     * You'll always get at least 35% increase in coin value
     */
    public void initiate()
    {
        if (!this.canClick()) return;
        double val = Player.getCoin().getValue() * (1 + Math.max(0.35, Math.random()));
        Player.getCoin().noteUpdate();
        Player.getCoin().setValue(val);
    }
}
