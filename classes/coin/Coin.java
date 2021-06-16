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
    private double value;

    /**
     * How many investors are investing in the coin uwu
     */
    private int investors;

    /**
     * How many coins are in circulation. 
     * This is about to cause inflation lmao
     */
    private int supply;

    /**
     * Modify stonk value for some reason.
     * External modifier
     */
    private double modify;

    /**
     * The path to the coin image
     */
    private String image;

    /**
     * The name of the coin
     */
    private String name;

    /**
     * Price it takes to unlock the coin
     */
    private double unlockPrice;

    /**
     * Sets the lore of the coin
     */
    private String lore;

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
    }

    /**
     * Change the supply of the coin
     * @param num How much to change the supply by
     */
    public void changeSupply(int num)
    {
        this.supply += num;
    }

    /**
     * Accessor method for supply
     * @return this.supply
     */
    public int getSupply()
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
     * Change the investors this has
     * @param num The number of investors to change supply by
     */
    public void changeInvestors(int num)
    {
        this.investors += num;
    }

    /**
     * Mutator method for investors
     * @param num Number to set this.investors to
     */
    public void setInvestors(int num)
    {
        this.investors = num;
    }

    /**
     * Accessor method for this.investors
     * @return this.investors
     */
    public int getInvestors()
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
     * Find price of coin yes
     * @return Stonk price of the coin
     */
    public double calculatePrice()
    {
        double typ = (this.value * (this.investors + 1)) / ((double)this.supply / 100 + 1);
        return typ + modify;
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
        int negPlus = (int) (Math.random() * 5);

        int infl = negPlus == 0 ? (int)(Math.random() * 5) * frenzy * -1 : (int)(Math.random() * 5) * frenzy;
        
        if (this.investors + infl < 0) 
        {
            this.investors = 0;
        }
        else
        {
            this.investors += infl;
        }

        this.supply += (int)(this.investors * (Math.random() * 2 + 1));
    }

    /**
     * Stimulates a coin click. 
     * This does wack stuff with the investors and the price.
     * This is the most default one.
     * @return The $ the player got
     */
    public double click()
    {
        Player.changeCash(this.calculatePrice());
        this.influenceCalc();

        return this.calculatePrice();
    }
}
