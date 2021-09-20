package model.player;

import model.player.*;
import model.team.FootballTeam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class goalkeeperTest {

    Goalkeeper playerGk1;
    FootballTeam team1;

    @BeforeEach
    public void setUp() {
        team1 = new FootballTeam("Arsenal");
        playerGk1 = new Goalkeeper("Leno", team1, 5.0);
    }

    @Test
    public void testConstructor() {
        assertEquals("Leno", playerGk1.getName());
        assertEquals(team1, playerGk1.getTeam());
        assertEquals(5.0, playerGk1.getPrice());
    }

    @Test
    public void testSetPrice() {
        playerGk1.setPrice(5.1);
        assertEquals(5.1, playerGk1.getPrice());
    }

    @Test
    public void testSetAppearances() {
        playerGk1.setAppearances(10);
        assertEquals(10, playerGk1.getAppearances());
    }

    @Test
    public void testSetYellowCard() {
        playerGk1.setYellowCard(5);
        assertEquals(5, playerGk1.getYellowCard());
    }

    @Test
    public void testSetRedCard() {
        playerGk1.setRedCard(1);
        assertEquals(1, playerGk1.getRedCard());
    }

    @Test
    public void testSetInjured() {
        playerGk1.setInjured(true);
        assertTrue(playerGk1.isInjured());
    }

    @Test
    public void testSetNotInjured() {
        playerGk1.setInjured(false);
        assertFalse(playerGk1.isInjured());
    }

    @Test
    public void testSetSuspended() {
        playerGk1.setSuspended(true);
        assertTrue(playerGk1.isSuspended());
    }

    @Test
    public void testSetNotSuspended() {
        playerGk1.setSuspended(false);
        assertFalse(playerGk1.isSuspended());
    }

    @Test
    public void testAddPoints() {
        playerGk1.addPoints(6);
        assertEquals(6, playerGk1.getTotalPoints());
        playerGk1.addPoints(8);
        assertEquals(14, playerGk1.getTotalPoints());
    }

    @Test
    public void testSetSavesMade() {
        playerGk1.setSavesMade(30);
        assertEquals(30, playerGk1.getSavesMade());
    }

    @Test
    public void testSetGoalsConceded() {
        playerGk1.setGoalsConceded(5);
        assertEquals(5, playerGk1.getGoalsConceded());
    }

    @Test
    public void testSetCleanSheet() {
        playerGk1.setCleanSheet(10);
        assertEquals(10, playerGk1.getCleanSheet());
    }
}
