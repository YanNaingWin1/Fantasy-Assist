package model.persistence;

import model.player.Player;
import model.team.FootballTeam;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkPlayer(String name, String team, String position, double price, Player player) {
        assertEquals(name, player.getName());
        assertEquals(position, player.getPosition());
        assertEquals(team, player.getTeamName());
        assertEquals(price, player.getPrice());
    }

}
