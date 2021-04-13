package frontend.statBar;

import javax.swing.JLabel;
import gameNav.Player;
import gameNav.StatLabel;
import java.awt.Font;

/**
 * The class for displaying the coin supply in circulation.
 * @author Justin
 * @since 4/13/21
 * @category frontend.statbar
 */
public class SupplyDisplay extends JLabel
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
        super();
        this.calibrateSupply();
        this.setVerticalTextPosition(JLabel.CENTER);
        this.setOpaque(true);
        this.setFont(new Font("Trebuchet ms", Font.PLAIN, 24));
    }

    /**
     * Updates the supply display to the correct, up to date number
     */
    public void calibrateSupply()
    {
        String text = "🏦 " + StatLabel.calibrate(Player.getCoin().getSupply());
        this.setText(text);
    }
}
