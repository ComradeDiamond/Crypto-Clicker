package frontend.choiceBar;

import javax.swing.JPanel;
import frontend.choiceBar.buttons.*;
import javax.swing.BoxLayout;
import java.awt.Dimension;

/**
 * The leftbar of the choicebar layout
 * @author Justin
 * @since 4/15/21
 * @category frontend.choiceBar
 */
public class LeftBar extends JPanel
{
    /**
     * Constructs a left bar
     */
    public LeftBar()
    {
        super();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        this.setPreferredSize(new Dimension(100, 465));
        this.add(new Upgrade());
    }
}
