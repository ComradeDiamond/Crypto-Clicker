package frontend.statBar;

import javax.swing.JLabel;
import gameNav.Player;
import gameNav.StatLabel;
import java.awt.Font;

/**
 * Frontend display class that displays the number of investors.
 * @author Justin
 * @since 4/13/21
 * @category frontend.statbar
 */
public class InvestorDisplay extends JLabel
{
    private static final long serialVersionUID = 0;

    /**
     * Constructs an investor display
     */
    public InvestorDisplay()
    {
        super();
        this.calibrateInvestors();
        this.setVerticalTextPosition(JLabel.CENTER);
        this.setOpaque(true);
        this.setFont(new Font("Trebuchet ms", Font.PLAIN, 24));
    }

    /**
     * Updates the investor display to show the correct number of investors
     */
    public void calibrateInvestors()
    {
        String txt = "👨‍💻 " + StatLabel.calibrate(Player.getCoin().getInvestors());
        this.setText(txt);
    }
}
