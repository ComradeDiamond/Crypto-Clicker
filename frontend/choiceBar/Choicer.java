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
     * The image icon for the choicer btn
     */
    private ImageIcon icon;

    /**
     * Constructs a choicer filler object
     * @param tooltip The tooltip this choicer will display
     * @param image The relative path of the image of the choicer button(?)
     */
    public Choicer(String tooltip, String image)
    {
        super();
        this.setPreferredSize(new Dimension(80, 80));
        this.setToolTipText(tooltip);

        this.icon = new ImageIcon(getClass().getResource(image));
        this.adjustImageSize(80, 80);
    }

    /**
     * Mutator method mouse listener object.
     * Usually you'll want to add one, but maybe something we won't
     * @param mouseListener The mouse listener that will show what happens when the tooltip gets clicked
     */
    public void setMouseListener(MouseListener mouseListener)
    {
        this.addMouseListener(mouseListener);
    }

    /**
     * Adjusts the image size of this image icon
     * @param width The width to set the icon
     * @param height The height to set the icon to
     */
    public void adjustImageSize(int width, int height)
    {
        this.icon = new ImageIcon(this.icon.getImage().getScaledInstance(width, height, 16));
        this.setIcon(icon);
    }
}
