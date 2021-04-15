package frontend.choiceBar;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.MouseListener;


/**
 * I don't know a name for this ._.
 * But this choicer opens up GUI options that you can pick from.
 * The superclass of all frontend inside choiceBar
 * @author Justin
 * @since 4/15/21
 * @category frontend.choiceBar
 */
public class Choicer extends JLabel
{
    /**
     * Constructs a choicer filler object
     * @param tooltip The tooltip this choicer will display
     * @param image The relative path of the image of the choicer button(?)
     * @param mouseListener The mouse listener that will show what happens when the tooltip gets clicked
     */
    public Choicer(String tooltip, ImageIcon image, MouseListener mouseListener)
    {
        super();
        this.setPreferredSize(new Dimension(80, 80));
        this.setToolTipText(tooltip);
        this.setIcon(image);
        this.addMouseListener(mouseListener);
    }
}
