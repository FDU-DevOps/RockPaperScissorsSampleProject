package org.fdu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RpsUiTest {

    @Test
    @DisplayName("Echo parameter passed")
    void echo() {
        assertEquals("random message", RpsUi.echo("random message"), "messages did not match");
    }
}