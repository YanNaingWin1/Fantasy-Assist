package model.team;

import model.fixture.Fixture;
import model.player.*;
import model.team.FantasyTeam;
import model.team.FootballTeam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class footballTeamTest {

    FootballTeam testTeam;
    FootballTeam testTeam1;
    FootballTeam testTeam2;
    LinkedList<Player> playerList;
    Fixture testFixture;
    Fixture testFixture1;

    Player playerGk1;
    Player playerGk2;
    Player playerGk3;
    Player playerDf1;
    Player playerDf2;
    Player playerDf3;
    Player playerDf4;
    Player playerDf5;
    Player playerDf6;
    Player playerMd1;
    Player playerMd2;
    Player playerMd3;
    Player playerMd4;
    Player playerMd5;
    Player playerMd6;
    Player playerSt1;
    Player playerSt2;
    Player playerSt3;
    Player playerSt4;

    @BeforeEach
    public void setUp() {
        testTeam = new FootballTeam("ManCity");
        testTeam1 = new FootballTeam("Chelsea");
        testTeam2 = new FootballTeam("Spurs");
        playerList = new LinkedList<>();
        testFixture = new Fixture(testTeam, testTeam1, "Etihad");
        testFixture1 = new Fixture(testTeam2, testTeam, "Hotspurs");

        playerGk1 = new Goalkeeper("Ederson", testTeam, 5.5);
        playerGk2 = new Goalkeeper("Steffen", testTeam, 4.5);
        playerGk3 = new Goalkeeper("Carson", testTeam, 4.0);
        playerDf1 = new Defender("Dias", testTeam, 6.0);
        playerDf2 = new Defender("Stones", testTeam, 5.0);
        playerDf3 = new Defender("Cancelo", testTeam, 5.5);
        playerDf4 = new Defender("Walker", testTeam, 5.5);
        playerDf5 = new Defender("Laporte", testTeam, 5.0);
        playerDf6 = new Defender("Zinchenko", testTeam, 5.0);
        playerMd1 = new Midfielder("De Bruyne", testTeam, 11.5);
        playerMd2 = new Midfielder("Gundogan", testTeam, 6.5);
        playerMd3 = new Midfielder("Rodri", testTeam, 5.0);
        playerMd4 = new Midfielder("Foden", testTeam, 8.0);
        playerMd5 = new Midfielder("Bernardo", testTeam, 7.0);
        playerMd6 = new Midfielder("Mahrez", testTeam, 8.5);
        playerSt1 = new Striker("Jesus", testTeam, 7.5);
        playerSt2 = new Striker("Sterling", testTeam, 9.5);
        playerSt3 = new Striker("Delap", testTeam, 4.0);
        playerSt4 = new Striker("Palmer", testTeam, 4.0);

        playerList.add(playerGk1);
        playerList.add(playerGk2);
        playerList.add(playerDf1);
        playerList.add(playerDf2);
        playerList.add(playerDf3);
        playerList.add(playerDf4);
        playerList.add(playerDf5);
        playerList.add(playerMd1);
        playerList.add(playerMd2);
        playerList.add(playerMd3);
        playerList.add(playerMd4);
        playerList.add(playerMd5);
        playerList.add(playerSt1);
        playerList.add(playerSt2);
        playerList.add(playerSt3);
    }

    public void addMaxPlayersInFantasyTeam() {
        for (int i = 0; i < FantasyTeam.MAX_NUM_PLAYERS_IN_FANTASY; i++) {
            testTeam.addPlayer(playerList.get(i));
        }
    }

    @Test
    public void testConstructor() {
        assertTrue(testTeam.isEmpty());
        assertFalse(testTeam.isFull());
        assertEquals(0, testTeam.length());
    }

    @Test
    public void testAdd1Player() {
        testTeam.addPlayer(playerGk1);
        assertFalse(testTeam.isEmpty());
        assertTrue(testTeam.containsPlayer(playerGk1));
        assertEquals(1, testTeam.length());
    }

    @Test
    public void testAdd2ButDuplicatePlayer() {
        testTeam.addPlayer(playerGk1);
        assertFalse(testTeam.isEmpty());
        assertTrue(testTeam.containsPlayer(playerGk1));
        assertEquals(1, testTeam.length());
        testTeam.addPlayer(playerGk1);
        assertTrue(testTeam.containsPlayer(playerGk1));
        assertEquals(1, testTeam.length());
    }

    @Test
    public void testAdd1PlayerWith14SlotsOccupied() {
        for (int i = 0; i < (FantasyTeam.MAX_NUM_PLAYERS_IN_FANTASY - 1); i++) {
            testTeam.addPlayer(playerList.get(i));
        }
        testTeam.addPlayer(playerSt3);
        assertTrue(testTeam.isFull());
        assertEquals(15, testTeam.length());
        for (int i = 0; i < FantasyTeam.MAX_NUM_PLAYERS_IN_FANTASY; i++) {
            assertTrue(testTeam.containsPlayer(playerList.get(i)));
        }
    }

    @Test
    public void testAdd1PlayerWithAllSlotsOccupied() {
        addMaxPlayersInFantasyTeam();
        assertTrue(testTeam.isFull());
        assertEquals(15, testTeam.length());
        for (int i = 0; i < FantasyTeam.MAX_NUM_PLAYERS_IN_FANTASY; i++) {
            assertTrue(testTeam.containsPlayer(playerList.get(i)));
        }
        testTeam.addPlayer(playerDf6);
        assertTrue(testTeam.isFull());
        assertEquals(15, testTeam.length());
        for (int i = 0; i < FantasyTeam.MAX_NUM_PLAYERS_IN_FANTASY; i++) {
            assertTrue(testTeam.containsPlayer(playerList.get(i)));
        }
    }

    @Test
    public void testAdd2Gk() {
        assertFalse(testTeam.containsAllGoalkeepers());
        testTeam.addPlayer(playerGk1);
        testTeam.addPlayer(playerGk2);
        assertFalse(testTeam.isEmpty());
        assertEquals(2, testTeam.getGoalkeeperCount());
        assertTrue(testTeam.containsAllGoalkeepers());
        assertEquals(2, testTeam.length());
    }

    @Test
    public void testAdd2GksAnd1MoreGk() {
        assertFalse(testTeam.containsAllGoalkeepers());
        testTeam.addPlayer(playerGk1);
        testTeam.addPlayer(playerGk2);
        assertEquals(2, testTeam.getGoalkeeperCount());
        assertTrue(testTeam.containsAllGoalkeepers());
        assertEquals(2, testTeam.length());
        testTeam.addPlayer(playerGk3);
        assertEquals(2, testTeam.getGoalkeeperCount());
        assertTrue(testTeam.containsAllGoalkeepers());
        assertEquals(2, testTeam.length());
    }

    @Test
    public void testAdd5Def() {
        assertFalse(testTeam.containsAllDefenders());
        testTeam.addPlayer(playerDf1);
        testTeam.addPlayer(playerDf2);
        testTeam.addPlayer(playerDf3);
        testTeam.addPlayer(playerDf4);
        testTeam.addPlayer(playerDf5);
        assertEquals(5, testTeam.getDefenderCount());
        assertTrue(testTeam.containsAllDefenders());
        assertEquals(5, testTeam.length());
    }

    @Test
    public void testAdd5DefAnd1MoreDef() {
        assertFalse(testTeam.containsAllDefenders());
        testTeam.addPlayer(playerDf1);
        testTeam.addPlayer(playerDf2);
        testTeam.addPlayer(playerDf3);
        testTeam.addPlayer(playerDf4);
        testTeam.addPlayer(playerDf5);
        assertEquals(5, testTeam.getDefenderCount());
        assertTrue(testTeam.containsAllDefenders());
        assertEquals(5, testTeam.length());
        testTeam.addPlayer(playerDf6);
        assertEquals(5, testTeam.getDefenderCount());
        assertTrue(testTeam.containsAllDefenders());
        assertEquals(5, testTeam.length());
    }

    @Test
    public void testAdd5Mid() {
        assertFalse(testTeam.containsAllMidfielders());
        testTeam.addPlayer(playerMd1);
        testTeam.addPlayer(playerMd2);
        testTeam.addPlayer(playerMd3);
        testTeam.addPlayer(playerMd4);
        testTeam.addPlayer(playerMd5);
        assertEquals(5, testTeam.getMidfielderCount());
        assertTrue(testTeam.containsAllMidfielders());
        assertEquals(5, testTeam.length());
    }

    @Test
    public void testAdd5MidAnd1MoreMid() {
        assertFalse(testTeam.containsAllMidfielders());
        testTeam.addPlayer(playerMd1);
        testTeam.addPlayer(playerMd2);
        testTeam.addPlayer(playerMd3);
        testTeam.addPlayer(playerMd4);
        testTeam.addPlayer(playerMd5);
        assertEquals(5, testTeam.getMidfielderCount());
        assertTrue(testTeam.containsAllMidfielders());
        assertEquals(5, testTeam.length());
        testTeam.addPlayer(playerMd6);
        assertEquals(5, testTeam.getMidfielderCount());
        assertTrue(testTeam.containsAllMidfielders());
        assertEquals(5, testTeam.length());
    }

    @Test
    public void testAdd3St() {
        assertFalse(testTeam.containsAllStrikers());
        testTeam.addPlayer(playerSt1);
        testTeam.addPlayer(playerSt2);
        testTeam.addPlayer(playerSt3);
        assertEquals(3, testTeam.getStrikerCount());
        assertTrue(testTeam.containsAllStrikers());
        assertEquals(3, testTeam.length());
    }

    @Test
    public void testAdd3StAnd1MoreSt() {
        assertFalse(testTeam.containsAllStrikers());
        testTeam.addPlayer(playerSt1);
        testTeam.addPlayer(playerSt2);
        testTeam.addPlayer(playerSt3);
        assertEquals(3, testTeam.getStrikerCount());
        assertTrue(testTeam.containsAllStrikers());
        assertEquals(3, testTeam.length());
        testTeam.addPlayer(playerSt4);
        assertEquals(3, testTeam.getStrikerCount());
        assertTrue(testTeam.containsAllStrikers());
        assertEquals(3, testTeam.length());
    }

    @Test
    public void testRemoveExistingPlayer() {
        testTeam.addPlayer(playerDf3);
        assertEquals(1, testTeam.length());
        assertTrue(testTeam.containsPlayer(playerDf3));
        assertFalse(testTeam.isEmpty());
        assertEquals(1, testTeam.getDefenderCount());
        testTeam.removePlayer(playerDf3);
        assertEquals(0, testTeam.length());
        assertFalse(testTeam.containsPlayer(playerDf3));
        assertTrue(testTeam.isEmpty());
        assertEquals(0, testTeam.getDefenderCount());
    }

    @Test
    public void testRemoveNonExistingPlayer() {
        testTeam.addPlayer(playerDf3);
        assertEquals(1, testTeam.length());
        assertTrue(testTeam.containsPlayer(playerDf3));
        assertFalse(testTeam.isEmpty());
        assertEquals(1, testTeam.getDefenderCount());
        testTeam.removePlayer(playerSt3);
        assertEquals(1, testTeam.length());
        assertTrue(testTeam.containsPlayer(playerDf3));
        assertFalse(testTeam.isEmpty());
        assertEquals(1, testTeam.getDefenderCount());
    }

    @Test
    public void testAddPlayerWithANonExistingPosition() {
        Player playerEe1 = new Goalkeeper("Edgar", testTeam, 9.5);
        playerEe1.setPosition("Sweeper");
        testTeam.addPlayer(playerEe1);
        assertEquals(0, testTeam.length());
        assertFalse(testTeam.getTeam().contains(playerEe1));
    }

    @Test
    public void testRemoveGoalkeeper() {
        testTeam.addPlayer(playerGk1);
        assertEquals(1, testTeam.length());
        assertTrue(testTeam.containsPlayer(playerGk1));
        assertFalse(testTeam.isEmpty());
        assertEquals(1, testTeam.getGoalkeeperCount());
        testTeam.removePlayer(playerGk1);
        assertEquals(0, testTeam.length());
        assertFalse(testTeam.containsPlayer(playerGk1));
        assertTrue(testTeam.isEmpty());
        assertEquals(0, testTeam.getGoalkeeperCount());
    }

    @Test
    public void testRemoveDefender() {
        testTeam.addPlayer(playerDf3);
        assertEquals(1, testTeam.length());
        assertTrue(testTeam.containsPlayer(playerDf3));
        assertFalse(testTeam.isEmpty());
        assertEquals(1, testTeam.getDefenderCount());
        testTeam.removePlayer(playerDf3);
        assertEquals(0, testTeam.length());
        assertFalse(testTeam.containsPlayer(playerDf3));
        assertTrue(testTeam.isEmpty());
        assertEquals(0, testTeam.getDefenderCount());
    }

    @Test
    public void testRemoveMidfielder() {
        testTeam.addPlayer(playerMd2);
        assertEquals(1, testTeam.length());
        assertTrue(testTeam.containsPlayer(playerMd2));
        assertFalse(testTeam.isEmpty());
        assertEquals(1, testTeam.getMidfielderCount());
        testTeam.removePlayer(playerMd2);
        assertEquals(0, testTeam.length());
        assertFalse(testTeam.containsPlayer(playerMd2));
        assertTrue(testTeam.isEmpty());
        assertEquals(0, testTeam.getMidfielderCount());
    }

    @Test
    public void testRemoveStriker() {
        testTeam.addPlayer(playerSt2);
        assertEquals(1, testTeam.length());
        assertTrue(testTeam.containsPlayer(playerSt2));
        assertFalse(testTeam.isEmpty());
        assertEquals(1, testTeam.getStrikerCount());
        testTeam.removePlayer(playerSt2);
        assertEquals(0, testTeam.length());
        assertFalse(testTeam.containsPlayer(playerSt2));
        assertTrue(testTeam.isEmpty());
        assertEquals(0, testTeam.getStrikerCount());
    }

    @Test
    public void testAddFixtureWhileNotContained() {
        assertEquals(0, testTeam.getTeamFixtures().size());
        testTeam.addFixtures(testFixture);
        assertEquals(1, testTeam.getTeamFixtures().size());
        assertEquals(testTeam, testFixture.getHomeTeam());
        assertEquals(testTeam1, testFixture.getAwayTeam());
        assertEquals("Etihad", testFixture.getVenue());
    }

    @Test
    public void testAddFixtureWhileContained() {
        assertEquals(0, testTeam.getTeamFixtures().size());
        testTeam.addFixtures(testFixture);
        assertEquals(1, testTeam.getTeamFixtures().size());
        assertEquals(testTeam, testFixture.getHomeTeam());
        assertEquals(testTeam1, testFixture.getAwayTeam());
        assertEquals("Etihad", testFixture.getVenue());
        testTeam.addFixtures(testFixture);
        assertEquals(1, testTeam.getTeamFixtures().size());
    }

    @Test
    public void testRemoveFixtureWhileContained() {
        assertEquals(0, testTeam.getTeamFixtures().size());
        testTeam.addFixtures(testFixture);
        assertEquals(1, testTeam.getTeamFixtures().size());
        assertEquals(testTeam, testFixture.getHomeTeam());
        assertEquals(testTeam1, testFixture.getAwayTeam());
        testTeam.removeFixtures(testFixture);
        assertEquals(0, testTeam.getTeamFixtures().size());
    }

    @Test
    public void testRemoveFixtureWhileNotContained() {
        assertEquals(0, testTeam.getTeamFixtures().size());
        testTeam.addFixtures(testFixture);
        assertEquals(1, testTeam.getTeamFixtures().size());
        assertEquals(testTeam, testFixture.getHomeTeam());
        assertEquals(testTeam1, testFixture.getAwayTeam());
        testTeam.removeFixtures(testFixture1);
        assertEquals(1, testTeam.getTeamFixtures().size());
        assertEquals(testTeam, testFixture.getHomeTeam());
        assertEquals(testTeam1, testFixture.getAwayTeam());
    }

    @Test
    public void testSetRanking() {
        testTeam.setRanking(1);
        assertEquals(1, testTeam.getRanking());
    }

    @Test
    public void testSetNumWins() {
        testTeam.setNumWin(7);
        assertEquals(7, testTeam.getNumWins());
    }

    @Test
    public void testSetNumLoss() {
        testTeam.setNumLoss(2);
        assertEquals(2, testTeam.getNumLoss());
    }

    @Test
    public void testSetNumDraw() {
        testTeam.setNumDraw(1);
        assertEquals(1, testTeam.getNumDraw());
    }

    @Test
    public void testSetGoalsScored() {
        testTeam.setGoalsScored(38);
        assertEquals(38, testTeam.getGoalsScored());
    }

    @Test
    public void testSetGoalsConceded() {
        testTeam.setGoalsConceded(13);
        assertEquals(13, testTeam.getGoalsConceded());
    }
}
