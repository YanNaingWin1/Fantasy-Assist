package model.team;

import model.player.*;
import model.team.FantasyTeam;
import model.team.FootballTeam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class fantasyTeamTest {

    FantasyTeam myFantasyTeam;
    Player playerGk1;
    Player playerGk2;
    Player playerDf1;
    Player playerDf2;
    Player playerDf3;
    Player playerDf4;
    Player playerDf5;
    Player playerMd1;
    Player playerMd2;
    Player playerMd3;
    Player playerMd4;
    Player playerMd5;
    Player playerSt1;
    Player playerSt2;
    Player playerSt3;

    Player playerGk3;
    Player playerDf6;
    Player playerMd6;
    Player playerSt4;

    FootballTeam arsenal;
    FootballTeam chelsea;
    FootballTeam liverpool;
    FootballTeam manUtd;
    FootballTeam manCity;
    FootballTeam spurs;

    List<Player> playerList;

    @BeforeEach
    public void setUp() {
        myFantasyTeam = new FantasyTeam();
        playerList = new LinkedList<>();

        arsenal = new FootballTeam("Arsenal");
        chelsea = new FootballTeam("Chelsea");
        liverpool = new FootballTeam("Liverpool");
        manUtd = new FootballTeam("Man Utd");
        manCity = new FootballTeam("Man City");
        spurs = new FootballTeam("Spurs");

        playerGk1 = new Goalkeeper("Mendy", chelsea, 5.0);
        playerGk2 = new Goalkeeper("Leno", arsenal, 4.5);

        playerDf1 = new Defender("Dias", manCity, 6.0);
        playerDf2 = new Defender("Robertson", liverpool, 6.5);
        playerDf3 = new Defender("Holding", arsenal, 4.5);
        playerDf4 = new Defender("Shaw", manUtd, 5.0);
        playerDf5 = new Defender("Sanchez", spurs, 4.5);

        playerMd1 = new Midfielder("Salah", liverpool, 12.5);
        playerMd2 = new Midfielder("Fernandes", manUtd, 10.5);
        playerMd3 = new Midfielder("Mount", chelsea, 7.5);
        playerMd4 = new Midfielder("Gundogan", manCity, 6.0);
        playerMd5 = new Midfielder("Kante", chelsea, 5.0);

        playerSt1 = new Striker("Cavani", manUtd, 8.0);
        playerSt2 = new Striker("Jesus", manCity, 7.5);
        playerSt3 = new Striker("Lacazette", arsenal, 7.0);

        playerGk3 = new Goalkeeper("Alisson", liverpool, 6.0);
        playerDf6 = new Defender("Rondon", spurs,4.0);
        playerMd6 = new Midfielder("Jorginho", chelsea, 5.0);
        playerSt4 = new Striker("Kane", spurs, 12.0);

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
            myFantasyTeam.addPlayer(playerList.get(i));
        }
    }

    @Test
    public void testConstructor() {
        assertTrue(myFantasyTeam.isEmpty());
        assertFalse(myFantasyTeam.isFull());
        assertEquals(0, myFantasyTeam.length());
        assertEquals(100, myFantasyTeam.getRemainingBalance());
    }

    @Test
    public void testAdd1Player() {
        myFantasyTeam.addPlayer(playerGk1);
        assertFalse(myFantasyTeam.isEmpty());
        assertTrue(myFantasyTeam.containsPlayer(playerGk1));
        assertEquals(1, myFantasyTeam.length());
    }

    @Test
    public void testAdd2ButDuplicatePlayer() {
        myFantasyTeam.addPlayer(playerGk1);
        assertFalse(myFantasyTeam.isEmpty());
        assertTrue(myFantasyTeam.containsPlayer(playerGk1));
        assertEquals(1, myFantasyTeam.length());
        myFantasyTeam.addPlayer(playerGk1);
        assertTrue(myFantasyTeam.containsPlayer(playerGk1));
        assertEquals(1, myFantasyTeam.length());
    }

    @Test
    public void testAdd1PlayerWith14SlotsOccupied() {
        for (int i = 0; i < (FantasyTeam.MAX_NUM_PLAYERS_IN_FANTASY - 1); i++) {
            myFantasyTeam.addPlayer(playerList.get(i));
        }
        myFantasyTeam.addPlayer(playerSt3);
        assertTrue(myFantasyTeam.isFull());
        assertEquals(15, myFantasyTeam.length());
        for (int i = 0; i < FantasyTeam.MAX_NUM_PLAYERS_IN_FANTASY; i++) {
            assertTrue(myFantasyTeam.containsPlayer(playerList.get(i)));
        }
    }

    @Test
    public void testAdd1PlayerWithAllSlotsOccupied() {
        addMaxPlayersInFantasyTeam();
        assertTrue(myFantasyTeam.isFull());
        assertEquals(15, myFantasyTeam.length());
        for (int i = 0; i < FantasyTeam.MAX_NUM_PLAYERS_IN_FANTASY; i++) {
            assertTrue(myFantasyTeam.containsPlayer(playerList.get(i)));
        }
        myFantasyTeam.addPlayer(playerDf6);
        assertTrue(myFantasyTeam.isFull());
        assertEquals(15, myFantasyTeam.length());
        for (int i = 0; i < FantasyTeam.MAX_NUM_PLAYERS_IN_FANTASY; i++) {
            assertTrue(myFantasyTeam.containsPlayer(playerList.get(i)));
        }
    }

    @Test
    public void testAdd2Gk() {
        assertFalse(myFantasyTeam.containsAllGoalkeepers());
        myFantasyTeam.addPlayer(playerGk1);
        myFantasyTeam.addPlayer(playerGk2);
        assertFalse(myFantasyTeam.isEmpty());
        assertEquals(2, myFantasyTeam.getGoalkeeperCount());
        assertTrue(myFantasyTeam.containsAllGoalkeepers());
        assertEquals(2, myFantasyTeam.length());
    }

    @Test
    public void testAdd2GksAnd1MoreGk() {
        assertFalse(myFantasyTeam.containsAllGoalkeepers());
        myFantasyTeam.addPlayer(playerGk1);
        myFantasyTeam.addPlayer(playerGk2);
        assertEquals(2, myFantasyTeam.getGoalkeeperCount());
        assertTrue(myFantasyTeam.containsAllGoalkeepers());
        assertEquals(2, myFantasyTeam.length());
        myFantasyTeam.addPlayer(playerGk3);
        assertEquals(2, myFantasyTeam.getGoalkeeperCount());
        assertTrue(myFantasyTeam.containsAllGoalkeepers());
        assertEquals(2, myFantasyTeam.length());
    }

    @Test
    public void testAdd5Def() {
        assertFalse(myFantasyTeam.containsAllDefenders());
        myFantasyTeam.addPlayer(playerDf1);
        myFantasyTeam.addPlayer(playerDf2);
        myFantasyTeam.addPlayer(playerDf3);
        myFantasyTeam.addPlayer(playerDf4);
        myFantasyTeam.addPlayer(playerDf5);
        assertEquals(5, myFantasyTeam.getDefenderCount());
        assertTrue(myFantasyTeam.containsAllDefenders());
        assertEquals(5, myFantasyTeam.length());
    }

    @Test
    public void testAdd5DefAnd1MoreDef() {
        assertFalse(myFantasyTeam.containsAllDefenders());
        myFantasyTeam.addPlayer(playerDf1);
        myFantasyTeam.addPlayer(playerDf2);
        myFantasyTeam.addPlayer(playerDf3);
        myFantasyTeam.addPlayer(playerDf4);
        myFantasyTeam.addPlayer(playerDf5);
        assertEquals(5, myFantasyTeam.getDefenderCount());
        assertTrue(myFantasyTeam.containsAllDefenders());
        assertEquals(5, myFantasyTeam.length());
        myFantasyTeam.addPlayer(playerDf6);
        assertEquals(5, myFantasyTeam.getDefenderCount());
        assertTrue(myFantasyTeam.containsAllDefenders());
        assertEquals(5, myFantasyTeam.length());
    }

    @Test
    public void testAdd5Mid() {
        assertFalse(myFantasyTeam.containsAllMidfielders());
        myFantasyTeam.addPlayer(playerMd1);
        myFantasyTeam.addPlayer(playerMd2);
        myFantasyTeam.addPlayer(playerMd3);
        myFantasyTeam.addPlayer(playerMd4);
        myFantasyTeam.addPlayer(playerMd5);
        assertEquals(5, myFantasyTeam.getMidfielderCount());
        assertTrue(myFantasyTeam.containsAllMidfielders());
        assertEquals(5, myFantasyTeam.length());
    }

    @Test
    public void testAdd5MidAnd1MoreMid() {
        assertFalse(myFantasyTeam.containsAllMidfielders());
        myFantasyTeam.addPlayer(playerMd1);
        myFantasyTeam.addPlayer(playerMd2);
        myFantasyTeam.addPlayer(playerMd3);
        myFantasyTeam.addPlayer(playerMd4);
        myFantasyTeam.addPlayer(playerMd5);
        assertEquals(5, myFantasyTeam.getMidfielderCount());
        assertTrue(myFantasyTeam.containsAllMidfielders());
        assertEquals(5, myFantasyTeam.length());
        myFantasyTeam.addPlayer(playerMd6);
        assertEquals(5, myFantasyTeam.getMidfielderCount());
        assertTrue(myFantasyTeam.containsAllMidfielders());
        assertEquals(5, myFantasyTeam.length());
    }

    @Test
    public void testAdd3St() {
        assertFalse(myFantasyTeam.containsAllStrikers());
        myFantasyTeam.addPlayer(playerSt1);
        myFantasyTeam.addPlayer(playerSt2);
        myFantasyTeam.addPlayer(playerSt3);
        assertEquals(3, myFantasyTeam.getStrikerCount());
        assertTrue(myFantasyTeam.containsAllStrikers());
        assertEquals(3, myFantasyTeam.length());
    }

    @Test
    public void testAdd3StAnd1MoreSt() {
        assertFalse(myFantasyTeam.containsAllStrikers());
        myFantasyTeam.addPlayer(playerSt1);
        myFantasyTeam.addPlayer(playerSt2);
        myFantasyTeam.addPlayer(playerSt3);
        assertEquals(3, myFantasyTeam.getStrikerCount());
        assertTrue(myFantasyTeam.containsAllStrikers());
        assertEquals(3, myFantasyTeam.length());
        myFantasyTeam.addPlayer(playerSt4);
        assertEquals(3, myFantasyTeam.getStrikerCount());
        assertTrue(myFantasyTeam.containsAllStrikers());
        assertEquals(3, myFantasyTeam.length());
    }

    @Test
    public void testAdd15PlayersWith100Budget() {
        addMaxPlayersInFantasyTeam();
        assertEquals(0, myFantasyTeam.getRemainingBalance());
    }

    @Test
    public void testAdd14PlayersWith95BudgetAnd1MoreWith4Budget() {
        addMaxPlayersInFantasyTeam();
        myFantasyTeam.removePlayer(playerDf4);
        assertFalse(myFantasyTeam.isFull());
        assertEquals(5, myFantasyTeam.getRemainingBalance());
        myFantasyTeam.addPlayer(playerDf6);
        assertEquals(1, myFantasyTeam.getRemainingBalance());
        assertTrue(myFantasyTeam.isFull());
        assertTrue(myFantasyTeam.containsAllDefenders());
    }

    @Test
    public void testAdd14PlayersWith95BudgetAnd1MoreWith5Budget() {
        addMaxPlayersInFantasyTeam();
        myFantasyTeam.removePlayer(playerMd5);
        assertFalse(myFantasyTeam.isFull());
        assertEquals(5, myFantasyTeam.getRemainingBalance());
        myFantasyTeam.addPlayer(playerMd6);
        assertEquals(0, myFantasyTeam.getRemainingBalance());
        assertTrue(myFantasyTeam.isFull());
        assertTrue(myFantasyTeam.containsAllMidfielders());
    }

    @Test
    public void testAdd14PlayersWith95BudgetAnd1MoreWith6Budget() {
        addMaxPlayersInFantasyTeam();
        myFantasyTeam.removePlayer(playerGk1);
        assertFalse(myFantasyTeam.isFull());
        assertEquals(5, myFantasyTeam.getRemainingBalance());
        myFantasyTeam.addPlayer(playerGk3);
        assertFalse(myFantasyTeam.isFull());
        assertEquals(5, myFantasyTeam.getRemainingBalance());
        assertFalse(myFantasyTeam.containsAllGoalkeepers());
    }

    @Test
    public void testAdd3PlayersFromSameTeam() {
        myFantasyTeam.addPlayer(playerDf1);
        myFantasyTeam.addPlayer(playerMd4);
        myFantasyTeam.addPlayer(playerSt2);
        assertEquals(3, myFantasyTeam.length());
        assertTrue(myFantasyTeam.getPlayersTeams().contains(manCity));
        assertEquals(3, Collections.frequency(myFantasyTeam.getPlayersTeams(), manCity));
    }

    @Test
    public void testAdd3PlayersFromSameTeamAnd1MoreFromSameTeam() {
        myFantasyTeam.addPlayer(playerGk1);
        myFantasyTeam.addPlayer(playerMd3);
        myFantasyTeam.addPlayer(playerMd5);
        assertEquals(3, myFantasyTeam.length());
        assertEquals(3, Collections.frequency(myFantasyTeam.getPlayersTeams(), chelsea));
        myFantasyTeam.addPlayer(playerMd6);
        assertEquals(3, myFantasyTeam.length());
        assertEquals(3, Collections.frequency(myFantasyTeam.getPlayersTeams(), chelsea));
    }

    @Test
    public void testAdd3PlayersFromSameTeamAnd1MoreFromDifferentTeam() {
        myFantasyTeam.addPlayer(playerGk1);
        myFantasyTeam.addPlayer(playerMd3);
        myFantasyTeam.addPlayer(playerMd5);
        assertEquals(3, myFantasyTeam.length());
        assertEquals(3, Collections.frequency(myFantasyTeam.getPlayersTeams(), chelsea));
        myFantasyTeam.addPlayer(playerSt1);
        assertEquals(4, myFantasyTeam.length());
        assertEquals(3, Collections.frequency(myFantasyTeam.getPlayersTeams(), chelsea));
        assertEquals(1, Collections.frequency(myFantasyTeam.getPlayersTeams(), manUtd));
    }

    @Test
    public void testAddPlayerWithANonExistingPosition() {
        Player playerEe1 = new Goalkeeper("Edgar", liverpool, 9.5);
        playerEe1.setPosition("Sweeper");
        myFantasyTeam.addPlayer(playerEe1);
        assertEquals(0, myFantasyTeam.length());
        assertFalse(myFantasyTeam.getTeam().contains(playerEe1));
    }

    @Test
    public void testRemoveExistingPlayer() {
        myFantasyTeam.addPlayer(playerDf3);
        assertEquals(1, myFantasyTeam.length());
        assertTrue(myFantasyTeam.containsPlayer(playerDf3));
        assertFalse(myFantasyTeam.isEmpty());
        myFantasyTeam.removePlayer(playerDf3);
        assertEquals(0, myFantasyTeam.length());
        assertFalse(myFantasyTeam.containsPlayer(playerDf3));
        assertTrue(myFantasyTeam.isEmpty());
    }

    @Test
    public void testRemoveNonExistingPlayer() {
        myFantasyTeam.addPlayer(playerDf3);
        assertEquals(1, myFantasyTeam.length());
        assertTrue(myFantasyTeam.containsPlayer(playerDf3));
        assertFalse(myFantasyTeam.isEmpty());
        myFantasyTeam.removePlayer(playerSt3);
        assertEquals(1, myFantasyTeam.length());
        assertTrue(myFantasyTeam.containsPlayer(playerDf3));
        assertFalse(myFantasyTeam.isEmpty());
    }

    @Test
    public void testRemoveGoalkeeper() {
        myFantasyTeam.addPlayer(playerGk1);
        assertEquals(1, myFantasyTeam.length());
        assertTrue(myFantasyTeam.containsPlayer(playerGk1));
        assertFalse(myFantasyTeam.isEmpty());
        assertEquals(1, myFantasyTeam.getGoalkeeperCount());
        myFantasyTeam.removePlayer(playerGk1);
        assertEquals(0, myFantasyTeam.length());
        assertFalse(myFantasyTeam.containsPlayer(playerGk1));
        assertTrue(myFantasyTeam.isEmpty());
        assertEquals(0, myFantasyTeam.getGoalkeeperCount());
    }

    @Test
    public void testRemoveDefender() {
        myFantasyTeam.addPlayer(playerDf3);
        assertEquals(1, myFantasyTeam.length());
        assertTrue(myFantasyTeam.containsPlayer(playerDf3));
        assertFalse(myFantasyTeam.isEmpty());
        assertEquals(1, myFantasyTeam.getDefenderCount());
        myFantasyTeam.removePlayer(playerDf3);
        assertEquals(0, myFantasyTeam.length());
        assertFalse(myFantasyTeam.containsPlayer(playerDf3));
        assertTrue(myFantasyTeam.isEmpty());
        assertEquals(0, myFantasyTeam.getDefenderCount());
    }

    @Test
    public void testRemoveMidfielder() {
        myFantasyTeam.addPlayer(playerMd2);
        assertEquals(1, myFantasyTeam.length());
        assertTrue(myFantasyTeam.containsPlayer(playerMd2));
        assertFalse(myFantasyTeam.isEmpty());
        assertEquals(1, myFantasyTeam.getMidfielderCount());
        myFantasyTeam.removePlayer(playerMd2);
        assertEquals(0, myFantasyTeam.length());
        assertFalse(myFantasyTeam.containsPlayer(playerMd2));
        assertTrue(myFantasyTeam.isEmpty());
        assertEquals(0, myFantasyTeam.getMidfielderCount());
    }

    @Test
    public void testRemoveStriker() {
        myFantasyTeam.addPlayer(playerSt2);
        assertEquals(1, myFantasyTeam.length());
        assertTrue(myFantasyTeam.containsPlayer(playerSt2));
        assertFalse(myFantasyTeam.isEmpty());
        assertEquals(1, myFantasyTeam.getStrikerCount());
        myFantasyTeam.removePlayer(playerSt2);
        assertEquals(0, myFantasyTeam.length());
        assertFalse(myFantasyTeam.containsPlayer(playerSt2));
        assertTrue(myFantasyTeam.isEmpty());
        assertEquals(0, myFantasyTeam.getStrikerCount());
    }

    @Test
    public void testGetFantasyTeam() {
        addMaxPlayersInFantasyTeam();
        assertEquals(15, myFantasyTeam.length());
        for (int i = 0; i < FantasyTeam.MAX_NUM_PLAYERS_IN_FANTASY; i++) {
            assertTrue(myFantasyTeam.getTeam().contains(playerList.get(i)));
        }
    }

    @Test
    public void testCalculatePointsScored() {
        addMaxPlayersInFantasyTeam();
        int totalPoints = 0;
        for (Player p : myFantasyTeam.getTeam()) {
            totalPoints += p.getTotalPoints();
        }
        assertEquals(totalPoints, myFantasyTeam.calculatePointsScored());
    }
}