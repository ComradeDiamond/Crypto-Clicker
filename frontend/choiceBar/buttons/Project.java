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
        super("Open up the projects tab and execute some operations", "images/Project.png");
        this.pug = new ProjectUpgrade();
        super.addMouseListener(new SmartListener(this) {
            public void mouseClicked(MouseEvent e) {
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
}
