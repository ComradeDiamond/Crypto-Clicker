package frontend.choiceBar;

import java.awt.*;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 * It's a custom scrollbar design for JScrollPanes
 * Partly because basic design looks older than 2018 javascript and makes me want to vomit
 * @author Justin
 * @since 9/14/21
 * @category frontend.choiceBar
 */
public class CustomScroll extends BasicScrollBarUI
{
    /**
     * Le constructor
     */
    public CustomScroll()
    {
        super();
        this.thumbColor = Color.LIGHT_GRAY;
        this.trackColor = Color.YELLOW;
        this.trackHighlightColor = Color.GRAY;
    }
}
