package frontend.statBar;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

/**
 * Superclass for data display
 * This consolidates all other jlabels into something that could display frontend data
 * @author Justin
 * @since 4/13/21
 * @category frontend.statBar
 */
public class DataDisplay extends JLabel
{
    /**
     * Smh why is this here
     */
    private static final long serialVersionUID = 0;

    /**
     * Constructs a data display
     * @param icon The icon to display in the JLabel
     * @param callCalibrate Whether or not to call the default calibrate method of the class.
        * If it's a no, you must write your own calibrate method call
     * @param tooltipTxt The tooltip text to display on hover!
     */
    public DataDisplay(ImageIcon icon, boolean callCalibrate, String tooltipTxt)
    {
        super();
        this.setIcon(new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)));
        this.calibrate();
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalTextPosition(JLabel.RIGHT);
        this.setOpaque(false);
        this.setFont(new Font("Trebuchet ms", Font.PLAIN, 22));
        this.setHorizontalAlignment(JLabel.RIGHT);
        this.setToolTipText(tooltipTxt);
    }

    /**
     * Top level method for polymorphism
     * This does literally nothing lol
     */
    public void calibrate()
    {
        //This is nothing







        //Still nothing








        //Heya still here?






        //Still nothing.
    }
}
