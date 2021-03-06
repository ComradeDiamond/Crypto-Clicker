package frontend.statBar;

import gameNav.Player;
import gameNav.StatLabel;

/**
 * Frontend display class that displays the number of investors.
 * @author Justin
 * @since 4/13/21
 * @category frontend.statbar
 */
public class InvestorDisplay extends DataDisplay
{
    private static final long serialVersionUID = 0;

    /**
     * Constructs an investor display
     */
    public InvestorDisplay()
    {
        super("/images/Investor.png", true, "<html>This is how many investors you have. More investors means more profit.<br />" +
        "However also be warned that more investors also means more supply.</html>");
    }

    /**
     * Updates the investor display to show the correct number of investors
     */
    public void calibrate()
    {
        String txt = "" + StatLabel.calibrateWhole(Player.getCoin().getInvestors());
        this.setText(txt);
    }
}
