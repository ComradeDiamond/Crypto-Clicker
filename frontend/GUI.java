package frontend;
import javax.swing.*;

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
     * The JLayeredPane
     */
    private JLayeredPane pane;

    /**
     * The width of the pane
     */
    private int x;

    /**
     * The height of the pane
     */
    private int y;

    /**
     * The background of this GUI
     */
    private BackgroundPanel backgroundPanel;

    /**
     * Constructs the game GUI
     * @throws Exception if something goes wrong
     */
    public GUI() throws Exception
    {
        super("Crypto Clicker");

        int x = 1200;
        int y = 600;

        this.x = x;
        this.y = y;

        this.setResizable(false);
        this.setSize(x, y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //App icon
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/Dogecoin.png"));
        this.setIconImage(icon.getImage());

        //Resume adding children
        this.pane = new JLayeredPane();
        this.pane.setBounds(0, 0, x, y);
        this.add(this.pane);

        this.sBar = new StatBar();
        this.pane.add(this.sBar);

        this.coinDisplay = new CoinDisplay();
        this.pane.add(this.coinDisplay);

        this.cBar = new ChoiceBar();
        this.pane.add(this.cBar);

        this.setVisible(true);
    }

    /**
     * Add the dogecoin background
     */
    public void addDoge()
    {
        this.removeChild(this.backgroundPanel);
        this.backgroundPanel = new BackgroundPanel(this.x, this.y, "/images/DogeBackground.png");
        this.pane.add(this.backgroundPanel);
        this.revalidate();
        this.repaint();
    }

    public void addPepe()
    {
        this.removeChild(this.backgroundPanel);
        this.backgroundPanel = new BackgroundPanel(this.x, this.y, "/images/PepeBackground.jpg");
        this.pane.add(this.backgroundPanel);
        this.revalidate();
        this.repaint();
    }

    public void addBit()
    {
        this.removeChild(this.backgroundPanel);
        this.backgroundPanel = new BackgroundPanel(this.x, this.y, "/images/BitBackground.jpg");
        this.pane.add(this.backgroundPanel);
        this.revalidate();
        this.repaint();
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

    /**
     * Automatically appends something to the modal layer of the JLayeredPane.
     * Why does this sound like HTML DOM
     * @param component The component to add
     */
    public void appendChild(JComponent component)
    {
        //this.pane.add(component);
        this.pane.add(component, JLayeredPane.MODAL_LAYER);
    }

    /**
     * Removes an item in the JLayeredPane
     * @param component The component to remove
     */
    public void removeChild(JComponent component)
    {
        if (component == null) return;
        this.pane.remove(component);
        this.pane.revalidate();
        this.pane.repaint();
    }

    /**
     * Accessor method for background panel
     * @return this.backgroundPanel
     */
    public BackgroundPanel getBackgroundPanel()
    {
        return this.backgroundPanel;
    }
    
    /**
     * @return Width of the Jpanel
     */
    public int getX()
    {
        return this.x;
    }

    /**
     * @return Height of the Jpanel
     */
    public int getY()
    {
        return this.y;
    }
}