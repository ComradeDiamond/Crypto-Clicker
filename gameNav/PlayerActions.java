package gameNav;
import java.util.ArrayList;

import classes.tax.Tax;
//import frontend.statBar.StatBar;
import frontend.choiceBar.displays.ProjectUpgrade;

/**
 * It's supposed to be game.java, but that doesn't rly exist in swing version.
 * So now we have the PlayerActions class.
 * This class will do all the clicking and taxes and stuff. Y' know, the fun stuff.
 * This class is static!!!
 * @author Justin
 * @since 4/13/21
 * @category gameNav
 */
public class PlayerActions 
{
    /**
     * This holds the task queues that we will execute from.
     * WILL NOT TRIGGER WITH AUTOCLICKER.
     */
    public static ArrayList<TimedCommand> taskQueue = new ArrayList<TimedCommand>();

    /**
     * Doing a little trolling
     * Ok ok we're actually stimulating a crypto coin click.
     * Note that coins also have their own seperate click function that will be called.
     * When you click, there's more things that happen that just a click that the coin itself doesn't manage.
     * This will also recalibrate projects.
     * Like taxes.
     * It'll loop through the taskQueue and then execute it while removing anything that comes down to 0
     * @see Coin.prototype.click
     */
    public static void click()
    {
        boolean continuePerforming = true;
        for (int i = taskQueue.size() - 1; i >= 0; i--)
        {
            TimedCommand cmd = PlayerActions.taskQueue.get(i);
            if (!cmd.execute())
            {
                continuePerforming = false;
            }

            if (cmd.runTimer())
            {
                PlayerActions.taskQueue.remove(i);
            }
        }

        if (!continuePerforming) return;

        //Income is basically just calculate price
        double initIncome = Player.getCoin().calculatePrice();
        double income = Player.getCoin().click();
        //System.out.println("income: " + income);

        PlayerActions.tax(income);
        Player.getGUI().getStatBar().updateDisplays(income > initIncome);
        ProjectUpgrade.recalibrateAll();
    }

    /**
     * Kinda self-explanatory, click with no tax and no recalibration
     * Also there was an attempt to write Japanese
     * Musou *no* Hitotachi intensifies
     */
    public static void clickNoTax()
    {
        double initIncome = Player.getCoin().calculatePrice();
        double income = Player.getCoin().click();

        Player.getGUI().getStatBar().updateDisplays(income > initIncome);
    }

    /**
     * Click, but it's for the autoclicker so people don't use it to recalibrate everything
     */
    public static void autoclick()
    {
        double initIncome = Player.getCoin().calculatePrice();
        double income = Player.getCoin().click();
        PlayerActions.tax(income);
        Player.getGUI().getStatBar().updateDisplays(income > initIncome);
    }

    /**
     * Taxes the player.
     * This will loop through all taxes the player has on them and slowly apply them all.
     * @param income The money the player made
     */
    public static void tax(double income)
    {
        for (Tax tax : Player.getTaxes())
        {
            tax.enact();
        }
    }
}
