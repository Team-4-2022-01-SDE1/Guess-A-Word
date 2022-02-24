package com.guessaword.model.board;

import com.guessaword.model.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserPanelTest {
    UserPanel userPanel;
    String username = "Jay";
    Player player;

    @Before
    public void setUp() {
        userPanel = UserPanel.getInstance();
        player = new Player(username);
    }

    @Test
    public void testValidateNewUserName_returnsFalse_nameWasFound() {
        assertFalse(userPanel.validateNewUserName(username));
    }

    @Test
    public void testShow_returnsTrue_playerWasPassedThroughMethod() {
        assertEquals(player, userPanel.show(player));
    }

    @Test
    public void testUpdate_returnsTrue_playerWasAddedToPlayersList() {
        userPanel.update(player);
        assertEquals(1, userPanel.getPlayers().size());
    }
}