package model.player;

import model.team.FootballTeam;

//represents a player of "goalkeeper" position
public class Goalkeeper extends Player {

    private int savesMade;
    private int goalsConceded;
    private int cleanSheet;

    //EFFECTS - constructs a goalkeeper with assigned name, team, price and position
    public Goalkeeper(String name, FootballTeam team, double price) {
        super(name, team, price);
        this.position = "goalkeeper";
    }

    //EFFECTS - constructs a goalkeeper with assigned name, team name, price and position
    public Goalkeeper(String name, String teamName, double price) {
        super(name, teamName, price);
        this.position = "goalkeeper";
    }

    //EFFECTS - returns the saves made by the player
    public int getSavesMade() {
        return savesMade;
    }

    //MODIFIES - this
    //EFFECTS - sets the number of saves made by the player
    public void setSavesMade(int savesMade) {
        this.savesMade = savesMade;
    }

    //EFFECTS - returns the number of goals conceded by the player
    public int getGoalsConceded() {
        return goalsConceded;
    }

    //MODIFIES - this
    //EFFECTS - sets the number of goals conceded by the player
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
