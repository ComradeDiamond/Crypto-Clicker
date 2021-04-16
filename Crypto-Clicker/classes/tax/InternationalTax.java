package classes.tax;

import gameNav.Player;

/**
 * Crypto operations happen worldwide!
 * So every income you make are also subject to international tax.
 * @author Justin
 * @since 4/15/21
 * @category classes.tax
 */
public class InternationalTax extends Tax
{
    /**
     * Constructs an international tax
     */
    public InternationalTax()
    {
        super(0.2, "International Tax");
    }

    /**
     * Enacts the international tax on your profit.
     * @override Tax.prototype.enact()
     */
    public void enact()
    {
        double tax = Player.getCoin().calculatePrice() * this.getTaxRate();
        //System.out.println(tax);
        Player.changeCash(tax * -1);
    }
}
