package classes.tax;
import gameNav.Player;

/**
 * Not necessarily a tax, but if you borrow money from the bank, you pay it back.
 * For more debt, the tax rate increases by 5% until you paid off all your debt
 * @author Justin
 * @since 10/4/21
 * @category classes.tax
 */
public class DebtCollection extends Tax
{
    /**
     * How much is owed
     */
    private double owedAmt;

    /**
     * Constructs a debt collection. This starts off as 10% tax rate
     */
    public DebtCollection()
    {
        super(0.1, "Debt Collection");
        this.owedAmt = 0;
    }

    /**
     * Accessor method for owedAmt
     * @return this.owedAmt
     */
    public double getOwedAmt()
    {
        return this.owedAmt;
    }

    /**
     * Changes the amount owed.
     * You owe 1.5x the amount inputted
     * @param change The amount you're adding to the owed amt
     */
    public void changeOwedAmt(double change)
    {
        this.owedAmt += (change * 2);
    }

    /**
     * Enacts the debt collection tax.
     * Postcondition: Depending on how much money you repaid, you may be able to get rid of the debt collection
     */
    public void enact()
    {
        if (this.owedAmt == 0) return;
        double tax = Player.getCoin().calculatePrice() * this.getTaxRate();
        //System.out.println("Debt " + tax);
        Player.changeCash(tax * -1);

        this.owedAmt = Math.max(0, this.owedAmt - tax);
    }
}
