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
     * If spiff exploited dogecoin
     */
    private boolean corruptCoin;

    /**
     * Divide doge supply and investors by this
     */
    private int mechanics;

    /**
     * Constructs everyone's favorite coin!
     */
    public Dogecoin()
    {
        super("Dogecoin!!!", 0.0000000001, 10000, "images/Dogecoin.png", 100000000,
            "A coin that has absolutely no hard limits on supply and is insanely easy to mine. What's a safe investment? Researching the doge coin officially unlocks the Tech Tree.");
        this.corruptCoin = false;
        this.mechanics = 1;
        this.modify = 0.1;
    }

    /**
     * Custom Dogecoin price calculation - because it's a volatile coin lol
     * @return Stonk price of the coin
     */
    public double calculatePrice()
    {
        if (this.forcedPrice != -1) return this.forcedPrice;
        double typ = (this.value * (this.investors * 0.15) + 1) / Math.max(1, (double)this.supply / 600 + 1 - (this.value / 100));
        return typ + this.modify;
    }

    /**
     * Custom doge influence calculation.
     * Dogecoin influence is determined a lot by clout o.o
     * Hence, we will determine dogecoin prices by listening to Elon Musk.
     * BUT remember negative clout damages dogecoin costs
     */
    public void influenceCalc()
    {
        if (this.corruptCoin)
        {
            this.corruptInfluenceCalc();
        }
        else
        {
            int cloutFrenzy = (int)this.getModify() * (int)(Math.random() * 10);
            int frenzy = (int)this.calculatePrice() * 10 + 1 + cloutFrenzy;
            int negPlus = (int) (Math.random() * 6);
            int infl = negPlus == 0 ? (int)(Math.random() * 5) * frenzy * -1 : (int)(Math.random() * 5) * frenzy;
            this.investors = Math.max(0, this.investors + infl) / this.mechanics;

            if (negPlus == 0)
            {
                this.supply = Math.max(0, this.supply - (int)(this.supply * 0.1 * Math.random()));
            }
            else
            {
                this.supply += (int)(this.investors * Math.random() * 15) / this.mechanics;
            }
        }
    }

    /**
     * Mutator for this.mechanics
     * @param mechanics New mechanics value
     */
    public void setMechanics(int mechanics)
    {
        this.mechanics = mechanics;
    }

    /**
     * Corrupted influence calc that uses their own weird algorithm
     */
    public void corruptInfluenceCalc()
    {
        int cloutFrenzy = (int)this.getModify() * (int)(Math.random() * 100);
        int frenzy = (int)this.calculatePrice() * 10 + 1 + cloutFrenzy;
        int negPlus = (int) (Math.random() * 6);
        int infl = negPlus == 0 ? (int)(Math.random() * 5) * frenzy * -1 : (int)(Math.random() * 5) * frenzy;
        this.supply = Math.max(0, this.investors + infl) / this.mechanics;

        if (negPlus == 0)
        {
            this.investors = Math.max(0, this.supply - (int)(this.supply * 0.1 * Math.random()));
        }
        else
        {
            this.investors += (int)(this.supply * Math.random() * 15) / this.mechanics;
        }
    }

    /**
     * Mutator method for this.corruptCoin
     * @param corrupted Whether to run corrupt algorithm
     */
    public void setCorrupted(boolean corrupted)
    {
        this.corruptCoin = corrupted;
    }
}
