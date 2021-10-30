package frontend.choiceBar.buttons;

import frontend.choiceBar.displays.CoinUpgrade;
import java.awt.event.MouseEvent;
import frontend.choiceBar.*;

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
        super("Upgrade your coin to something else!", "/images/Upgrade.png");
        super.addMouseListener(new SmartListener(this) {
            public void mouseClicked(MouseEvent e) {
                new CoinUpgrade().display();
            }
        });
    }
}
