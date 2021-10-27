package classes.projects;

import java.awt.Color;

import frontend.choiceBar.displays.ProjectUpgrade;
import gameNav.Player;
import gameNav.PlayerActions;
/**
 * The tiktok trend has gone too far
 * @author Justin
 * @since 10/25/21
 * @category classes.projects
 */
public class ElPepe extends Project
{
    public ElPepe()
    {
        super("El Pepe", "The TikTok trend has gone too far - support Pepe now for clout! Mark by words: with crazy clout comes crazy stans. The mightiness of El Pepe crashes your Amazon EC2 and your timed commands.", 
            10000, 1, "Images/Pepe.png", new Color(82, 255, 171));
    }

    /**
     * Has a 1% chance of summoning el pepe for massive clout
     */
    public boolean recalibrate()
    {
        boolean clout = (int)(Math.random() * 100) == 50;
        if (clout)
        {
            this.numClicked = 0;
        }
        return clout;
    }

    /**
     * Generates insane clout.
     * This is kind of a double edged sword for pepe users.
     */
    public void initiate()
    {
        int num = (int)(Math.random() * 45000) + 5000;
        Player.getCoin().changeInvestors(num);
        ProjectUpgrade.projects.get("UltraCluster").numClicked = 500;
        PlayerActions.taskQueue.clear();
    }

    /**
     * @return Whether or not it's pepecoin
     */
    public boolean determineDisplay()
    {
        return Player.getCoin().getName().equalsIgnoreCase("Pepecoin");
    }
}
