package frontend.statBar;

import javax.swing.ImageIcon;
import gameNav.Player;
import gameNav.StatLabel;

/**
 * Display for the user's balance
 * @author Justin
 * @since 4/12/21
 * @category frontend.statBar
 */
public class CashDisplay extends DataDisplay
{
    private static final long serialVersionUID = 0;

    /**
     * Constructs a cash display
     */
    public CashDisplay()
    {
        super(new ImageIcon("Money.png"), true);
    }

    /**
     * Sets the cash value display to the player's cash.
     * We need to deal with when the player gets a trillion bucks
     */
    public void calibrate()
    {
        String textDisplay = "<html>💲 ";
        textDisplay += StatLabel.calibrate(Player.getCash());
        this.setText(textDisplay);
    }
}
