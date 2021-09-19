package classes.tax;

import gameNav.Player;

/**
 * You get taxed based on the true value of your coin.
 * @author Justin
 * @since 4/15/21
 * @category Justin
 */
public class CapitalGainsTax extends Tax
{
    /**
     * Constructs a capital gains tax
     */
    public CapitalGainsTax()
    {
        super(0.25, "Capital Gains Tax");
    }

    /**
     * Enacts the capital gains tax!
     * @override Tax.prototype.enact()
     */
    public void enact()
    {
        if (Player.getCash() > 5000)
        {
            double tax = Player.getCoin().calculatePrice() * -1 * this.getTaxRate();
            Player.changeCash(tax);
            //System.out.println(tax);
        }
    }
}
