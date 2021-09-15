package frontend.choiceBar.displays;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import gameNav.Player;

/**
 * Project Update Panel that... well... allows you to take on projects.
 * @author Justin
 * @since 9/14/21
 * @category frontend.choiceBar.displays
 */
public class ProjectUpgrade extends Cover
{
    /**
     * Constructs le project cover
     */
    public ProjectUpgrade()
    {
        super();
        JPanel centerPane = new JPanel();
        centerPane.setBorder(new EmptyBorder(40, 20, 40, 20));
        centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.PAGE_AXIS));
        centerPane.setBackground(Color.WHITE);

        JLabel title1 = new JLabel("Initiate Project");
        title1.setFont(new Font("Trebuchet ms", Font.PLAIN, 48));
        Dimension tempDim = title1.getPreferredSize();
        tempDim.width = this.tpLength;
        title1.setPreferredSize(tempDim);
        //title1.setHorizontalAlignment(JLabel.RIGHT);
        title1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        centerPane.add(title1);

        JLabel titleDesc = new JLabel("Launch operations to control how your mining operation is going!");
        titleDesc.setFont(new Font("Trebuchet ms", Font.PLAIN, 18));
        tempDim = titleDesc.getPreferredSize();
        tempDim.width = this.tpLength;
        titleDesc.setPreferredSize(tempDim);
        titleDesc.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        centerPane.add(titleDesc);

        this.getTextPanel().add(centerPane, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
}
