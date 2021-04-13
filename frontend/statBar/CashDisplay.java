package frontend.statBar;

import javax.swing.JLabel;
import gameNav.Player;
import gameNav.StatLabel;
import java.awt.Font;

/**
 * Display for the user's balance
 * @author Justin
 * @since 4/12/21
 * @category frontend.statBar
 */
public class CashDisplay extends JLabel
{
    private static final long serialVersionUID = 0;

    /**
     * Constructs a cash display
     */
    public CashDisplay()
    {
        super();
        this.calibrateCash();
        this.setVerticalTextPosition(JLabel.CENTER);
        this.setOpaque(true);
        this.setFont(new Font("Trebuchet ms", Font.PLAIN, 24));
        this.setHorizontalAlignment(JLabel.RIGHT);
    }

    /**
     * Sets the cash value display to the player's cash.
     * We need to deal with when the player gets a trillion bucks
     */
    public void calibrateCash()
    {
        String textDisplay = "💲 ";
        textDisplay += StatLabel.calibrate(Player.getCash());
        this.setText(textDisplay);
    }
}
