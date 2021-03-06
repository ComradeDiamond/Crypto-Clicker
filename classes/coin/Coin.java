package classes.coin;

import gameNav.Player;

/**
 * The superclass of all coins you click on.
 * This will literally represent a coin.
 * Now I'm broke
 * @author Justin
 * @category classes.coin
 * @since 4/12/21
 */
public class Coin {
    /**
     * Innate/Starting value of a coin.
     * Basically how much the coin is actually worth
     */
    protected double value;

    /**
     * How many investors are investing in the coin uwu
     */
    protected long investors;

    /**
     * How many coins are in circulation. 
     * This is about to cause inflation lmao
     */
    protected long supply;

    /**
     * Modify stonk value for some reason.
     * External modifier
     */
    protected double modify;

    /**
     * Number of times the coin value here is updated
     */
    protected int updated;

    /**
     * The path to the coin image
     */
    protected String image;

    /**
     * The name of the coin
     */
    protected String name;

    /**
     * Price it takes to unlock the coin
     */
    protected double unlockPrice;

    /**
     * Sets the lore of the coin
     */
    protected String lore;

    /**
     * Forced price of the coin
     */
    protected double forcedPrice;

    /**
     * Constructs a coin object that fluxtuates in value and investors
     * The initial supply is set to 0.
     * Initial modify is set to 0.
     * @param name The display name of the coin
     * @param value The init value of coin
     * @param investors Init investors
     * @param image The path for the img file
     * @param unlockPrice Price it takes to unlock the coin
     */
    public Coin(String name, double value, int investors, String image, double unlockPrice, String lore)
    {
        this.name = name;
        this.value = value;
        this.investors = investors;
        this.image = image;
        this.unlockPrice = unlockPrice;
        this.lore = lore;
        this.supply = 0;
        this.modify = 0;
        this.updated = 0;
        this.forcedPrice = -1;
    }

    /**
     * Change the supply of the coin
     * @param num How much to change the supply by
     */
    public void changeSupply(long num)
    {
        this.supply += num;
    }

    /**
     * Accessor method for supply
     * @return this.supply
     */
    public long getSupply()
    {
        return this.supply;
    }

    /**
     * Change the value of the coin
     * @param num How much to change the value by
     */
    public void changeValue(double num)
    {
        this.value += num;
    }

    /**
     * Accessor method for value
     * @return this.value
     */
    public double getValue()
    {
        return this.value;
    }

    /**
     * Accessor method for forced price
     * @return this.forcedPrice
     */
    public double getForcePrice()
    {
        return this.forcedPrice;
    }

    /**
     * Mutator method for forced price
     * @param forcedPrice The price to force the coin
     */
    public void setForcedPrice(double forcedPrice)
    {
        this.forcedPrice = forcedPrice;
    }

    /**
     * Change the investors this has
     * @param num The number of investors to change supply by
     */
    public void changeInvestors(long num)
    {
        this.investors += num;
    }

    /**
     * Mutator method for investors
     * @param num Number to set this.investors to
     */
    public void setInvestors(long num)
    {
        this.investors = num;
    }

    /**
     * Accessor method for this.investors
     * @return this.investors
     */
    public long getInvestors()
    {
        return this.investors;
    }

    /**
     * Changes the price modifier number of this coin
     * @param num Number to change this.modify by
     */
    public void changeModify(double num)
    {
        this.modify += num;
    }

    /**
     * Mutator method for this.modify
     * @param num Number to set this.modify to
     */
    public void setModify(double num)
    {
        this.modify = num;
    }

    /**
     * Accessor method for modify
     * @return this.modify
     */
    public double getModify()
    {
        return this.modify;
    }

    /**
     * Accessor method for the image string (or should I say path)
     * @return this.image
     */
    public String getImage()
    {
        return this.image;
    }

    /**
     * Get the name of the coin
     * @return this.name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Accessor method for this.unlockPrice
     * @return this.unlockPrice
     */
    public double getUnlockPrice()
    {
        return this.unlockPrice;
    }

    /**
     * Find price of coin or the forced price
     * @return Stonk price of the coin
     */
    public double calculatePrice()
    {
        if (this.forcedPrice != -1) return this.forcedPrice;
        double typ = (this.value * (this.investors * 0.75) + 1) / Math.max(1, (double)this.supply / 100 + 1 - (this.value / 20));
        return typ + modify;
    }

    /**
     * Mutator method for this.supply
     */
    public void setSupply(long supply)
    {
        this.supply = supply;
    }

    /**
     * Returns the "lore" of the coin.
     * Basically, it's just a brief description of the coin
     * @return this.lore
     */
    public String getLore()
    {
        return this.lore;
    }

    /**
     * Calculates the number of new investors and coin supply that will occur.
     * This occurs at different rates for each coin.
     * There's also different conditions for the influenceCalc that might be listed.
     */
    public void influenceCalc()
    {
        int frenzy = (int)this.calculatePrice() / 1000 + 1;
        int negPlus = (int) (Math.random() * 6);
        int infl = negPlus == 0 ? (int)(Math.random() * 5) * frenzy * -1 : (int)(Math.random() * 5) * frenzy;
        this.investors = Math.max(0, this.investors + infl);

        if (negPlus == 0)
        {
            this.supply = Math.max(0, this.supply - (int)(this.supply * 0.08 * Math.random()));
        }
        else
        {
            this.supply += (int)(this.investors * Math.random() * 1.1);
        }
    }

    /**
     * Stimulates a coin click. 
     * This does wack stuff with the investors and the price.
     * This is the most default one.
     * @return The $ the player got
     */
    public double click()
    {
        this.influenceCalc();
        Player.changeCash(this.calculatePrice());
    
        return this.calculatePrice();
    }

    /**
     * Record an increment in the update
     */
    public void noteUpdate()
    {
        this.updated++;
    }

    /**
     * Mutator method for this.value
     * @param val The value to set to
     */
    public void setValue(double val)
    {
        this.value = val;
    }

    /**
     * @return this.updated
     */
    public int getUpdate()
    {
        return this.updated;
    }
}
