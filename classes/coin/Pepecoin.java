package classes.coin;

/**
 * Buy this at dank memer store for $1 Million lmao
 * This crytocurrency is very hard to mine, but it is worth a LOT of money.
 * @author Justin
 * @since 4/12/21
 * @category classes.coin
 */
public class Pepecoin extends Coin
{
    /**
     * Constructs a pepecoin
     */
    public Pepecoin()
    {
        super("Pepecoin", 1000, 0, "images/Pepecoin.png", 1000000,
            "An insanely valuable crypto coin which derives its value from the web traffic of Dank Memer Bot. Insanely profitable - if it wasn't for the fact that Dank Memer is dying after the owner gave up and the fact you only have a 10% chance of beating quantum computers mines.");
    }

    /**
     * Overrides the click from Coin.java
     * You only have a 10% chance of mining pepeCoins.
     * @return The price you got from mining pepecoin
     */
    public double click()
    {
        if ((int)(Math.random() * 10) == 0)
        {
            return super.click();
        }

        return 0;
    }
}
