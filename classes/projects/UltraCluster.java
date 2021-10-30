package classes.projects;

import java.awt.Color;

import classes.coin.Coin;
import classes.coin.Pepecoin;
import gameNav.Player;
import gameNav.PlayerActions;
import gameNav.TimedCommand;
/**
 * Can't beat the other crypto miners? Invest in some very expensive AWS hosting!
 * @author Justin
 * @since 10/25/21
 * @category classes.projects
 */
public class UltraCluster extends Project
{
    /**
     * Chance that an the ultracluster mining will succeed
     */
    private int protNum;

    /**
     * Whether the code can revalidate the command (or basically, have it run again)
     */
    private boolean canRevalidate;

    public UltraCluster()
    {
        super("Hyperscale Cluster", "Do you have a potato for a laptop? Are you tired of your crypto getting stolen by people with RTX 3080? Invest in Amazon's UltraCluster EC2 P4D with NVIDIA A100 GPUs and 400Gbps for the next 3 turns.", 
        5000000, 1, "/images/UltraCluster.JPG", new Color(3, 115, 252));
        this.protNum = 50;
        this.canRevalidate = true;
    }

    /**
     * @return Whether or not it's pepecoin
     */
    public boolean determineDisplay()
    {
        return Player.getCoin().getName().equalsIgnoreCase("Pepecoin");
    }

    /**
     * Initiate ultracluster by adding ultracommand and adding 1 to success rate
     */
    public void initiate()
    {
        PlayerActions.taskQueue.add(new UltraCommand(this.protNum, this));
        this.protNum++;
        this.canRevalidate = false;
    }

    /**
     * @return this.cost or 8% of your money, whichever is higher
     */
    public double calculateCost()
    {
        return Math.max(this.cost, Player.getCash() * .08);
    }

    /**
     * Mutator method for canRevalidate
     */
    public void setCanRevalidate(boolean canRevalidate)
    {
        this.canRevalidate = canRevalidate;
    }

    /**
     * @return 2% chance to recalibrate
     */
    public boolean recalibrate()
    {
        boolean fixed = (int)(Math.random() * 50) == 5;
        if (fixed && canRevalidate)
        {
            this.numClicked = 0;
        }
        return fixed;
    }
}

/**
 * UltraCommand is a timed command that ensures every pepecoin mine has a 50% success rate.
 * Every time you use it, the success rate increases by 1.
 * @author Justin
 * @since 10/25/21
 */
class UltraCommand extends TimedCommand
{
    /**
     * % success rate, should be inherited from Ultracluster
     */
    private int protNum;

    /**
     * The cluster that called this command
     */
    private UltraCluster cluster;

    /**
     * Constructor
     * @param protNum The % success rate
     * @param cluster Current cluster
     */
    public UltraCommand(int protNum, UltraCluster cluster)
    {
        super(3);
        this.protNum = protNum;
        this.cluster = cluster;
    }

    /**
     * Toggles the pepecoin bypass.
     * Precondition: You actually have pepecoin
     * @return This will continue the clicking
     */
    public boolean execute()
    {
        Coin coin = Player.getCoin();
        if (coin.getName().equals("Pepecoin"))
        {
            int randNum = (int)(Math.random() * 100);
            //System.out.println(randNum + " " + (randNum < this.protNum));
            if (randNum < this.protNum)
            {
                ((Pepecoin)coin).enableBypass();
            }
        }

        if (this.getTimer() == 1)
        {
            cluster.setCanRevalidate(true);
        }
        return true;
    }
}
