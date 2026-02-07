package org.fdu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

import static org.fdu.Throw.*;
import static org.fdu.RpsEvaluation.*;

class RpsEvaluationTest {

    @Test
    @DisplayName("Verify game returns the correct winner for a tie")
    void evaluateThrowsTest() {
        // evaluate returns a GameOutcomeEnum of NPC_WINS, PLAYER_WINS or TIE
       // ties - if player & npc throw are the same
        // step 1
        RpsEnum rock = RpsEnum.ROCK;
        assertEquals(GameOutcomeEnum.TIE, evaluateThrows(rock, RpsEnum.ROCK), "Two rocks and No Tie!");
        // step 2
        RpsEnum paper = RpsEnum.PAPER;
        assertEquals(GameOutcomeEnum.TIE, evaluateThrows(paper, RpsEnum.PAPER), "Two rocks and No Tie!");
        RpsEnum scissors = RpsEnum.SCISSORS;
        assertEquals(GameOutcomeEnum.TIE, evaluateThrows(scissors, RpsEnum.SCISSORS), "Two rocks and No Tie!");
        // step 3
        RpsEnum invalid = RpsEnum.INVALID;
        // assertEquals(GameOutcomeEnum.TIE, evaluateThrows(invalid, RpsEnum.INVALID), "Two rocks and No Tie!");
        // step 4
        GameOutcomeEnum result = evaluateThrows(invalid, RpsEnum.INVALID);
        assertNull(result);
    }

    @Test
    @DisplayName("Verify game correctly assesses the winner when throws are different")
    void evaluateThrowsTest_NonTies() {
        // rock dulls scissors - player should win
        assertEquals(GameOutcomeEnum.PLAYER_WINS, evaluateThrows(RpsEnum.ROCK, RpsEnum.SCISSORS),
                "Player Rock didn't dull scissors!");
        assertEquals(GameOutcomeEnum.NPC_WINS, evaluateThrows(RpsEnum.SCISSORS, RpsEnum.ROCK),
                "Player Scissors didn't get dulled by NPC's rock!");
        // Paper covers rock
        assertEquals(GameOutcomeEnum.PLAYER_WINS, evaluateThrows(RpsEnum.PAPER, RpsEnum.ROCK),
                "Player Paper didn't cover the rock!");
        assertEquals(GameOutcomeEnum.NPC_WINS, evaluateThrows(RpsEnum.ROCK, RpsEnum.PAPER),
                "Player Rock didn't get covered by NPC's paper!");
        // Scissors cut paper
        assertEquals(GameOutcomeEnum.PLAYER_WINS, evaluateThrows(RpsEnum.SCISSORS, RpsEnum.PAPER),
                "Player scissors didn't cut the paper!");
        assertEquals(GameOutcomeEnum.NPC_WINS, evaluateThrows(RpsEnum.PAPER, RpsEnum.SCISSORS),
                "Player paper didn't get cut by NPC's scissors!");
    }
}