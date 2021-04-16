package frontend.choiceBar.displays;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import gameNav.Player;

/**
 * This cover is the default layout of any "web" display thing.
 * It also covers the entire screen so that the user can't interact with it unless they exit.
 * @author Justin
 * @since 4/15/21
 * @category frontend.choiceBar.displays
 */
public class Cover extends JPanel
{
    /**
     * The panel with actual text and options and whatnot
     */
    private JPanel textPanel;

    /**
     * Constructs a cover object.
     * This is hidden by default
     */
    public Cover()
    {
        super();
        this.setBounds(0, 0, 1200, 600); //Full screen
        this.setBackground(new Color(77, 77, 77, 60));

        this.textPanel = new JPanel();
        this.textPanel.setPreferredSize(new Dimension(800, 500));
        this.textPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        this.textPanel.setAlignmentY(JPanel.CENTER_ALIGNMENT);
    }

    /**
     * Accessor method for the text panel
     * @return this.textPanel
     */
    public JPanel getTextPanel()
    {
        return this.textPanel;
    }

    /**
     * Adds this object to the top of the GUI.
     */
    public void display()
    {
        Player.getGUI().appendChild(this);
    }

    /**
     * Removes this object from the top of the GUI.
     */
    public void destroy()
    {
        Player.getGUI().removeChild(this);
    }
}