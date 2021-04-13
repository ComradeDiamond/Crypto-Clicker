package frontend.statBar;

import java.awt.Font;
import javax.swing.JLabel;
import gameNav.Player;
import gameNav.StatLabel;

/**
 * Displays the true value of a coin as of speaking.
 * @author Justin
 * @since 4/13/21
 * @category frontend.statBar
 */
public class ValueDisplay extends JLabel
{
    private static final long serialVersionUID = 0;

    /**
     * Constructs a value display
     */
    public ValueDisplay()
    {
        super();
        this.calibrateValue();
        this.setVerticalTextPosition(JLabel.CENTER);
        this.setOpaque(true);
        this.setFont(new Font("Trebuchet ms", Font.PLAIN, 24));
        this.setHorizontalAlignment(JLabel.RIGHT);
    }

    /**
     * Updates the display with the true value of the crypto coin
     */
    public void calibrateValue()
    {
        String text = "📊 " + StatLabel.calibrate(Player.getCoin().getValue());
        this.setText(text);
    }
}
