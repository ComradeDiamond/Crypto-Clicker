package frontend.statBar;

import gameNav.Player;
import gameNav.StatLabel;
import javax.swing.ImageIcon;

/**
 * Displays the actual, current price of the coin.
 * @author Justin
 * @since 4/13/21
 * @category frontend.statBar
 */
public class PriceDisplay extends DataDisplay
{
    /**
     * Why, just why
     */
    private static final long serialVersionUID = 0;

    /**
     * The image icon for stonks
     */
    private static ImageIcon stonks = new ImageIcon(new ImageIcon("images/Stonks.png").getImage().getScaledInstance(40, 49, 16));

    /**
     * The image icon for not stonks
     */
    private static ImageIcon stinks = new ImageIcon(new ImageIcon("images/Stinks.png").getImage().getScaledInstance(40, 49, 16));

    /**
     * Constructs a price display!
     */
    public PriceDisplay()
    {
        super(stonks, false);
        this.calibrate(false);
    }

    /**
     * Updates the priceDisplay with the current price of the coin.
     * This also sets the icon.
     * @param isStonks whether or not the coin price has risen. If it has, we put a stonk. If not, we put a stink.
     */
    public void calibrate(boolean isStonks)
    {
        ImageIcon icon = isStonks ? PriceDisplay.stonks : PriceDisplay.stinks;
        this.setIcon(icon);

        String txt = "$" + StatLabel.calibrate(Player.getCoin().getValue());

        this.setText(txt);
    }
}
