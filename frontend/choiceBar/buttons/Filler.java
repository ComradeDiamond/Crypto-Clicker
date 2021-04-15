package frontend.choiceBar.buttons;

import javax.swing.JLabel;
import java.awt.Dimension;

/**
 * A filler class that's only here for frontend decor
 * @author Justin
 * @since 4/15/21
 */
public class Filler extends JLabel
{
    /**
     * Constructs a filler object
     */
    public Filler()
    {
        super();
        this.setPreferredSize(new Dimension(80, 80));
    }
}
