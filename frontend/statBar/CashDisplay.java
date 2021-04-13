package frontend.statBar;

import javax.swing.JLabel;
import gameNav.Player;

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
    }

    /**
     * Sets the cash value display to the player's cash.
     * We need to deal with when the player gets a trillion bucks
     */
    public void calibrateCash()
    {
        String textDisplay = "💲 ";
        double num = Player.getCash();

        if (num < 1000)
        {
            textDisplay += num;
        }
        else if (num < 1000000) //Thousand
        {
            textDisplay += roundFix(num, 1000) + "K";
        }
        else if (num < 1000000000) //Million
        {
            textDisplay += roundFix(num, 1000000) + "M";
        }
        else if (num < 1000000000000.0) //Billion
        {
            textDisplay += roundFix(num, 1000000000) + "B";
        }
        else if (num < 1000000000000000.0) //Trillion
        {
            textDisplay += roundFix(num, 1000000000000.0) + "T";
        }
        else //Quadrillion, if someone somehow manages to get to quadrillion
        {
            textDisplay += roundFix(num, 1000000000000000000.0) + " Quadrillion";
        }
    }

    /**
     * Collapses a number to its place value + 2 decimal points
     * For example, 3,456 becomes 3.45
     * 442,123 becomes 442.12
     * @param num Number
     * @param placeVal Place value to round to
     * @return Rounded number
     */
    private double roundFix(double num, double placeVal)
    {
        return num / placeVal - (num % (placeVal / 100)) / (placeVal);
    }
}
