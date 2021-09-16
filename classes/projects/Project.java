package classes.projects;

import java.awt.Color;

/**
 * The base template for all projects that could be constructed or initiated.
 * @author Justin
 * @since 9/16/21
 * @category classes.projects
 */
public class Project 
{
    /**
     * Le name of le project
     */
    protected String name;

    /**
     * Kinda self explanatory tbh, but it's a description. Also will be displayed.
     */
    protected String description;

    /**
     * Le cost to unlock/execute the project. It might scale as coins increase. 
     * Fore more accurate cost calculations, you should use calculateCost() method. 
     * But this is just the base cost.
     */
    protected double cost;

    /**
     * The maximum number of times this project could be executed without a single click. 
     * This is to stop autoclickers from exploiting anything.
     */
    protected int maxExec;

    /**
     * Now that we're kinda not doing an APCSA project anymore, we could probably stop doing braindead setter and getter methods
     * But ye, path to image.
     */
    private String image;

    /**
     * Number of times this initiative has been used without resetting
     */
    protected int numClicked;

    /**
     * The display header color for this project
     */
    protected Color color;

    /**
     * Constructs the base project.
     * @param name Le name of le project
     * @param desc Le description
     * @param cost Le base cost
     * @param maxExec Le max exec time
     * @param image Le path to le image
     * @param color Le color to highlight over
     */
    public Project(String name, String desc, double cost, int maxExec, String image, Color color)
    {
        this.name = name;
        this.description = desc;
        this.cost = cost;
        this.maxExec = maxExec;
        this.image = image;
        this.numClicked = 0;
        this.color = color;
    }    

    /**
     * Returns the display color that will be used to highlight
     * @return this.color
     */
    public Color getDisplayColor()
    {
        return this.color;
    }

    /**
     * Calculates the cost of the project. 
     * @return The base project cost
     */
    public double calculateCost()
    {
        return this.cost;
    }

    /**
     * @return Whether or not this project initiative will be available.
     */
    public boolean determineDisplay()
    {
        return true;
    }

    /**
     * Accessor method for name
     * @return this.name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Accessor method for desc
     * @return this.description
     */
    public String getDesc()
    {
        return this.description;
    }

    /**
     * Accessor for image
     * @return this.image
     */
    public String getImage()
    {
        return this.image;
    }

    /**
     * Accessor method for cost
     * @return this.cost
     */
    public double getCost()
    {
        return this.cost;
    }

    /**
     * Returns whether or not the user could still click this method
     * @return this.numClicked < this.maxExec
     */
    public boolean canClick()
    {
        return this.numClicked < this.maxExec;
    }

    /**
     * Initiates a project. 
     * This function is meant to be overridden.
     */
    public void initiate() {}

    /**
     * Recalibrates the numClicked, or in other words, resets that thing. 
     * @return whether or not the calibration is 0
     */
    public boolean recalibrate()
    {
        this.numClicked = 0;
        return true;
    }

    /**
     * Increment numClicked by 1
     */
    public void addNumClicked()
    {
        this.numClicked++;
    }
}
