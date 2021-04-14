package frontend.statBar;

import javax.swing.ImageIcon;
import gameNav.Player;
import gameNav.StatLabel;

/**
 * Displays the true value of a coin as of speaking.
 * @author Justin
 * @since 4/13/21
 * @category frontend.statBar
 */
public class ValueDisplay extends DataDisplay
{
    /**
     * Must put or vsc will throw error
     */
    private static final long serialVersionUID = 0;

    /**
     * Constructs a value display
     */
    public ValueDisplay()
    {
        super(new ImageIcon("images/Value.png"), true);
    }

    /**
     * Updates the display with the true value of the crypto coin
     */
    public void calibrate()
    {
        String text = "$" + StatLabel.calibrate(Player.getCoin().getValue());
        this.setText(text);
    }
}
