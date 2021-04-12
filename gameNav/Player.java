package gameNav;
import classes.coin.*;

/**
 * The overall player class that represents the player.
 * This stores all of the player's stats they need to keep track of
 * @author Justin
 * @since 4/12/21
 * @category gameNav
 */
public class Player 
{
    /**
     * The money you have
     */
    private double cash;

    /**
     * The current coin type you have
     */
    private Coin currCoin;

    /**
     * Constructs a player class
     */
    public Player()
    {
        this.cash = 0;
        this.currCoin = new Litecoin();
    }
}
