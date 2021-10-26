package classes.coin;

/**
 * The best coin out there!
 * This cryptocurrency is so easy to mine that it's actively deflating.
 * But at least you get Elon Musk.
 * @author Justin
 * @since 4/12/21
 * @category classes.coin
 */
public class Dogecoin extends Coin
{
    /**
     * Constructs everyone's favorite coin!
     */
    public Dogecoin()
    {
        super("Dogecoin!!!", 0.0000000001, 10000, "images/Dogecoin.png", 100000000,
            "A coin that has absolutely no hard limits on supply and no inflation control measures. What's a safe investment? Researching the doge coin officially unlocks the Tech Tree.");
    }
}
