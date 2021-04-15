package classes.tax;
import gameNav.Player;

/**
 * Income tax
 * This tax is levied on your income!
 * It starts as a flat tax on everything. It starts off at 55%.
 * This tax isn't progressive, so it's easy to slash it.
 * @author Justin
 * @since 4/15/21
 * @category classes.tax
 */
public class IncomeTax extends Tax
{
    /**
     * Constructs an instance of income tax
     */
    public IncomeTax()
    {
        super(0.55, "Income Tax");
    }

    /**
     * Enacts the income tax.
     * Since price of coin == how many $ player makes, we just tax the coin value
     * @override Tax.prototype.enact
     */
    public void enact()
    {
        double tax = Player.getCoin().calculatePrice() * this.getTaxRate();
        //System.out.println(tax);
        Player.changeCash(tax * -1);
    }
}
