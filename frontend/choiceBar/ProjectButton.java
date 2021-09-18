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
import gameNav.PlayerActions;
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
    /**
     * Constructs a project button with cost and "displayability" pre-set and adjusted
     * @param el The project object this button is for
     */
    public ProjectButton(Project el)
    {
        final Color SKYBLUE = new Color(135, 206, 250);
        final Color REALLYSKYBLUE = new Color(0, 191, 255);
        final Color GREY = new Color(245, 245, 245);
        final Color SILVER = new Color(169, 169, 169);

        //Determine if buttons should be active or not later on
        boolean goodBtn = el.canClick() && Player.getCash() >= el.calculateCost();
        String reason;

        if (el.canClick())
        {
            if (goodBtn)
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

        this.setBackground(goodBtn ? SKYBLUE : GREY);
        JLabel btnTxt = new JLabel(reason);
        btnTxt.setBorder(new EmptyBorder(10, 10, 10, 10)); 
        btnTxt.setHorizontalAlignment(JButton.CENTER);
        btnTxt.setVerticalAlignment(JButton.CENTER);
        btnTxt.setFont(new Font("Trebuchet ms", Font.PLAIN, 18));
        btnTxt.setForeground(goodBtn ? Color.WHITE : SILVER);
        this.add(btnTxt); 

        JButton btn = this;
        if (!goodBtn) this.setEnabled(false);

        //Event listener for btn now
        this.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e) {
                if (goodBtn)
                {
                    el.initiate();
                    Player.changeCash(-1 * el.getCost());
                    el.addNumClicked();
                    ProjectUpgrade.allChecked = false;
                }
            }
        
            public void mouseReleased(MouseEvent e) {
            }
        
            public void mousePressed(MouseEvent e) {
            }
        
            public void mouseExited(MouseEvent e) {
                if (goodBtn)
                {
                    btn.setBackground(SKYBLUE);
                }
                btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        
            public void mouseEntered(MouseEvent e) { 
                if (goodBtn)
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
