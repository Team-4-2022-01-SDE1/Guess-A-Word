package com.guessaword.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    Player player;

    @Before
    public void setUp() {
        player = new Player("Jay");
    }

    @Test
    public void testGetName_returnsTrue_stringMatchesGetNameReturn() {
        assertEquals("Jay", player.getName());
    }

    @Test
    public void testSetName_returnsTrue_stringSetNameAndCheckIfGetNameReturnsSame() {
        player.setName("Jeff");
        assertEquals("Jeff", player.getName());
    }

    @Test
    public void testGetId_returnsTrue_testsFirstPlayerCreatedAndSetIdIncrementsValue() {
        assertEquals(0, player.getPlayerId());
    }
}