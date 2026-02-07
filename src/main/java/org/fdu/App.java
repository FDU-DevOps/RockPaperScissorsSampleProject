package org.fdu;

import org.fdu.Throw.RpsEnum;

/**
 * A console-based implementation of the classic Rock Paper Scissors game.
 * This application allows a user to play against a computer opponent using
 * standard win/loss logic.
 *
 * <p>Standard rules apply: Rock beats Scissors, Scissors beats Paper,
 * and Paper beats Rock.</p>
 *
 * @author many!
 * @version 1.0.0
 * @since 2026-01-10
 */

public class App 
{
    public static void main( String[] args ) {
        RpsUi.uiWriteMessage( "Hello World!" );
        System.out.println(Throw.getRandomThrow().name());
    }
}
