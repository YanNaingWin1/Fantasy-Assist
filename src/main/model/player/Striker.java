package model.player;

import model.team.FootballTeam;

//represents a player of "striker" position
public class Striker extends Player {

    //EFFECTS - constructs a striker with assigned name, team, price and position
    public Striker(String name, FootballTeam team, double price) {
        super(name, team, price);
        this.position = "striker";
    }

    //EFFECTS - constructs a striker with assigned name, team name, price and position
    public Striker(String name, String teamName, double price) {
        super(name, teamName, price);
        this.position = "striker";
    }
}
