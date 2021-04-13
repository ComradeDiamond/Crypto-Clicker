package gameNav;

/**
 * Superclass for investor, supply, and cash display.
 * This class is largely useless aside from a method determining how number rounding works
 * @author Justin
 * @since 4/13/21
 * @category gameNav
 */
public class StatLabel
{
    /**
     * Takes a number, and returns the trimmed version of it.
     * 45,434 --> 45.43K
     * @param num The number to calibrate
     * @return The calibrated number
     */
    public static String calibrate(double num)
    {
        String textDisplay = "";

        if (num < 1000)
        {
            textDisplay += num;
        }
        else if (num < 1000000) //Thousand
        {
            textDisplay += roundFix(num, 1000) + "K";
        }
        else if (num < 1000000000) //Million
        {
            textDisplay += roundFix(num, 1000000) + "M";
        }
        else if (num < 1000000000000.0) //Billion
        {
            textDisplay += roundFix(num, 1000000000) + "B";
        }
        else if (num < 1000000000000000.0) //Trillion
        {
            textDisplay += roundFix(num, 1000000000000.0) + "T";
        }
        else //Quadrillion, if someone somehow manages to get to quadrillion
        {
            textDisplay += roundFix(num, 1000000000000000000.0) + " Quadrillion";
        }

        return textDisplay;
    }

    /**
     * Collapses a number to its place value + 2 decimal points
     * For example, 3,456 becomes 3.45
     * 442,123 becomes 442.12
     * @param num Number
     * @param placeVal Place value to round to
     * @return Rounded number
     */
    private static double roundFix(double num, double placeVal)
    {
        return num / placeVal - (num % (placeVal / 100)) / (placeVal);
    }
}
