package classes.projects;

import java.awt.Color;

import gameNav.Player;

/**
 * What happens when the stock prices dip?
 * You trade Forex!
 * @author Justin
 * @since 9/18/21
 * @category classes.projects
 */
public class Forex extends Project
{
    /**
     * The maximum percent of Forex you can trade
     */
    private double maxPercent;

    /**
     * Forex discount
     */
    private double discount;

    /**
     * Constructs a ForEx object
     */
    public Forex()
    {
        super("FOREX", "What happens when your stock prices drop into oblivion? Listen to apes and buy the dip! Increases ForEx trading capacity by 5%.",
        500, 2, "images/ForEx.png", Color.ORANGE);

        this.maxPercent = 0.25;
        this.discount = 0;
    }

    /**
     * Calculates the cost of trading forex.
     * The amount is dependent on how much your currency is worth right now.
     */
    public double calculateCost()
    {
        /*int requiem = (int)(this.maxPercent * Player.getCoin().getSupply());
        return requiem * Player.getCoin().calculatePrice() * (1 - Math.max(discount, .8));*/
        return 0;
    }

    /**
     * Initiates a ForEx trade. 
     * Increases maximum % of Forex you can trade by 5% OR if it's max, grant 1% discount.
     */
    public void initiate()
    {
        int tfp = Player.getCoin().getSupply();
        Player.getCoin().setSupply((int)(tfp * (1 - this.maxPercent)));

        if (this.maxPercent < 1)
        {
            this.maxPercent += 0.05;
        }
        else
        {
            this.discount += 0.01;
        }
    }

    /**
     * There's a 2.5% chance you could trade ForEx again
     * @return whether or not this is recalibrated
     */
    public boolean recalibrate()
    {
        if ((int)(Math.random() * 40) == 5) 
        {
            this.numClicked = 0;
        }

        return this.numClicked == 0;
    }
}
