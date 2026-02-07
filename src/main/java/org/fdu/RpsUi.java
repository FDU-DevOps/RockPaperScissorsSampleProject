package org.fdu;

/**
 * UI class - supports writing to console and reading user input and returning to caller
 *
 * <p>Stateless and content unaware.  The UI methods do not process the input or output</p>
 *
 * @author tbd
 * @version 1.0.0
 * @since 2026-01-10
 */

public class RpsUi {

    /** empty constructor - utility class - assumed all methods called statically */
    RpsUi() {    }

    /**
     * Writes the provided String to the console.
     * @param message - String to be output to the console
     */
    public static void uiWriteMessage(String message) {
        System.out.println(message);
    }

    /**
     * Echos (returns) the String passed to it.
     * Purpose: support creation of a simple test class and case for JUnit workshop
     * @param message - String to be echoed back to the sender
     */
    public static String echo(String message) {
        return (message);
    }
}
