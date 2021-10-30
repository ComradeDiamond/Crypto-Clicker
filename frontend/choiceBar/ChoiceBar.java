package frontend.choiceBar;

import java.awt.FlowLayout;
import javax.swing.JPanel;

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
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));
        this.setBounds(20, 140, 220, 490);
        //this.setPreferredSize(new Dimension(220, 490));

        this.add(new LeftBar());
        this.add(new RightBar());
        this.setOpaque(false);
    }
}
