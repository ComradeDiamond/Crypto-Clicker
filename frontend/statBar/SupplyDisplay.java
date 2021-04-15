package frontend.statBar;

import gameNav.Player;
import gameNav.StatLabel;
import javax.swing.ImageIcon;

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
        super(new ImageIcon("images/Bank.png"), true);
    }

    /**
     * Updates the supply display to the correct, up to date number
     */
    public void calibrate()
    {
        String text = "" + StatLabel.calibrate(Player.getCoin().getSupply());
        this.setText(text);
    }
}
