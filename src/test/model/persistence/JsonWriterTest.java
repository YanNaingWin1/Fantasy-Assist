package model.persistence;

import model.player.*;
import model.team.FantasyTeam;
import model.team.FootballTeam;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            FantasyTeam ft = new FantasyTeam();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyFantasyTeam() {
        try {
            FantasyTeam ft = new FantasyTeam();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyFantasyTeam.json");
            writer.open();
            writer.write(ft);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyFantasyTeam.json");
            ft = reader.read();
            assertEquals(0, ft.getTeam().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralFantasyTeam() {
        try {
            FantasyTeam ft = new FantasyTeam();
            ft.addPlayer(new Goalkeeper("Leno", "Arsenal", 5.5));
            ft.addPlayer(new Defender("Silva", "Chelsea", 5.5));
            ft.addPlayer(new Midfielder("Sancho", "ManchesterUnited", 9.5));
            ft.addPlayer(new Striker("Salah", "Liverpool", 12.5));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralFantasyTeam.json");
            writer.open();
            writer.write(ft);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralFantasyTeam.json");
            ft = reader.read();
            List<Player> playersInTeam = ft.getTeam();
            assertEquals(4, playersInTeam.size());
            checkPlayer("Leno", "Arsenal", "goalkeeper", 5.5, playersInTeam.get(0));
            checkPlayer("Silva", "Chelsea", "defender", 5.5, playersInTeam.get(1));
            checkPlayer("Sancho", "ManchesterUnited", "midfielder", 9.5, playersInTeam.get(2));
            checkPlayer("Salah", "Liverpool", "striker", 12.5, playersInTeam.get(3));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
