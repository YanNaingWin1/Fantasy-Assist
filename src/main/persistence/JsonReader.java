package persistence;

import model.player.*;
import model.team.FantasyTeam;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads the fantasy team from JSON data stored in file
// Source - JSON Serialization Demo by CPSC210 team
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads fantasy team from file and returns it;
    // throws IOException if an error occurs reading data from file
    public FantasyTeam read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseFantasyTeam(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses fantasy team from JSON object and returns it
    private FantasyTeam parseFantasyTeam(JSONObject jsonObject) {
        FantasyTeam ft = new FantasyTeam();
        addFantasyPlayers(ft, jsonObject);
        return ft;
    }

    // MODIFIES: ft
    // EFFECTS: parses fantasy players from JSON object and adds them to fantasy team
    private void addFantasyPlayers(FantasyTeam ft, JSONObject jsonObject)  {
        JSONArray jsonArray = jsonObject.getJSONArray("playersInTeam");
        for (Object json : jsonArray) {
            JSONObject nextFantasyPlayer = (JSONObject) json;
            addFantasyPlayer(ft, nextFantasyPlayer);
        }
    }

    // MODIFIES: ft
    // EFFECTS: parses fantasy player from JSON object and adds it to fantasy team
    private void addFantasyPlayer(FantasyTeam ft, JSONObject jsonObject) {
        Player player;
        String name = jsonObject.getString("name");
        String footballTeam = jsonObject.getString("team");
        double price = jsonObject.getDouble("price");
        String position = jsonObject.getString("position");
        switch (position) {
            case "goalkeeper":
                player = new Goalkeeper(name, footballTeam, price);
                ft.addPlayer(player);
                break;
            case "defender":
                player = new Defender(name, footballTeam, price);
                ft.addPlayer(player);
                break;
            case "midfielder":
                player = new Midfielder(name, footballTeam, price);
                ft.addPlayer(player);
                break;
            default:
                player = new Striker(name, footballTeam, price);
                ft.addPlayer(player);
                break;
        }
    }
}
