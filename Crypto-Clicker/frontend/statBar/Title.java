package frontend.statBar;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * The title!
 * @author Justin
 * @since 4/13/21
 * @category frontend.statBar
 */
public class Title extends JLabel
{
    private static final long serialVersionUID = 0;

    /**
     * Constructs the title
     */
    public Title()
    {
        super();
        this.setText("    ");
        this.setIcon(new ImageIcon("images/Logo1.png"));
        this.setSize(300, 100);
    }
}
