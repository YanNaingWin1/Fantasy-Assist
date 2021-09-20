package model.player;

import model.player.Midfielder;
import model.team.FootballTeam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class midfielderTest {
    Midfielder playerMd1;
    FootballTeam team2;

    @BeforeEach
    public void setUp() {
        team2 = new FootballTeam("Liverpool");
        playerMd1 = new Midfielder("Henderson", team2, 6.0);
    }

    @Test
    public void testConstructor() {
        assertEquals("Henderson", playerMd1.getName());
        assertEquals(team2, playerMd1.getTeam());
        assertEquals(6.0, playerMd1.getPrice());
    }

    @Test
    public void testSetPrice() {
        playerMd1.setPrice(6.1);
        assertEquals(6.1, playerMd1.getPrice());
    }

    @Test
    public void testSetGoalsScored() {
        playerMd1.setGoalsScored(8);
        assertEquals(8, playerMd1.getGoalsScored());
    }

    @Test
    public void testSetGoalsAssisted() {
        playerMd1.setGoalsAssisted(5);
        assertEquals(5, playerMd1.getGoalsAssisted());
    }

    @Test
    public void testSetAppearances() {
        playerMd1.setAppearances(10);
        assertEquals(10, playerMd1.getAppearances());
    }

    @Test
    public void testSetYellowCard() {
        playerMd1.setYellowCard(5);
        assertEquals(5, playerMd1.getYellowCard());
    }

    @Test
    public void testSetRedCard() {
        playerMd1.setRedCard(1);
        assertEquals(1, playerMd1.getRedCard());
    }

    @Test
    public void testSetInjured() {
        playerMd1.setInjured(true);
        assertTrue(playerMd1.isInjured());
    }

    @Test
    public void testSetNotInjured() {
        playerMd1.setInjured(false);
        assertFalse(playerMd1.isInjured());
    }

    @Test
    public void testSetSuspended() {
        playerMd1.setSuspended(true);
        assertTrue(playerMd1.isSuspended());
    }

    @Test
    public void testSetNotSuspended() {
        playerMd1.setSuspended(false);
        assertFalse(playerMd1.isSuspended());
    }

    @Test
    public void testAddPoints() {
        playerMd1.addPoints(6);
        assertEquals(6, playerMd1.getTotalPoints());
        playerMd1.addPoints(10);
        assertEquals(16, playerMd1.getTotalPoints());
    }

    @Test
    public void testSetPassesMade() {
        playerMd1.setPassesMade(128);
        assertEquals(128, playerMd1.getPassesMade());
    }

    @Test
    public void testSetChancesCreated() {
        playerMd1.setChancesCreated(23);
        assertEquals(23, playerMd1.getChancesCreated());
    }
}
