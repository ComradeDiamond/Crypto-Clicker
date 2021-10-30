package classes.projects;

import java.awt.Color;

import classes.coin.Dogecoin;
import gameNav.Player;

/**
 * WallStreetBets = investors = more apes = profit
 * @author Justin
 * @since 10/28/21
 * @category classes.projects
 */
public class WallStreetBets extends Project
{
    public WallStreetBets()
    {
        super("Wall Street Bets", "Buy some Times Square Ads! Post some loss porn! Sponsor another episode of Chad Money - because we're taking it to r/WallStreetBets!", 
            1000, 1, "/images/WallStreetBets.jpeg", Color.YELLOW);
    }

    public void initiate()
    {
        if (Player.getCoin().getName().equals("Dogecoin!!!"))
        {
            ((Dogecoin)Player.getCoin()).changeInvestors(Player.getCoin().getInvestors() * (int)(Math.random() * 2000 + 50));
            ((Dogecoin)Player.getCoin()).changeModify(1);
        }
    }

    public double getCost()
    {
        return Math.max(this.cost, Player.getCash() * 0.2);
    }

    /**
     * @return Whether it's dogecoin
     */
    public boolean determineDisplay()
    {
        return Player.getCoin().getName().equals("Dogecoin!!!");
    }

    /**
     * @return 2% chance
     */
    public boolean recalibrate()
    {
        boolean x = (int)(Math.random() * 50) == 2;
        if (x)
        {
            this.numClicked = 0;
        }
        return x;
    }
}
