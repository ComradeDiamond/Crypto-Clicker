package frontend;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Establishes a background image
 * @author Justin
 * @since 10/29/21
 * @category frontend
 */
public class BackgroundPanel extends JLabel
{
    /**
     * Constructs the background image panel
     * @param x X coordinate of GUI
     * @param y Y coordinate of GUI
     */
    public BackgroundPanel(int x, int y)
    {
        super();
        this.setIcon(new ImageIcon("Images/DogeBackground.png"));
        this.setBounds(0, 110, x, y - 110);
    }
}
