package frontend;
import javax.swing.*;
import java.awt.BorderLayout;

import frontend.statBar.StatBar;

/**
 * Constructs a javax swing GUI for the app.
 * @author Justin
 * @since 4/12/21
 * @category frontend
 */
public class GUI extends JFrame
{
    private static final long serialVersionUID = 0;

    /**
     * The statbar we're putting in to the GUI
     */
    private StatBar sBar;

    /**
     * Constructs the game GUI
     * @throws Exception if something goes wrong
     */
    public GUI() throws Exception
    {
        super("Crypto Clicker");
        this.setResizable(false);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        /*ImageIcon icon = new ImageIcon("./images/Dogecoin.png");
        this.setIconImage(icon.getImage());

        JLabel label = new JLabel("Crypto Clicker");*/

        this.sBar = new StatBar();
        this.add(this.sBar, BorderLayout.NORTH);

        this.setVisible(true);
    }

    /**
     * Accessor method for the statbar
     * @return this.sBar
     */
    public StatBar getStatBar()
    {
        return this.sBar;
    }
}
