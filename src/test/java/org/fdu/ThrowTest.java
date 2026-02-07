package org.fdu;

// JUnit imports - test cases and assertions
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;   // could collapse both into .api.*
import static org.junit.jupiter.api.Assertions.*;

import static org.fdu.Throw.*;

// Throw class access - allows access to static methods without prefix


class ThrowTest {
    @Test
    @DisplayName("Test method to remove leading and trailing white space, and convert to lower case")
    void normalizeThrowTest() {

    String leadingWhitePre = "   Shuffling";
        String leadingWhitePost = "shuffling";
        String trailingWhitePre = "mADNESS   ";
        String trailingWhitePost = "madness";
        String leadingTrailingWhitePre = "\tLoCoMOTIVe\t\n";
        String leadingTrailingWhitePost = "locomotive";
        String midWordWhitePre = "Bre ath";
        String midWordWhitePost = "bre ath";
        String emptyStringPreAndPost = "";
        assertEquals(leadingWhitePost, normalizeThrow(leadingWhitePre),
                "Leading white space not deleted");
        assertEquals(trailingWhitePost, normalizeThrow(trailingWhitePre),
                "Trailing white space not deleted");
        assertEquals(leadingTrailingWhitePost, normalizeThrow(leadingTrailingWhitePre),
                "Leading &/or trailing white space not deleted");
        assertEquals(midWordWhitePost, normalizeThrow(midWordWhitePre),
                "mid-word white space not handled correctly");
        assertEquals(emptyStringPreAndPost, normalizeThrow(emptyStringPreAndPost),
                "empty string not handled correctly");
    // consider null string test
    }  // end normalize input string testing

    //  Start w/ straightforward tests, then
    //    throw non-normalized input
    //    then code-change to call normalizeThrow() from within parseThrow() and verify
    @Test
    @DisplayName("verify rock, paper and scissors are recognized as valid")
    void parseValidThrowTest() {
        // valid - expected throws after normalization
        String rock = "rock";
        String paper = "paper";
        String scissors = "scissors";

        assertEquals(RpsEnum.ROCK, parseThrow(rock),
                "rock not recognized as valid!");
        assertEquals(RpsEnum.PAPER, parseThrow(paper),
                "paper not recognized as valid!");
        assertEquals(RpsEnum.SCISSORS, parseThrow(scissors),
                "scissors not recognized as valid!");

    }
    //    throw valid guesses, but raw input (non-normalized)
    @Test
    @DisplayName("verify rock, paper and scissors are recognized as valid")
    void parseValidRawInputThrowTest() {
        // valid - expected throws after normalization
        String rock = "  RoCk  ";
        String paper = "PAPer\t";
        String scissors = "\tscissorS   ";
        String rockWithBlanks = "ro ck";
        String nullTest = null;

        assertEquals(RpsEnum.ROCK, parseThrow(rock),
                "rock not recognized as valid!");
        assertEquals(RpsEnum.PAPER, parseThrow(paper),
                "paper not recognized as valid!");
        assertEquals(RpsEnum.SCISSORS, parseThrow(scissors),
                "scissors not recognized as valid!");
        assertEquals(RpsEnum.INVALID, parseThrow(rockWithBlanks),
                "embedded blanks not recognized as invalid!");
        // assertEquals(RpsEnum.INVALID, parseThrow(nullTest),
        //              "embedded blanks not recognized as invalid!");
    }

    // invalid throws
    @Test
    @DisplayName("verify invalid throws are identified")
    void parseInvalidThrowTest() {
        String spock = "spock";
        String lizard = "lizard";
        assertEquals(RpsEnum.INVALID, parseThrow(spock),
                "spock should be invalid!");
        assertEquals(RpsEnum.INVALID, parseThrow(lizard),
                "lizard should be invalid!");
    }

    @Test
    @DisplayName("Verify we get a variety of random values and all are valid")
    void getRandomThrowTest() {
        int rock = 0;
        int paper = 0;
        int scissors = 0;
        for (int itr = 0; itr < 10; itr++) {
            // get a random throw and match to rock, paper or scissors
            //   for demo - consider adding spock - two test cases should fail
            switch (getRandomThrow()) {
                case RpsEnum.ROCK:
                    rock++;
                    continue;
                case RpsEnum.PAPER:
                    paper++;
                    continue;
                case RpsEnum.SCISSORS:
                    scissors++;
                    continue;
                default:
                    fail("getRandomThrow() returned an invalid value");
            }
        }
        // boolean = false if any of the values is zero
        System.out.println("rock " + rock + "  paper " + paper + " scissors " + scissors);
        boolean allNonZero = (rock != 0 ) && (paper != 0 ) && (scissors != 0);
        assertTrue (allNonZero, "not all values returned");

    }
}