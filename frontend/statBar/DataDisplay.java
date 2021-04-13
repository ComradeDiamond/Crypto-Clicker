package frontend.statBar;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

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
     */
    public DataDisplay(ImageIcon icon, boolean callCalibrate)
    {
        super();
        this.setIcon(icon);
        this.calibrate();
        this.setVerticalTextPosition(JLabel.CENTER);
        this.setOpaque(true);
        this.setFont(new Font("Trebuchet ms", Font.PLAIN, 24));
        this.setHorizontalAlignment(JLabel.RIGHT);
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
