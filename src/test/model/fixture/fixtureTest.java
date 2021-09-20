package model.fixture;

import model.fixture.Fixture;
import model.team.FootballTeam;
import model.team.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class fixtureTest {

    private FootballTeam testHomeTeam;
    private FootballTeam testAwayTeam;
    private Fixture fixture1;

    @BeforeEach
    public void setUp() {
        testHomeTeam = new FootballTeam("Chelsea");
        testAwayTeam = new FootballTeam("Spurs");
        fixture1 = new Fixture(testHomeTeam, testAwayTeam, "Stamford Bridge");
    }

    @Test
    public void testConstructor() {
        assertEquals(testHomeTeam, fixture1.getHomeTeam());
        assertEquals(testAwayTeam, fixture1.getAwayTeam());
        assertEquals("Stamford Bridge", fixture1.getVenue());
    }
}
