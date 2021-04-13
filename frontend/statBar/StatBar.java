package frontend.statBar;
import javax.swing.JPanel;
import java.awt.FlowLayout;

/**
 * The statbar widget for the frontend
 * This displays stuff like item prices, gold prices, etc.
 * @author Justin
 * @since 4/12/21
 * @category frontend.statBar
 */
public class StatBar extends JPanel
{
    /**
     * Why does this exist? Why do I need one of these
     */
    private static final long serialVersionUID = 0;

    /**
     * Constructor for stat bar
     * How do you even comment frontend lmao
     */
    public StatBar()
    {
        super();
        this.setLayout(new FlowLayout());
        this.setBounds(0, 0, 800, 60);
    }
}
