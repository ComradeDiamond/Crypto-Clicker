package classes.projects;

import java.awt.Color;
import gameNav.*;

/**
 * Technoblade never dies - and neither does the potato minions. Oh and your stabilized wallet.
 * Seems really exploitable if you ask me.
 * Support goes out for Technoblade's cancer diagnosis.
 * @author Justin
 * @since 10/28
 * @category classes.projects
 */
public class Technoblade extends Project
{
    public Technoblade()
    {
        super("#TechnoSupport", "\"I don't believe in friendship, Tommy... We tell ourselves it's real so the cogs of society can turn... The only thing that's real, Tommy... is CASH!\"", 
            100000, 1, "/images/Technoblade.png", Color.MAGENTA);
    }

    /**
     * 0.5% to recalibrate summon technoblade
     */
    public boolean recalibrate()
    {
        boolean yet = (int)(Math.random() * 200) == 5;
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
            PlayerActions.taskQueue.add(new WalletFreeze());
        }
    }
}

class WalletFreeze extends TimedCommand
{
    private double walletCash;
    public WalletFreeze()
    {
        super(20);
        this.walletCash = Player.getCash();
    }

    /**
     * @return continue click
     */
    public boolean execute()
    {
        Player.setCash(this.walletCash);
        return true;
    }
}