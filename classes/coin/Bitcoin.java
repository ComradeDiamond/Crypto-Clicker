package classes.coin;

import gameNav.Player;

/**
 * Who uses bitcoins anymore lmao
 * Honestly tho this is what tryhards use to invest
 * @author Justin
 * @since 4/12/21
 * @category classes.coin
 */
public class Bitcoin extends Coin
{
    /**
     * Bitcoin tax rate
     */
    private double taxRate;
    
    /**
     * Constructs le bitcoin
     */
    public Bitcoin()
    {
        super("Bitcoin", 150, 300, "images/Bitcoin.png", 1000, 
            "The most stable, default, and practical cryptocurrency used in a myriad of exchanges. Oh yea and Bitcoin INC charges a 20% transaction fee but whatever.");
        this.taxRate = 0.2;
    }

    /**
     * Overrides the click from Coin.java.
     * However, Bitcoins are heavily taxed. So be aware of that.
     * You might go into negative balance if the government taxes too much.
     * @return The $ you earned.
     */
    public double click()
    {
        Player.changeCash(this.calculatePrice() * this.taxRate * -1);
        return super.click();
    }

    /**
     * Changes the bitcoin tax rate
     * @param modify The amount of $ to modify here
     */
    public void changeTaxRate(double modify)
    {
        this.taxRate += modify;
    }
}