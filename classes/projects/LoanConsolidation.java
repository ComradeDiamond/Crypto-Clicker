package classes.projects;

import java.awt.Color;
import gameNav.Player;

/**
 * Consolidate all loans! Also this slaps a debt collection tax on you
 * @author Justin
 * @since 10/24/21
 * @category classes.projects
 */
public class LoanConsolidation extends Project
{
    public LoanConsolidation()
    {
        super("Loan Consolidation", "As your YOLO your entire life savings, the banks decide you are too big to fail. Reluctantly, they offer you a loan consolidation for 2x of your current debt with a 10% tax every time you click.",
        0, 1, "/images/LoanConsolidate.png", Color.PINK);
    }

    /**
     * There's a 10% chance ot wiping out the numClicked
     * @return If it recalibrated
     */
    public boolean recalibrate()
    {
        boolean x = (int)(Math.random() * 10) == 0;
        if (x) this.numClicked = 0;

        return x;
    }

    /**
     * @return If you're broke and have < 50,000
     */
    public boolean canClick()
    {
        return super.canClick() && Player.getCash() < 50000;
    }

    public boolean determineDisplay()
    {
        return Player.getCash() < -50000;
    }
    
    /**
     * Sets the bank balance to $0.
     * Starts up debt collection
     */
    public void initiate()
    {
        double cashew = Player.getCash();
        Player.setCash(0);
        Player.getDebtCollection().changeOwedAmt(-1 * cashew);
    }
}
