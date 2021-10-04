package classes.tax;

import gameNav.Player;

/**
 * If you have too much $, you get taxed
 * This class does NOT use the superclass tax rate attribute. It uses its own custom tax rate
 * @author Justin
 * @since 4/15/21
 * @category classes.tax
 */
public class WealthTax extends Tax
{
    /**
     * Tax bracket for 1Ms
     */
    private double mills;

    /**
     * Tax bracket for 1Bs
     */
    private double bills;

    /**
     * Tax bracket for 1Ts
     */
    private double trills;

    /**
     * > 1T
     */
    private double mores;

    /**
     * Constructs a wealth tax
     */
    public WealthTax()
    {
        super(0, "Wealth Tax");
        this.mills = 0.075;
        this.bills = 0.5;
        this.trills = 0.75;
        this.mores = 0.99;
    }

    /**
     * Changes the tax rate for wealth taxes.
     * Note that the wealth deductions here apply all across the board.
     * Not sure if this is the most efficient way, but primitive attributes are passed by value so :shrug:
     * @override Tax.prototype.changeTaxRate
     */
    public void changeTaxRate(double changeTaxRate)
    {
        if (this.mills - changeTaxRate >= 0)
        {
            this.mills -= changeTaxRate;
        }  

        if (this.bills - changeTaxRate >= 0)
        {
            this.bills -= changeTaxRate;
        }  

        if (this.trills - changeTaxRate >= 0)
        {
            this.trills -= changeTaxRate;
        } 

        if (this.mores - changeTaxRate >= 0)
        {
            this.mores -= changeTaxRate;
        }  
    }

    /**
     * Enacts the tax.
     * @override Tax.prototype.enact();
     */
    public void enact()
    {
        double cash = Player.getCash();
        if (cash < 1000000) return;
        double sum = 0;

        sum += calibrate(cash, 1000000) * this.mills;
        sum += calibrate(cash, 1000000000) * this.bills;
        sum += calibrate(cash, 1000000000000.0) * this.trills;
        sum += (cash - (cash % 1000000000000000.0)) * this.mores;

        System.out.println("Wealth " + sum);
        Player.changeCash(sum * -1);
    }

    /**
     * Trims off the excess numbers we don't need
     * @param num The number to calibrate
     * @param placeVal The place value to calibrate to
     */
    private double calibrate(double num, double placeVal)
    {
        return (num % (placeVal * 1000)) - (num % placeVal);
        //work on: flash crash potentially deleting too much $
    }
}
