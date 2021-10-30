package classes.projects;

import java.awt.Color;
import gameNav.Player;

/**
 * The moment Elon Tweets something, prepare for stock prices to soar
 * @author Justin
 * @since 10/27/21
 * @category classes.projects
 */
public class ElonMusk extends Project
{
    public ElonMusk()
    {
        super("Worship Elon Musk", "Whenever Elon tweets, the stonk market is guarenteed to go up by 5000%. CNBC facepalms as they lecture us Apes about bad investments.", 
            20000, 1, "/images/ElonMusk.jpg", new Color(255, 213, 0));
    }

    public double calculateCost()
    {
        return Math.max(this.cost, Player.getCash() * .78);
    }

    /**
     * 1/30% to recalibrate worship Elon worship.
     */
    public boolean recalibrate()
    {
        boolean yet = (int)(Math.random() * 30) == 5;
        if (yet)
        {
            this.numClicked = 0;
        }

        return yet;
    }

    /** 
     * @return Whether it's dogecoin
     */
    public boolean determineDisplay()
    {
        return Player.getCoin().getName().equals("Dogecoin!!!");
    }

    public void initiate()
    {
        if (Player.getCoin().getName().equals("Dogecoin!!!"))
        {
            Player.getCoin().changeModify(Player.getCoin().getModify() * Math.random() + 0.1);
            Player.getCoin().changeSupply(200);
        }
    }
}
