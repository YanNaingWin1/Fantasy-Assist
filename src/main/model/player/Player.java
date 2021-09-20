package model.player;

import model.team.FootballTeam;
import org.json.JSONObject;
import persistence.Writeable;

//represents a player of abstract class
public abstract class Player implements Writeable {

    protected String name;
    protected FootballTeam team;
    protected String teamName;
    protected double price;
    protected String position;
    protected int appearances;
    protected int goalsScored;
    protected int goalsAssisted;
    protected int yellowCard;
    protected int redCard;
    protected boolean isInjured;
    protected boolean isSuspended;
    protected int totalPoints;
    protected int projectedPoints;

    //EFFECTS - constructs a player with a given name, football team and price
    public Player(String name, FootballTeam team, double price) {
        this.name = name;
        this.team = team;
        this.price = price;
        this.teamName = team.getTeamName();
    }

    //EFFECTS - constructs a player with a given name, football team name and price
    public Player(String name, String teamName, double price) {
        this.name = name;
        this.teamName = teamName;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public FootballTeam getTeam() {
        return team;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsAssisted() {
        return goalsAssisted;
    }

    public void setGoalsAssisted(int goalsAssisted) {
        this.goalsAssisted = goalsAssisted;
    }

    public int getAppearances() {
        return appearances;
    }

    public void setAppearances(int appearances) {
        this.appearances = appearances;
    }

    public int getYellowCard() {
        return yellowCard;
    }

    public void setYellowCard(int yellowCard) {
        this.yellowCard = yellowCard;
    }

    public int getRedCard() {
        return redCard;
    }

    public void setRedCard(int redCard) {
        this.redCard = redCard;
    }

    public boolean isInjured() {
        return isInjured;
    }

    public void setInjured(boolean injured) {
        this.isInjured = injured;
    }

    public boolean isSuspended() {
        return isSuspended;
    }

    public void setSuspended(boolean suspended) {
        this.isSuspended = suspended;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    //EFFECTS - adds points from each gameweek to the previous gameweek points
    public void addPoints(int gameWeekPoints) {
        totalPoints += gameWeekPoints;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("team", teamName);
        json.put("price", price);
        json.put("position", position);
        return json;
    }
}
