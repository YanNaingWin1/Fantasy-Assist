package model.player;

import model.player.Striker;
import model.team.FootballTeam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class strikerTest {
    Striker playerSt1;
    FootballTeam team3;

    @BeforeEach
    public void setUp() {
        team3 = new FootballTeam("ManUtd");
        playerSt1 = new Striker("Martial", team3, 8.0);
    }

    @Test
    public void testConstructor() {
        assertEquals("Martial", playerSt1.getName());
        assertEquals(team3, playerSt1.getTeam());
        assertEquals(8.0, playerSt1.getPrice());
    }

    @Test
    public void testSetPrice() {
        playerSt1.setPrice(6.1);
        assertEquals(6.1, playerSt1.getPrice());
    }

    @Test
    public void testSetGoalsScored() {
        playerSt1.setGoalsScored(14);
        assertEquals(14, playerSt1.getGoalsScored());
    }

    @Test
    public void testSetGoalsAssisted() {
        playerSt1.setGoalsAssisted(6);
        assertEquals(6, playerSt1.getGoalsAssisted());
    }

    @Test
    public void testSetAppearances() {
        playerSt1.setAppearances(10);
        assertEquals(10, playerSt1.getAppearances());
    }

    @Test
    public void testSetYellowCard() {
        playerSt1.setYellowCard(5);
        assertEquals(5, playerSt1.getYellowCard());
    }

    @Test
    public void testSetRedCard() {
        playerSt1.setRedCard(1);
        assertEquals(1, playerSt1.getRedCard());
    }

    @Test
    public void testSetInjured() {
        playerSt1.setInjured(true);
        assertTrue(playerSt1.isInjured());
    }

    @Test
    public void testSetNotInjured() {
        playerSt1.setInjured(false);
        assertFalse(playerSt1.isInjured());
    }

    @Test
    public void testSetSuspended() {
        playerSt1.setSuspended(true);
        assertTrue(playerSt1.isSuspended());
    }

    @Test
    public void testSetNotSuspended() {
        playerSt1.setSuspended(false);
        assertFalse(playerSt1.isSuspended());
    }

    @Test
    public void testAddPoints() {
        playerSt1.addPoints(6);
        assertEquals(6, playerSt1.getTotalPoints());
        playerSt1.addPoints(4);
        assertEquals(10, playerSt1.getTotalPoints());
    }
}
