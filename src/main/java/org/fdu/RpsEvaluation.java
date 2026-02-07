package org.fdu;

/**
 * Evaluation class - static, stateless - evaluates player and npc throw according to the game logic
 * Returns the result of the game play (e.g. player won, npc won, tie)
 */
public class RpsEvaluation {

    /**
     * Enum describing game outcomes
     */
    public enum GameOutcomeEnum {
        PLAYER_WINS,
        NPC_WINS,
        TIE
    }

    /**
     * Evaluates winner based on player and npc throws (player wins, npc wins, tie)
     * @param playerThrow - enum of Players choice - rock, paper or scissors
     * @param npcThrow - enum of NPC's choice - rock, paper or scissors
     * @return - returns enum with the game outcome (Player wins, npc wins or it's a tie
     */
    public static GameOutcomeEnum evaluateThrows(Throw.RpsEnum playerThrow, Throw.RpsEnum npcThrow) {
        if ((playerThrow == Throw.RpsEnum.INVALID) || (npcThrow == Throw.RpsEnum.INVALID))
            return null;
        if (playerThrow == npcThrow) {
            return GameOutcomeEnum.TIE;
        }
        // refactored to group by player win vs. npc win
        // since ties checked above, if player doesn't win on a throw, break drops down to return NPC won
        switch (playerThrow) {
            case ROCK:
                if (npcThrow == Throw.RpsEnum.SCISSORS) // rock dulls scissors
                    return GameOutcomeEnum.PLAYER_WINS;
                break;
            case SCISSORS:
                if (npcThrow == Throw.RpsEnum.PAPER)    // scissors cut paper
                    return GameOutcomeEnum.PLAYER_WINS;
                break;
            case PAPER:
                if (npcThrow == Throw.RpsEnum.ROCK)    // paper covers rock
                    return GameOutcomeEnum.PLAYER_WINS;
                break;
            default:
                return null;   // invalid enum, should never happen, should throw exception (ToDo)
        } // end of player win scenarios, if get past here, NPC won
        return GameOutcomeEnum.NPC_WINS;
    }  // end evaluate throws method
}  // end RpsEvaluation class
