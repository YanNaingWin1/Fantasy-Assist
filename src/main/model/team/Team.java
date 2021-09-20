package model.team;

import model.player.Player;

import java.util.LinkedList;

//represents a Team of an abstract class
public abstract class Team {
    public static final int MAX_NUM_PLAYERS_IN_FANTASY = 15;
    protected static final int MAX_NUM_GOALKEEPER = 2;
    protected static final int MAX_NUM_DEFENDER = 5;
    protected static final int MAX_NUM_MIDFIELDER = 5;
    protected static final int MAX_NUM_STRIKER = 3;

    protected LinkedList<Player> playersInTeam;
    protected int goalkeeperCount;
    protected int defenderCount;
    protected int midfielderCount;
    protected int strikerCount;

    //EFFECTS - constructs an empty team
    public Team() {
        playersInTeam = new LinkedList<>();
    }

    //MODIFIES - this
    //EFFECTS  - add the player and returns true if the player doesn't exist in the team; else returns false
    public abstract boolean addPlayer(Player player);

    //MODIFIES - this
    //EFFECTS  - if player is in the team, remove and return true; else return false
    public abstract boolean removePlayer(Player player);

    //EFFECTS  - returns the current team
    public LinkedList<Player> getTeam() {
        return playersInTeam;
    }

    //EFFECTS  - returns the number of goalkeepers currently in the team
    public int getGoalkeeperCount() {
        return goalkeeperCount;
    }

    //EFFECTS  - returns the number of defenders currently in the team
    public int getDefenderCount() {
        return defenderCount;
    }

    //EFFECTS  - returns the number of midfielders currently in the team
    public int getMidfielderCount() {
        return midfielderCount;
    }

    //EFFECTS  - returns the number of strikers currently in the team
    public int getStrikerCount() {
        return strikerCount;
    }

    //EFFECTS  - returns true if there are maximum number of goalkeeper, else return false
    public boolean containsAllGoalkeepers() {
        return this.getGoalkeeperCount() == MAX_NUM_GOALKEEPER;
    }

    //EFFECTS  - returns true if there are maximum number of defenders, else return false
    public boolean containsAllDefenders() {
        return this.getDefenderCount() == MAX_NUM_DEFENDER;
    }

    //EFFECTS  - returns true if there are maximum number of midfielders, else return false
    public boolean containsAllMidfielders() {
        return this.getMidfielderCount() == MAX_NUM_MIDFIELDER;
    }

    //EFFECTS  - returns true if there are maximum number of attackers, else return false
    public boolean containsAllStrikers() {
        return this.getStrikerCount() == MAX_NUM_STRIKER;
    }

    //EFFECTS  - returns the size of the team
    public int length() {
        return playersInTeam.size();
    }

    //EFFECTS  - returns true if the team is full; else return false
    public boolean isFull() {
        return this.length() == MAX_NUM_PLAYERS_IN_FANTASY;
    }

    //EFFECTS  - returns true if the team is empty; else return false
    public boolean isEmpty() {
        return this.length() == 0;
    }

    //EFFECTS - returns true if the given player is already in the team; else return false;
    public boolean containsPlayer(Player player) {
        return playersInTeam.contains(player);
    }
}
