package classes.tax;

/**
 * Uncle Sam needs his money to fund more stuff.
 * There are different taxes levied on your coin mining.
 * @author Justin
 * @since 4/12/21
 * @category classes.tax
 */
public class Tax 
{
    /**
     * The tax rate, expressed as a decimal
     */
    private double taxRate;

    /**
     * Name of the tax
     */
    private String name;

    public Tax(double taxRate, String name)
    {
        this.taxRate = taxRate;
    }

    /**
     * Mutator method for tax rates
     * @param taxRate The rate to set taxes to
     */
    public void setTaxRate(double taxRate)
    {
        this.taxRate = taxRate;
    }

    /**
     * Changes the tax rate.
     * @param taxRateChange The change, in decimal number, to the tax rate
     */
    public void changeTaxRate(double taxRateChange)
    {
        this.taxRate += taxRateChange;
    }

    /**
     * Accessor method for tax rate
     * @return this.taxRate
     */
    public double getTaxRate()
    {
        return this.taxRate;
    }

    /**
     * Gets the name of the tax. Accessor method basically.
     * @return this.name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Superclass/abstract method? for enacting taxes.
     * This method will apply the tax to the player.
     * Each tax has different conditions.
     */
    public void enact()
    {
    }
}
