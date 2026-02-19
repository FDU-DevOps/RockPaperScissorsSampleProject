package org.fdu;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        RpsUi.uiWriteMessage("Rock Paper Scissors!");
        RpsUi.uiWriteMessage("Type: rock, paper, scissors (or 'quit' to exit)\n");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            RpsUi.uiWriteMessage("Your throw:");
            String input = scanner.nextLine();

            // allow quitting
            if (input != null && input.trim().equalsIgnoreCase("quit")) {
                RpsUi.uiWriteMessage("Goodbye!");
                break;
            }

            // parse player throw
            Throw.RpsEnum playerThrow = Throw.parseThrow(input);

            if (playerThrow == Throw.RpsEnum.INVALID) {
                RpsUi.uiWriteMessage("Invalid input. Please type rock, paper, or scissors.\n");
                continue;
            }

            // npc throw
            Throw.RpsEnum npcThrow = Throw.getRandomThrow();

            // evaluate
            RpsEvaluation.GameOutcomeEnum outcome =
                    RpsEvaluation.evaluateThrows(playerThrow, npcThrow);

            // print round summary
            RpsUi.uiWriteMessage("You threw: " + playerThrow);
            RpsUi.uiWriteMessage("NPC threw: " + npcThrow);

            switch (outcome) {
                case PLAYER_WINS:
                    RpsUi.uiWriteMessage("Result: You win!\n");
                    break;
                case NPC_WINS:
                    RpsUi.uiWriteMessage("Result: NPC wins!\n");
                    break;
                case TIE:
                    RpsUi.uiWriteMessage("Result: Tie!\n");
                    break;
                default:
                    RpsUi.uiWriteMessage("Result: Error evaluating game.\n");
            }
        }

        scanner.close();
    }
}