package gameNav;

/**
 * When you need someone to fix your sink, you call a plumber. 
 * When you need someone to fix your electricity, you call an electrician.
 * WHEN YOU NEED TO ACTUALLY USE FUNCTIONS LIKE OBJECTS, YOU CALL JAVASCRIPT...
 * Wait hol up why are we using Java
 * @author Justin
 * @since 9/25/21
 * @category gameNav
 */
public class TimedCommand 
{
    /**
     * The number of times the TimedCommand will run before it expires
     */
    private int timer;

    /**
     * Constructs a timed command
     * @param timer The number of times this will count down
     */
    public TimedCommand(int timer)
    {
        this.timer = timer;
    }

    /**
     * Node.js: "If I were you, I'd wish to be me too."
     * Make sure your execute() will have a stop feature or it'll run forever
     * @return Whether the click command should continue executing
     */
    public boolean execute()
    {
        return true;
    }

    /**
     * Subtracts 1 from the countdown timer
     * @return Whether or not the timer has hit 0
     */
    public boolean runTimer()
    {
        this.timer--;
        return this.timer == 0;
    }
}
