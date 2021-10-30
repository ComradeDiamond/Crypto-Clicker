package frontend.statBar;

import gameNav.Player;
import gameNav.StatLabel;

/**
 * The class for displaying the coin supply in circulation.
 * @author Justin
 * @since 4/13/21
 * @category frontend.statbar
 */
public class SupplyDisplay extends DataDisplay
{
    /**
     * WHYYYY IS THIS A THING
     */
    private static final long serialVersionUID = 0;

    /**
     * Constructs a supply display
     */
    public SupplyDisplay()
    {
        super("/images/Bank.png", true, "How many coins are in supply. If you have dogecoins, this is going to be a nightmare.");
    }

    /**
     * Updates the supply display to the correct, up to date number
     */
    public void calibrate()
    {
        String text = "" + StatLabel.calibrateWhole(Player.getCoin().getSupply());
        this.setText(text);
    }
}
