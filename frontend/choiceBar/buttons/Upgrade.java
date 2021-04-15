package frontend.choiceBar.buttons;

import frontend.choiceBar.Choicer;
import frontend.choiceBar.SmartListener;
import java.awt.event.MouseEvent;

/**
 * An upgrade button!
 * With enough coins, you can upgrade your coin to the next tier.
 * This is how you progress the game apparently :think:
 * @author Justin
 * @since 4/15/21
 * @category frontend.choiceBar.buttons
 */
public class Upgrade extends Choicer
{
    /**
     * Constructs a choicer.
     * This will also simultaneously input the event listeners
     */
    public Upgrade()
    {
        super("Upgrade your coin to something else!", "images/Upgrade.png");
        super.addMouseListener(new SmartListener(this) {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Do stuff pls");
            }
        });
    }
}
