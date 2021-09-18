package classes.projects;

/**
 * A more advanced autoclicker for the rest of the coins.
 * This performs 1,000 clicks and scales in cost. 
 * It's mainly created because in the late game, there's more stable coin control measures.
 * @author Justin
 * @since 9/16/21
 * @category classes.projects
 */
public class Autoclicker2 extends Autoclicker
{
    /**
     * Constructs an autoclicker2 object, and fixes up some lore stuff. 
     */
    public Autoclicker2()
    {
        this.tickerations = 1000;
        this.name = "Autoclicker 3000";
        this.description = "Invest in an upgraded version of Autoclicker 2000 and execute 1000 clicks. Does not come with warranty.";
    }

    /**
     * Determines whether this autoclicker would be displayed
     * @return Whether the coin is Dogecoin, pepecoin, and bitcoin
     */
    public boolean determineDisplay()
    {
        return !super.determineDisplay();
    }
}
