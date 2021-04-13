package gameNav;
import classes.coin.*;
import classes.tax.*;

/**
 * The overall player class that represents the player.
 * This stores all of the player's stats they need to keep track of.
 * The player class is static - anyone can access this. There's no point of making it an object lol
 * This itself does not compute anything - it's all outsourced to other classes
 * @author Justin
 * @since 4/12/21
 * @category gameNav
 */
public class Player 
{
    /**
     * The money you have
     */
    private static double cash = 0;

    /**
     * The current coin type you have
     */
    private static Coin currCoin = new Litecoin();

    /**
     * The coin index the current coinArr idx player is at in the coinArr
     * The array indexes represent "tiers" of crypto coins
     */
    private static int coinIdx = 0;

    /**
     * Array to keep track of the coin upgrades
     */
    private static Coin[] coinArr = {};

    /**
     * Array to keep track of the player's taxes
     */
    private static Tax[] taxArr = {};

    /**
     * Accessor method for Player.cash
     * @return Player.cash
     */
    public static double getCash()
    {
        return Player.cash;
    }

    /**
     * Changes the cash value by num
     * @param num num 😂 literally. That's what I mean.
     */
    public static void changeCash(double num)
    {
        Player.cash += num;
    }

    /**
     * Mutator method for Player.cash
     * @param num Number to set cash to
     */
    public static void setCash(double num)
    {
        Player.cash = num;
    }

    /**
     * Accessor method for this.coin
     * @return Player.currCoin
     */
    public static Coin getCoin()
    {
        return Player.currCoin;
    }

    /**
     * Returns the next coin in the coin index.
     * If there is no such coin, return null.
     * @return The next coin in the coinArr, if it exists
     */
    public static Coin nextCoin()
    {
        if (Player.coinIdx + 1 >= Player.coinArr.length) return null;
        return Player.coinArr[Player.coinIdx + 1];
    }

    /**
     * Upgrades the player's coins to the next tier
     */
    public static void upgradeCoin()
    {
        Player.currCoin = Player.nextCoin();
    }

    /**
     * Return the entire tax array!
     * @return Player.taxArr
     */
    public static Tax[] getTaxes()
    {
        return Player.taxArr;
    }
}