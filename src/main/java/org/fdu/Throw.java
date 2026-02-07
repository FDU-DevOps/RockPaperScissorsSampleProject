package org.fdu;

import java.util.Random;

/**
 * Throw class - stateless, static utility to normalize and cleanup player input, and generate random npc throws.
 * <p>
 * Scope: <br>
 *         defines enum for throws including INVALID <br>
 *         normalizes throw (e.g. removes white space, converts to all lower case) w/ no validation <br>
 *         validates / parses guess (ie one of “rock”, “paper”, “scissors”) <br>
 *         includes method to return a random, valid throw as an enum
 */

public class Throw {
    /**
     * Enum reflecting the different types of throws - rock, paper or scissors <br>
     * includes a value for invalid user input (returned by validation method)
     */
    public enum RpsEnum {
        ROCK, PAPER, SCISSORS,
        INVALID;      /** entered input is invalid */
    }


    /**
     * Cleans up player input for comparison <br>
     * Modify player input to remove leading and trailing whitespace, convert to all lowercase
     *   Refactored to normalize input from parseThrow, ie don't need to normalize prior
     * @param playerInput raw string which player input for their throw
     * @return trimmed, lowercase string, or empty string if input is null
     */
    public static String normalizeThrow(String playerInput) {
        // if (playerInput == null) return "";         // without this, trim would throw a null pointer exception
        return playerInput.trim().toLowerCase();    // trim removes leading and trailing whitespace
    }

    /**
     * Parses normalized player input into an enum representing their choice of throws <br>
     * returns INVALID for incorrect input
     * <p>
     * ToDo: update to enhanced Java switch avail in JDK 21 - cleaner, tighter
     *
     * @param UserInput user input raw or normalized (ie without leading and trailing whitespace and all lowercase)
     * @return - enum representing the user's throw or INVALID
     */
    public static RpsEnum parseThrow(String UserInput) {
        String normalizedUserInput = normalizeThrow(UserInput);
        switch (normalizedUserInput) {
            case "rock":
                return RpsEnum.ROCK;
            case "paper":
                return RpsEnum.PAPER;
            case "scissors":
                return RpsEnum.SCISSORS;
            default:
                return RpsEnum.INVALID;
        }
    }

    private static final Random PRNG = new Random();  // statically initialize, don't reinit every time called

    /**
     * randomly selects one of rock, paper or scissors and returns the associated enum
     * @return - random throw to be associated with npc
     */
    public static RpsEnum getRandomThrow() {
        RpsEnum[] validThrows = {RpsEnum.ROCK, RpsEnum.PAPER, RpsEnum.SCISSORS};
        return validThrows[PRNG.nextInt(validThrows.length)];
    }
}
