package model.player;

import model.team.FootballTeam;

//represents a player of "defender" position
public class Defender extends Player {

    private int tacklesMade;
    private int goalsConceded;
    private int cleanSheet;

    //EFFECTS - constructs a defender with assigned name, team, price and position
    public Defender(String name, FootballTeam team, double price) {
        super(name, team, price);
        this.position = "defender";
    }

    //EFFECTS - constructs a defender with assigned name, team name, price and position
    public Defender(String name, String teamName, double price) {
        super(name, teamName, price);
        this.position = "defender";
    }

    //EFFECTS - returns the tackles made by the player
    public int getTacklesMade() {
        return tacklesMade;
    }

    //MODIFIES - this
    //EFFECTS - sets the tackles made by the player
    public void setTacklesMade(int tacklesMade) {
        this.tacklesMade = tacklesMade;
    }

    //EFFECTS - returns the number of goals conceded by the player
    public int getGoalsConceded() {
        return goalsConceded;
    }

    //MODIFIES - this
    //EFFECTS - sets the the number of goals conceded conceded by the player
    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    //EFFECTS - returns the number of clean sheets the player
    public int getCleanSheet() {
        return cleanSheet;
    }

    //MODIFIES - this
    //EFFECTS - sets the number of clean sheets the player
    public void setCleanSheet(int cleanSheet) {
        this.cleanSheet = cleanSheet;
    }

}
