package model.team;

import model.fixture.Fixture;
import model.player.Player;

import java.util.LinkedList;
import java.util.List;

//represents a footballTeam having a collection of players
public class FootballTeam extends Team {

    private String teamName;
    private List<Fixture> teamFixtures;
    private int ranking;
    private int numWins;
    private int numLoss;
    private int numDraw;
    private int goalsScored;
    private int goalsConceded;
    private boolean bool;

    //EFFECTS - constructs an empty team with a given name together with empty fixtures
    public FootballTeam(String teamName) {
        this.teamName = teamName;
        this.teamFixtures = new LinkedList<>();
    }

    //MODIFIES - this
    //EFFECTS  - adds a given player to the team
    @Override
    public boolean addPlayer(Player player) {
        bool = false;
        if ((!this.containsPlayer(player)) && (!this.isFull())) {
            switch (player.getPosition()) {
                case "goalkeeper":
                    helperAddGoalKeeperFT(player);
                    break;
                case "defender":
                    helperAddDefenderFT(player);
                    break;
                case "midfielder":
                    helperAddMidfielderFT(player);
                    break;
                case "striker":
                    helperAddStrikerFT(player);
                    break;
                default: break;
            }
        }
        return bool;
    }

    //MODIFIES - this
    //EFFECTS  - helper to add any player
    public boolean helperAddPlayerFT(Player player) {
        playersInTeam.add(player);
        return true;
    }

    //MODIFIES - this
    //EFFECTS - helper method to add goalkeepers
    public void helperAddGoalKeeperFT(Player player) {
        if (!containsAllGoalkeepers()) {
            helperAddPlayerFT(player);
            goalkeeperCount++;
            bool = true;
        } else {
            bool = false;
        }
    }

    //MODIFIES - this
    //EFFECTS - helper method to add defenders
    public void helperAddDefenderFT(Player player) {
        if (!containsAllDefenders()) {
            helperAddPlayerFT(player);
            defenderCount++;
            bool = true;
        } else {
            bool = false;
        }
    }

    //MODIFIES - this
    //EFFECTS - helper method to add midfielders
    public void helperAddMidfielderFT(Player player) {
        if (!containsAllMidfielders()) {
            helperAddPlayerFT(player);
            midfielderCount++;
            bool = true;
        } else {
            bool = false;
        }
    }

    //MODIFIES - this
    //EFFECTS - helper method to add strikers
    public void helperAddStrikerFT(Player player) {
        if (!containsAllStrikers()) {
            helperAddPlayerFT(player);
            strikerCount++;
            bool = true;
        } else {
            bool = false;
        }
    }

    //MODIFIES - this
    //EFFECTS - remove given player; if player doesn't exist, return true;
    @Override
    public boolean removePlayer(Player player) {
        bool = false;
        if (playersInTeam.contains(player)) {
            playersInTeam.remove(player);
            switch (player.getPosition()) {
                case "goalkeeper":
                    goalkeeperCount--;
                    bool = true;
                    break;
                case "defender":
                    defenderCount--;
                    bool = true;
                    break;
                case "midfielder":
                    midfielderCount--;
                    bool = true;
                    break;
                default:
                    strikerCount--;
                    bool = true;
                    break;
            }
        }
        return bool;
    }

    //MODIFIES - this
    //EFFECTS  - if fixture doesn't exits, adds a given fixture to the team and return true; else return false
    public boolean addFixtures(Fixture fixture) {
        if (!containsFixture(fixture)) {
            teamFixtures.add(fixture);
            bool = true;
        } else {
            bool = false;
        }
        return bool;
    }

    //MODIFIES - this
    //EFFECTS  - if fixture exits, removes a given fixture to the team and return true; else return false
    public boolean removeFixtures(Fixture fixture) {
        if (containsFixture(fixture)) {
            teamFixtures.remove(fixture);
            bool = true;
        } else {
            bool = false;
        }
        return bool;
    }

    //EFFECTS - returns the name of the team
    public String getTeamName() {
        return teamName;
    }

    //EFFECTS - returns the fixture of the team
    public List<Fixture> getTeamFixtures() {
        return teamFixtures;
    }

    //EFFECTS - returns the ranking of the team
    public int getRanking() {
        return ranking;
    }

    //MODIFIES - this
    //EFFECTS - sets the ranking of the team
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    //EFFECTS - returns the number of wins of the team
    public int getNumWins() {
        return numWins;
    }

    //MODIFIES - this
    //EFFECTS - sets the number of wins of the team
    public void setNumWin(int numWins) {
        this.numWins = numWins;
    }

    //EFFECTS - returns the number of loss of the team
    public int getNumLoss() {
        return numLoss;
    }

    //MODIFIES - this
    //EFFECTS - sets the number of loss of the team
    public void setNumLoss(int numLoss) {
        this.numLoss = numLoss;
    }

    //EFFECTS - returns the number of draws of the team
    public int getNumDraw() {
        return numDraw;
    }

    //MODIFIES - this
    //EFFECTS - sets the number of draw of the team
    public void setNumDraw(int numDraw) {
        this.numDraw = numDraw;
    }

    //EFFECTS - returns the number of goals scored by the team
    public int getGoalsScored() {
        return goalsScored;
    }

    //MODIFIES - this
    //EFFECTS - sets the number of goals scored by the team
    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    //EFFECTS - returns the number of goals conceded by the team
    public int getGoalsConceded() {
        return goalsConceded;
    }

    //MODIFIES - this
    //EFFECTS - sets the number of conceded by the team
    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    //EFFECTS - returns true if the fixture has already been added to Team's fixture; else return false
    public boolean containsFixture(Fixture fixture) {
        for (Fixture f : teamFixtures) {
            if (f.equals(fixture)) {
                return true;
            }
        }
        return false;
    }


}
