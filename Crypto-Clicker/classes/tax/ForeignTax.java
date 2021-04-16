package classes.tax;

import gameNav.Player;

/**
 * For now, the foreign tax is useless.
 * It'll come in handy when we add offshore tax havens.
 * This is the gubbermint's last attempt at taxing you, although foreign tax is significantly lower.
 * @author Justin
 * @since 4/15/21
 * @category classes.tax
 */
public class ForeignTax extends Tax
{
    /**
     * Constructs a foreign tax. It's 0% for now.
     */
    public ForeignTax()
    {
        super(0, "Foreign Tax");
    }

    /**
     * Enacts the foreign tax.
     * This will be set to 10%.
     * Which is still alot of tax.
     */
    public void enact()
    {
        double tax = Player.getCoin().calculatePrice() * this.getTaxRate() * -1;
        //System.out.println(tax);
        Player.changeCash(tax * -1);
    }
}
