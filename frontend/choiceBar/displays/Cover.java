package frontend.choiceBar.displays;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import gameNav.Player;
import frontend.choiceBar.Choicer;
import frontend.choiceBar.SmartListener;
import java.awt.event.MouseEvent;

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
     * The length of the text panel
     */
    protected int tpLength;

    /**
     * The height of the text panel
     */
    protected int tpHeight;

    /**
     * Constructs a cover object.
     * This is hidden by default
     */
    public Cover()
    {
        super();
        this.setBounds(0, 0, Player.getGUI().getX(), Player.getGUI().getY()); //Full screen
        this.setBackground(new Color(77, 77, 77, 20));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));

        this.tpLength = 800;
        this.tpHeight = 500;

        this.textPanel = new JPanel();
        this.textPanel.setBackground(Color.WHITE);
        this.textPanel.setPreferredSize(new Dimension(this.tpLength, this.tpHeight));
        this.textPanel.setLayout(new BorderLayout());

        //No lexical scoping is dumb yes
        Cover temp = this;

        Choicer exit = new Choicer("Exit", "images/Previous.png");
        exit.addMouseListener(new SmartListener(exit) {
            public void mouseClicked(MouseEvent e)
            {
                temp.destroy();
                Player.getGUI().revalidate();
                Player.getGUI().repaint();
            }
        });

        exit.setPreferredSize(new Dimension(80, 80));
        this.textPanel.add(exit, BorderLayout.NORTH);
        this.add(this.textPanel);
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