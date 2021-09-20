package model.team;

import model.player.Player;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writeable;

import java.util.LinkedList;

//represents a fantasyTeam having a collection of players
public class FantasyTeam extends Team implements Writeable  {

    private static final double INITIAL_BALANCE = 100;
    private static final int SAME_TEAM_LIMIT = 3;
    private boolean bool = false;

    private LinkedList<FootballTeam> teamsOfPlayers;
    private LinkedList<String> teamNamesOfPlayers;
    private double remainingBalance;
    private int pointsScored;

    //EFFECTS - constructs an empty fantasy team with 100 balance
    public FantasyTeam() {
        super();
        teamsOfPlayers = new LinkedList<>();
        teamNamesOfPlayers = new LinkedList<>();
        this.remainingBalance = INITIAL_BALANCE;
    }

    //MODIFIES - this
    //EFFECTS  - adds a player to the team if all rules are followed and calculate balance; else return false;
    @Override
    public boolean addPlayer(Player player) {
        bool = false;
        if ((!this.containsPlayer(player)) && (!this.isFull()) && (this.remainingBalance >= player.getPrice())
                && (countTeam(player.getTeamName()) < SAME_TEAM_LIMIT)) {
            switch (player.getPosition()) {
                case "goalkeeper":
                    helperAddGoalKeeperFantasy(player);
                    break;
                case "defender":
                    helperAddDefenderFantasy(player);
                    break;
                case "midfielder":
                    helperAddMidfielderFantasy(player);
                    break;
                case "striker":
                    helperAddStrikerFantasy(player);
                    break;
                default: break;
            }
        }
        return bool;
    }

    //MODIFIES - this
    //EFFECTS - helper to addPlayer function and return true after completion
    public void helperAddPlayerFantasy(Player player) {
        playersInTeam.add(player);
        teamsOfPlayers.add(player.getTeam());
        teamNamesOfPlayers.add(player.getTeamName());
        remainingBalance -= player.getPrice();
    }

    //MODIFIES - this
    //EFFECTS - helper method to add goalkeepers
    public void helperAddGoalKeeperFantasy(Player player) {
        if (!containsAllGoalkeepers()) {
            helperAddPlayerFantasy(player);
            goalkeeperCount++;
            bool = true;
        } else {
            bool = false;
        }
    }

    //MODIFIES - this
    //EFFECTS - helper method to add defenders
    public void helperAddDefenderFantasy(Player player) {
        if (!containsAllDefenders()) {
            helperAddPlayerFantasy(player);
            defenderCount++;
            bool = true;
        } else {
            bool = false;
        }
    }

    //MODIFIES - this
    //EFFECTS - helper method to add midfielders
    public void helperAddMidfielderFantasy(Player player) {
        if (!containsAllMidfielders()) {
            helperAddPlayerFantasy(player);
            midfielderCount++;
            bool = true;
        } else {
            bool = false;
        }
    }

    //MODIFIES - this
    //EFFECTS - helper method to add strikers
    public void helperAddStrikerFantasy(Player player) {
        if (!containsAllStrikers()) {
            helperAddPlayerFantasy(player);
            strikerCount++;
            bool = true;
        } else {
            bool = false;
        }
    }

    @Override
    //MODIFIES - this
    //EFFECTS  - if player is in the team, remove and return true; else return false
    public boolean removePlayer(Player player) {
        bool = false;
        if (playersInTeam.contains(player)) {
            playersInTeam.remove(player);
            teamsOfPlayers.remove(player.getTeam());
            teamNamesOfPlayers.remove(player.getTeamName());
            remainingBalance += player.getPrice();
            switch (player.getPosition()) {
                case "goalkeeper":
                    goalkeeperCount--;
                    bool = true;
                case "defender":
                    defenderCount--;
                    bool = true;
                case "midfielder":
                    midfielderCount--;
                    bool = true;
                default:
                    strikerCount--;
                    bool = true;
            }
        }
        return bool;
    }

    //EFFECTS  - returns the total points of players in the team
    public int calculatePointsScored() {
        int totalPoints = 0;
        for (Player p : this.getTeam()) {
            totalPoints += p.getTotalPoints();
        }
        return totalPoints;
    }

    //EFFECTS  - returns the selected players' teams in a list
    public LinkedList<FootballTeam> getPlayersTeams() {
        return teamsOfPlayers;
    }

    //EFFECTS - returns the number of occurrences of the given team
    public int countTeam(String footballTeam) {
        int teamCount = 0;
        for (String ft : teamNamesOfPlayers) {
            if (ft.equals(footballTeam)) {
                teamCount++;
            }
        }
        return teamCount;
    }

    //EFFECTS  - returns the number of strikers currently in the team
    public double getRemainingBalance() {
        return remainingBalance;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("playersInTeam", playersInTeamToJson());
        return json;
    }

    // EFFECTS: returns players in this fantasy team as a JSON array
    private JSONArray playersInTeamToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Player p : this.playersInTeam) {
            jsonArray.put(p.toJson());
        }
        return jsonArray;
    }
}
