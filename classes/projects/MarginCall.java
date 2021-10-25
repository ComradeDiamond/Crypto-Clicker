package classes.projects;

import java.awt.Color;

import gameNav.Player;

/**
 * Loan some money from the bank in a margin call!
 * @author Justin
 * @since 10/24/21
 * @category classes.projects
 */
public class MarginCall extends Project
{
    private int maxLoan;

    public MarginCall()
    {
        super("Margin Call", "Need money to fund new projects? Need a cash injection to grab that new Ninja Monkey Paragon? Get a loan from the bank! Increases your maximum loan amount by 500%.", 
        0, 2, "Images/MarginCall.png", new Color(255, 237, 79));

        maxLoan = 1000;
    }

    /**
     * Triggers debt collection, calibrates max loans by a factor of 5, and gives you a cash injection.
     */
    public void initiate()
    {
        Player.changeCash(this.maxLoan);
        Player.getDebtCollection().changeOwedAmt(this.maxLoan);
        this.maxLoan *= 5;
    }

    /**
     * @return Whether the current $ is doge or pepe
     */
    public boolean determineDisplay()
    {
        return Player.getCoin().getName().equalsIgnoreCase("Pepecoin") || Player.getCoin().getName().equalsIgnoreCase("Dogecoin!!!"); 
    }

    /**
     * 5/40 chance of recalibrating the loan. Since there's two charges, the loan recalibrates by 1 loan charge.
     */
    public boolean recalibrate()
    {
        boolean recalibrated = (int)(Math.random() * 40) == 5;
        if (recalibrated)
        {
            this.numClicked = Math.max(0, this.numClicked - 1);
        }
        return recalibrated;
    }
}
