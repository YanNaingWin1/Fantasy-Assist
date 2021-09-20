package model.fixture;

import model.team.FootballTeam;

//represents a fixture of a team
public class Fixture {

    private FootballTeam homeTeam;
    private FootballTeam awayTeam;
    private String venue;

    //EFFECTS - constructs a fixture with assigned home team and away team
    public Fixture(FootballTeam homeTeam, FootballTeam awayTeam, String venue) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.venue = venue;
    }

    //EFFECTS - returns the stadium where the fixture is played
    public String getVenue() {
        return venue;
    }

    //EFFECTS - returns the home team of the fixture
    public FootballTeam getHomeTeam() {
        return homeTeam;
    }

    //EFFECTS - returns the away team of the fixture
    public FootballTeam getAwayTeam() {
        return awayTeam;
    }
}
