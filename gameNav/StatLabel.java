package gameNav;

import java.text.DecimalFormat;

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
        boolean isNeg = num < 0;
        if (num == 0) return "0.00";

        int tkd = (int)(Math.log10(Math.abs(num)));
        String format = "0.00E0";

        switch (tkd % 3)
        {
            case 1:
                format = "00.00E0";
            break;

            case 2:
                format = "000.00E0";
            break;
        }
        
        String str = new DecimalFormat(format).format(num);

        if (str.indexOf("E0") != -1)
        {
            str = str.replace("E0", "");
        }
        return isNeg ? "-" + str : str;
    }

    /**
     * Calibrates a number whole.
     * @param num The num to calibrate
     * @return The calibrated num, but without decimals
     */
    public static String calibrateWhole(double num)
    {
        boolean isNeg = num < 0;
        if (num == 0) return "0";

        int tkd = (int)(Math.log10(Math.abs(num)));
        String format = "0E0";

        switch (tkd % 3)
        {
            case 1:
                format = "00E0";
            break;

            case 2:
                format = "000E0";
            break;
        }

        String str = new DecimalFormat(format).format(num);

        if (str.indexOf("E0") != -1)
        {
            str = str.replace("E0", "");
        } 

        return isNeg ? "-" + str : str;
    }

    //There's alot more code but String.format was way more efficient lol
}
