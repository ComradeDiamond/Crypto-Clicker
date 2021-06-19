package frontend.choiceBar;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Dimension;

/**
 * A mouse listener ripoff that has the capabilities to use the this keyword.
 * This also auto format alot of the buttons using the hover effect
 * Pls bring back CSS Java swing sucks.
 * This is also a workaround because lexical scoping go "where monke" in java
 * Something something abstract class because VSC tells me I need to use implements instead of extends
 * @author Justin
 * @since 4/15/21
 * @category frontend.choiceBar
 */
public class SmartListener implements MouseListener
{
    /**
     * The Choicer object to act on
     */
    private Choicer target;

    /**
     * Constructs a smart listener event listener for mouse events
     * @param target The object to act as this
     */
    public SmartListener(Choicer target)
    {
        super();
        this.target = target;
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseExit(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
        this.target.setPreferredSize(new Dimension(80, 80));
        this.target.adjustImageSize(80, 80);
        this.target.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    public void mouseEntered(MouseEvent e) {
        this.target.setPreferredSize(new Dimension(100, 100));      
        this.target.adjustImageSize(100, 100);  
        this.target.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
