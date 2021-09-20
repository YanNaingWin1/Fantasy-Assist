package model.player;

import model.player.Defender;
import model.team.FootballTeam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class defenderTest {
    Defender playerDf1;
    FootballTeam team4;

    @BeforeEach
    public void setUp() {
        team4 = new FootballTeam("Spurs");
        playerDf1 = new Defender("Reguilon", team4, 5.5);
    }

    @Test
    public void testConstructor() {
        assertEquals("Reguilon", playerDf1.getName());
        assertEquals(team4, playerDf1.getTeam());
        assertEquals(5.5, playerDf1.getPrice());
    }

    @Test
    public void testSetPrice() {
        playerDf1.setPrice(5.6);
        assertEquals(5.6, playerDf1.getPrice());
    }

    @Test
    public void testSetGoalsScored() {
        playerDf1.setGoalsScored(3);
        assertEquals(3, playerDf1.getGoalsScored());
    }

    @Test
    public void testSetGoalsAssisted() {
        playerDf1.setGoalsAssisted(7);
        assertEquals(7, playerDf1.getGoalsAssisted());
    }

    @Test
    public void testSetAppearances() {
        playerDf1.setAppearances(10);
        assertEquals(10, playerDf1.getAppearances());
    }

    @Test
    public void testSetYellowCard() {
        playerDf1.setYellowCard(5);
        assertEquals(5, playerDf1.getYellowCard());
    }

    @Test
    public void testSetRedCard() {
        playerDf1.setRedCard(1);
        assertEquals(1, playerDf1.getRedCard());
    }

    @Test
    public void testSetInjured() {
        playerDf1.setInjured(true);
        assertTrue(playerDf1.isInjured());
    }

    @Test
    public void testSetNotInjured() {
        playerDf1.setInjured(false);
        assertFalse(playerDf1.isInjured());
    }

    @Test
    public void testSetSuspended() {
        playerDf1.setSuspended(true);
        assertTrue(playerDf1.isSuspended());
    }

    @Test
    public void testSetNotSuspended() {
        playerDf1.setSuspended(false);
        assertFalse(playerDf1.isSuspended());
    }

    @Test
    public void testAddPoints() {
        playerDf1.addPoints(6);
        assertEquals(6, playerDf1.getTotalPoints());
        playerDf1.addPoints(2);
        assertEquals(8, playerDf1.getTotalPoints());
    }

    @Test
    public void testSetTacklesMade() {
        playerDf1.setTacklesMade(34);
        assertEquals(34, playerDf1.getTacklesMade());
    }

    @Test
    public void testSetGoalsConceded() {
        playerDf1.setGoalsConceded(5);
        assertEquals(5, playerDf1.getGoalsConceded());
    }

    @Test
    public void testSetCleanSheet() {
        playerDf1.setCleanSheet(10);
        assertEquals(10, playerDf1.getCleanSheet());
    }
}
