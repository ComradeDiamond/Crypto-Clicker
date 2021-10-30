package frontend.choiceBar;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Dimension;

/**
 * The same as the left bar, but for the right side.
 * I didn't want to make another inherited class for just 2 objects
 * @author Justin
 * @since 4/15/21
 * @category frontend.choiceBar
 */
public class RightBar extends JPanel
{
    /**
     * Constructs a right bar
     */
    public RightBar()
    {
        super();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        this.setPreferredSize(new Dimension(100, 465));
        this.setOpaque(false);
    }
}
