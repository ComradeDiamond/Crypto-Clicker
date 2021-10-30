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
        super("Dogecoin!!!", 0.1, 10000, "/images/Dogecoin.png", 100000000,
            "A coin that has absolutely no hard limits on supply and is insanely easy to mine. What's a safe investment? Researching the doge coin officially allows overflow investors to decrease supply.");
        this.corruptCoin = false;
        this.mechanics = 1;
        this.modify = 0.1;
    }

    public double calculatePrice()
    {
        if (this.forcedPrice != -1) return this.forcedPrice;
        double typ = (this.value * (this.investors * 0.5) + 1) / Math.max(1, Math.pow(this.supply, Math.max(0.8, Math.random() + 0.5)));
        double surprise = Math.random() * 2.5 + 0.25;
        return (typ) * surprise + modify;
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
            int cloutFrenzy = (int)Math.pow(this.getModify(), Math.random() / 2 + 1);;
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
                this.supply += (int)((Math.sqrt(this.investors) + 1) * Math.random() * (Math.sqrt(this.supply) + 1)) / this.mechanics;
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
        int cloutFrenzy = (int)this.getModify() * (int)(Math.random() * 10);
        int frenzy = (int)this.calculatePrice() * (10 + 1 + cloutFrenzy);
        int negPlus = (int) (Math.random() * 10);
        int infl = negPlus == 0 ? (int)(Math.random() * 5) * frenzy * -1 : (int)(Math.random() * 5) * frenzy;
        this.supply = Math.max(0, this.supply + infl) / this.mechanics;

        if (negPlus == 0)
        {
            this.investors = Math.max(0, this.investors - (int)(this.investors * 0.1 * Math.random()));
        }
        else
        {
            this.investors += (int)((Math.sqrt(this.supply) + 1) * Math.random() * (Math.sqrt(this.investors) + 1)) / this.mechanics;
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
