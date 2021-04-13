package frontend.statBar;
import javax.swing.JPanel;
import java.awt.FlowLayout;

/**
 * The statbar widget for the frontend
 * This displays stuff like item prices, gold prices, etc.
 * @author Justin
 * @since 4/12/21
 * @category frontend.statBar
 */
public class StatBar extends JPanel
{
    /**
     * Why does this exist? Why do I need one of these
     */
    private static final long serialVersionUID = 0;

    /**
     * The cash display that will display the cash
     */
    private CashDisplay cDisplay;

    /**
     * The investor display that will display the investors
     */
    private InvestorDisplay iDisplay;

    /**
     * The supply display that will display the supply
     */
    private SupplyDisplay sDisplay;

    /**
     * The value display that will display the value
     */
    private ValueDisplay vDisplay;

    /**
     * The price display that will display the price
     */
    private PriceDisplay pDisplay;;

    /**
     * Constructor for stat bar
     * How do you even comment frontend lmao
     */
    public StatBar()
    {
        super();
        this.setLayout(new FlowLayout());
        this.setBounds(0, 0, 800, 60);

        this.cDisplay = new CashDisplay();
    }

    /**
     * Accessor method for the cash display
     * @return this.cDisplay
     */
    public CashDisplay getCDS()
    {
        return this.cDisplay;
    }

    /**
     * Accessor method for the investor display
     * @return this.iDisplay
     */
    public InvestorDisplay getIDS()
    {
        return this.iDisplay;
    }

    /**
     * Accessor method for price display
     * @return this.pDisplay
     */
    public PriceDisplay getPDS()
    {
        return this.pDisplay;
    }

    /**
     * Accessor method for supply display
     * @return this.sDiplay
     */
    public SupplyDisplay getSDS()
    {
        return this.sDisplay;
    }

    /**
     * Accessor method for value display
     * @return this.vDisplay
     */
    public ValueDisplay getVDS()
    {
        return this.vDisplay;
    }
}
