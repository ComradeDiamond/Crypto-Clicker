package frontend.choiceBar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import classes.projects.Project;
import frontend.choiceBar.displays.ProjectUpgrade;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Cursor;
import gameNav.Player;
import gameNav.StatLabel;

/**
 * The project button is a helper component that basic determines the clicky stuff.
 * It displays the upgrade cost and functions as a clcikable gateway.
 * @author Justin
 * @since 9/15/21
 * @category frontend.choiceBar
 */
public class ProjectButton extends JButton
{
    private static final Color SKYBLUE = new Color(135, 206, 250);
    private static final Color REALLYSKYBLUE = new Color(0, 191, 255);
    private static final Color GREY = new Color(245, 245, 245);
    private static final Color SILVER = new Color(169, 169, 169);
    private boolean goodBtn;

    /**
     * Updates the display of a ProjectButton
     * @param el The project obj this button is for
     * @param btn The Project button display you're updating
     */
    private static void updateDisplay(ProjectButton btn, Project el)
    {
        //Determine if buttons should be active or not later on
        btn.goodBtn = el.canClick() && Player.getCash() >= el.calculateCost();
        String reason;

        if (el.canClick())
        {
            if (btn.goodBtn)
            {
                reason = "$" + StatLabel.calibrate(el.calculateCost());
            }
            else
            {
                reason = "$" + StatLabel.calibrate(el.calculateCost());
            }
        }
        else
        {
            reason = "On Cooldown";
        }

        btn.setBackground(btn.goodBtn ? SKYBLUE : GREY);
        btn.removeAll();
        JLabel btnTxt = new JLabel(reason);
        btnTxt.setBorder(new EmptyBorder(10, 10, 10, 10)); 
        btnTxt.setHorizontalAlignment(JButton.CENTER);
        btnTxt.setVerticalAlignment(JButton.CENTER);
        btnTxt.setFont(new Font("Trebuchet ms", Font.PLAIN, 18));
        btnTxt.setForeground(btn.goodBtn ? Color.WHITE : SILVER);
        btn.add(btnTxt); 
        if (!btn.goodBtn) btn.setEnabled(false);
    }

    /**
     * Constructs a project button with cost and "displayability" pre-set and adjusted.
     * This uses the static method in the ProjectButton class.
     * @param el The project object this button is for
     */
    public ProjectButton(Project el)
    {
        ProjectButton.updateDisplay(this, el);
        ProjectButton btn = this;

        btn.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (btn.goodBtn)
                {
                    el.initiate();
                    Player.changeCash(-1 * el.calculateCost());
                    el.addNumClicked();
                    ProjectUpgrade.allChecked = false;
                    ProjectButton.updateDisplay(btn, el);
                    //btn.repaint();
                    Player.getGUI().getStatBar().updateDisplays(true);
                }
            }
        
            public void mouseReleased(MouseEvent e) {
            }
        
            public void mousePressed(MouseEvent e) {
            }
        
            public void mouseExited(MouseEvent e) {
                if (btn.goodBtn)
                {
                    btn.setBackground(SKYBLUE);
                }
                btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        
            public void mouseEntered(MouseEvent e) { 
                if (btn.goodBtn)
                {
                    btn.setBackground(REALLYSKYBLUE);
                    btn.setCursor(new Cursor(Cursor.HAND_CURSOR));   
                }
                else
                {
                    btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            }
        });
    }
}
