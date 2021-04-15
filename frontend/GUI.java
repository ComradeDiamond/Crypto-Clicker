package frontend;
import javax.swing.*;
import java.awt.BorderLayout;

import frontend.statBar.StatBar;
import frontend.choiceBar.ChoiceBar;
import frontend.coin.CoinDisplay;

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
     * The frontend display for the coin
     */
    private CoinDisplay coinDisplay;

    /**
     * The choicebar display for the coin
     */
    private ChoiceBar cBar;

    /**
     * Constructs the game GUI
     * @throws Exception if something goes wrong
     */
    public GUI() throws Exception
    {
        super("Crypto Clicker");
        this.setResizable(false);
        this.setSize(1200, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        /*ImageIcon icon = new ImageIcon("./images/Dogecoin.png");
        this.setIconImage(icon.getImage());

        JLabel label = new JLabel("Crypto Clicker");*/

        this.sBar = new StatBar();
        this.add(this.sBar, BorderLayout.NORTH);

        this.coinDisplay = new CoinDisplay();
        this.add(this.coinDisplay, BorderLayout.EAST);

        this.cBar = new ChoiceBar();
        this.add(this.cBar, BorderLayout.WEST);
        
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

    /**
     * Accessor method for the coin display
     * @return this.coinDisplay
     */
    public CoinDisplay getCoinDisplay()
    {
        return this.coinDisplay;
    }
}
