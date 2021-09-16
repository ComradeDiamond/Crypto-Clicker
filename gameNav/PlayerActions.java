package gameNav;
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
     * Doing a little trolling
     * Ok ok we're actually stimulating a crypto coin click.
     * Note that coins also have their own seperate click function that will be called.
     * When you click, there's more things that happen that just a click that the coin itself doesn't manage.
     * This will also recalibrate projects.
     * Like taxes
     * @see Coin.prototype.click
     */
    public static void click()
    {
        //Income is basically just calculate price
        double initIncome = Player.getCoin().calculatePrice();
        double income = Player.getCoin().click();

        PlayerActions.tax(income);
        Player.getGUI().getStatBar().updateDisplays(income > initIncome);
        ProjectUpgrade.recalibrateAll();
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
