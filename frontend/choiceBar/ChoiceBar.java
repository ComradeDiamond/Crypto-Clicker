package frontend.choiceBar;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

/**
 * The choicebar!
 * This contains all the widgets for the crypto clicker game.
 * @author Justin
 * @since 4/15/21
 * @category frontend.choicebar
 */
public class ChoiceBar extends JPanel
{
    /**
     * Must put this or else VSC throws an error
     */
    private static final long serialVersionUID = 0;

    /**
     * Constructs a choice bar
     */
    public ChoiceBar()
    {
        super();
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 25));
        this.setPreferredSize(new Dimension(200, 490));

        this.add(new LeftBar());
        this.add(new RightBar());
    }
}
