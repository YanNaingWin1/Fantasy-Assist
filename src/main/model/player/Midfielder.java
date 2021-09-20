package model.player;

import model.team.FootballTeam;

//represents a player of "midfielder" position
public class Midfielder extends Player {

    private int passesMade;
    private int chancesCreated;

    //EFFECTS - constructs a midfielder with assigned name, team, price and position
    public Midfielder(String name, FootballTeam team, double price) {
        super(name, team, price);
        this.position = "midfielder";
    }

    //EFFECTS - constructs a midfielder with assigned name, team name, price and position
    public Midfielder(String name, String teamName, double price) {
        super(name, teamName, price);
        this.position = "midfielder";
    }

    //EFFECTS - returns the number of passes made by the player
    public int getPassesMade() {
        return passesMade;
    }

    //MODIFIES - this
    //EFFECTS - sets the the number of passes made conceded by the player
    public void setPassesMade(int passesMade) {
        this.passesMade = passesMade;
    }

    //EFFECTS - returns the number of chances created by the player
    public int getChancesCreated() {
        return chancesCreated;
    }

    //MODIFIES - this
    //EFFECTS - sets the the number of chances created conceded by the player
    public void setChancesCreated(int chancesCreated) {
        this.chancesCreated = chancesCreated;
    }
}
