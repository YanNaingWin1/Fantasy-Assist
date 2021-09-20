package model.persistence;

import model.player.Player;
import model.team.FantasyTeam;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            FantasyTeam ft = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyFantasyTeam() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyFantasyTeam.json");
        try {
            FantasyTeam ft = reader.read();
            assertEquals(0, ft.getTeam().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralTeam() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralFantasyTeam.json");
        try {
            FantasyTeam ft = reader.read();
            List<Player> players = ft.getTeam();
            assertEquals(4, players.size());
            checkPlayer("Leno", "Arsenal", "goalkeeper", 5.5, players.get(0));
            checkPlayer("Silva", "Chelsea", "defender", 5.5, players.get(1));
            checkPlayer("Sancho", "ManchesterUnited", "midfielder", 9.5, players.get(2));
            checkPlayer("Salah", "Liverpool", "striker", 12.5, players.get(3));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
