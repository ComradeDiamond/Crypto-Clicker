package frontend.choiceBar.buttons;

import frontend.choiceBar.*;
import java.awt.event.MouseEvent;
import frontend.choiceBar.displays.*;

/**
 * Constructs a project choicer button that will open up the short-term project operation toolbar
 * @author Justin
 * @since 6/19/21
 * @category frontend.choiceBar.buttons
 */
public class Project extends Choicer
{
    /**
     * The project upgrade screen for this project button
     */
    private ProjectUpgrade pug;
    
    /**
     * Constructs a project
     */
    public Project()
    {
        super("Open up the projects tab and execute some operations", "/images/Project.png");
        Project x = this;
        this.addMouseListener(new SmartListener(this) {
            public void mouseClicked(MouseEvent e) {
                ProjectUpgrade pug = new ProjectUpgrade();
                x.setPug(pug);
                pug.display();
            }
        });
    }

    /**
     * Accessor method for pug
     * @return this.pug
     */
    public ProjectUpgrade getPug()
    {
        return this.pug;
    }

    /**
     * Mutator method for pug
     * @param pug The project upgrade to set this to
     */
    public void setPug(ProjectUpgrade pug)
    {
        this.pug = pug;
    }
}
