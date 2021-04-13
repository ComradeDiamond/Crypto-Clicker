package frontend.statBar;

import javax.swing.JLabel;
import gameNav.Player;
import gameNav.StatLabel;
import java.awt.Font;

/**
 * Displays the actual, current price of the coin.
 * @author Justin
 * @since 4/13/21
 * @category frontend.statBar
 */
public class PriceDisplay extends JLabel
{
    /**
     * Why, just why
     */
    private static final long serialVersionUID = 0;

    /**
     * Constructs a price display!
     */
    public PriceDisplay()
    {
        super();
        this.calibratePrice(false);
        this.setVerticalTextPosition(JLabel.CENTER);
        this.setOpaque(true);
        this.setFont(new Font("Trebuchet ms", Font.PLAIN, 24));
        this.setHorizontalAlignment(JLabel.RIGHT);
    }

    /**
     * Updates the priceDisplay with the current price of the coin
     * @param isStonks whether or not the coin price has risen. If it has, we put a stonk. If not, we put a stink.
     */
    public void calibratePrice(boolean isStonks)
    {
        String txt = isStonks ? "📈 " : "📉 ";
        txt += StatLabel.calibrate(Player.getCoin().getValue());

        this.setText(txt);
    }
}
