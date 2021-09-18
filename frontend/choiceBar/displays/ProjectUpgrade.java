package frontend.choiceBar.displays;
import javax.swing.*;
import javax.swing.border.*;
import java.util.Map;
import frontend.choiceBar.CustomScroll;
import frontend.choiceBar.ProjectButton;
import classes.projects.*;
import java.awt.*;

/**
 * Project Update Panel that... well... allows you to take on projects.
 * @author Justin
 * @since 9/14/21
 * @category frontend.choiceBar.displays
 */
public class ProjectUpgrade extends Cover
{
    /**
     * Array of projects that could be used later on.
     * Whether or not they will appear though... depends on Project.prototype.determineDisplay
     */
    private static Map<String, Project> projects = Map.ofEntries(
        Map.entry("Autoclicker", new Autoclicker()),
        Map.entry("Autoclicker2", new Autoclicker2()),
        Map.entry("CPUpgrade", new CPUpgrade()),
        Map.entry("Forex", new Forex())
    );

    /**
     * For optimization - whether or not all projects are not on cooldown
     */
    public static boolean allChecked = true;

    /**
     * Recalibrate all project click time. 
     * The calibrating system works differently - you only have a chance to recalibrate when clicking.
     * That chance isn't too big...
     */
    public static void recalibrateAll()
    {
        if (ProjectUpgrade.allChecked) {
            return;
        }

        ProjectUpgrade.allChecked = true;
        for (Project el : ProjectUpgrade.projects.values())
        {
            if (!el.recalibrate())
            {
                ProjectUpgrade.allChecked = false;
            }
        }
    }

    /**
     * Constructs le project cover
     */
    public ProjectUpgrade()
    {
        super();
        JPanel centerPane = new JPanel();
        JScrollPane scrollPane = new JScrollPane(centerPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //This code is used to test scrollbar design
        //JScrollPane scrollPane = new JScrollPane(centerPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUI(new CustomScroll());
        scrollPane.getHorizontalScrollBar().setUI(new CustomScroll());
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

        final int IMAGEWIDTH = 80;
        int netWidth = this.tpLength - IMAGEWIDTH - IMAGEWIDTH;

        for (Project el : ProjectUpgrade.projects.values())
        {
            if (el.determineDisplay())
            {
                //Create display panel. Typical stuff.
                JPanel jp1 = new JPanel();
                jp1.setBackground(Color.WHITE);
                jp1.setBorder(new EmptyBorder(20, 0, 0, 0));
                jp1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
                
                JLabel jp1Img = new JLabel();
                ImageIcon imgIcon = new ImageIcon(new ImageIcon(el.getImage()).getImage().getScaledInstance(IMAGEWIDTH, IMAGEWIDTH, 16));
                jp1Img.setIcon(imgIcon);
                jp1Img.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                jp1Img.setAlignmentY(JLabel.CENTER_ALIGNMENT);
                jp1Img.setBorder(new EmptyBorder(0, 5, 0, 0));

                JPanel jp1Word = new JPanel();
                jp1Word.setBackground(Color.WHITE);
                jp1Word.setLayout(new BoxLayout(jp1Word, BoxLayout.PAGE_AXIS));
                int prefHeight = jp1Word.getPreferredSize().height;
                jp1Word.setSize(netWidth, prefHeight);

                JLabel jp1Title = new JLabel(el.getName());
                jp1Title.setFont(new Font("Trebuchet ms", Font.BOLD, 20));
                jp1Title.setAlignmentX(JPanel.LEFT_ALIGNMENT);
                jp1Title.setBorder(new EmptyBorder(0, 5, 0, 0));

                JTextArea jp1Text = new JTextArea();
                jp1Text.setEditable(false);
                jp1Text.setWrapStyleWord(true);
                jp1Text.setLineWrap(true);
                jp1Text.setText(el.getDesc());
                jp1Text.setFont(new Font("Trebuchet ms", Font.PLAIN, 16));
                jp1Text.setColumns(35); 
                jp1Text.setAlignmentX(JPanel.LEFT_ALIGNMENT);

                ProjectButton jp1Btn = new ProjectButton(el);      

                jp1Word.setBackground(el.getDisplayColor());
                jp1Word.add(jp1Title);
                jp1Word.add(jp1Text);
                jp1.add(jp1Img);
                jp1.add(jp1Word);
                jp1.add(jp1Btn);

                jp1.setMaximumSize(new Dimension(jp1.getMaximumSize().width, 110));

                centerPane.add(jp1);
            }
        }
        
        this.getTextPanel().add(scrollPane, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
}
