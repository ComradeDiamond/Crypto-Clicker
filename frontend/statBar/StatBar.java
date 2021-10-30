package frontend.statBar;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;

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
    private PriceDisplay pDisplay;

    /**
     * Constructor for stat bar
     * How do you even comment frontend lmao
     */
    public StatBar()
    {
        super();
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 10));
        //this.setPreferredSize(new Dimension(1200, 110));
        this.setBounds(0, 0, 1200, 110);
        this.setBackground(new Color(244, 244, 244));

        //Setting the displays and putting them in
        this.cDisplay = new CashDisplay();
        this.vDisplay = new ValueDisplay();
        this.iDisplay = new InvestorDisplay();
        this.pDisplay = new PriceDisplay();
        this.sDisplay = new SupplyDisplay();

        this.add(new Title());
        this.add(this.cDisplay);
        this.add(this.pDisplay);
        this.add(this.vDisplay);
        this.add(this.sDisplay);
        this.add(this.iDisplay);
    }

    /**
     * Switch all the frontend styles to the doge
     */
    public void switchDoge()
    {
        this.vDisplay.setForeground(Color.WHITE);
        this.cDisplay.setForeground(Color.WHITE);
        this.pDisplay.setForeground(Color.WHITE);
        this.sDisplay.setForeground(Color.WHITE);
        this.iDisplay.setForeground(Color.WHITE);
        this.setBackground(new Color(19,36,76));
        this.revalidate();
        this.repaint();
    }

    public void switchPepe()
    {
        this.vDisplay.setForeground(Color.WHITE);
        this.cDisplay.setForeground(Color.WHITE);
        this.pDisplay.setForeground(Color.WHITE);
        this.sDisplay.setForeground(Color.WHITE);
        this.iDisplay.setForeground(Color.WHITE);
        this.setBackground(new Color(130, 12, 173));
        this.revalidate();
        this.repaint();
    }

    public void switchBit()
    {
        //this.setBackground(new Color(252, 207, 3));
        this.setBackground(new Color(207, 175, 19));
        this.revalidate();
        this.repaint();
    }

    /**
     * Automatically calls calibrate on all the statbar widget displays.
     * @param isStonks Whether the price of the coin has increased or not
     */
    public void updateDisplays(boolean isStonks)
    {
        this.cDisplay.calibrate();
        this.iDisplay.calibrate();
        this.vDisplay.calibrate();
        this.pDisplay.calibrate(isStonks);
        this.sDisplay.calibrate();
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
