package ui;

import model.fixture.Fixture;
import model.player.*;
import model.team.FantasyTeam;
import model.team.FootballTeam;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.tabs.FantasyTab;
import ui.tabs.HomeTab;
import ui.tabs.InstructionTab;
import ui.tabs.StatsTab;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.*;

//represents a fantasy app containing all the functions needed to run the app
public class FantasyApp extends JFrame {

    private Scanner input;
    private FantasyTeam myFantasyTeam = new FantasyTeam();
    protected LinkedList<FootballTeam> footballTeamList = new LinkedList<>();
    private static final String JSON_STORE = "./data/fantasyTeam.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private StringBuilder txt;
    private StringBuilder teamNames;
    private String returnStatement;
    boolean bool = false;

    private FootballTeam teamFounded;

    public static final int HOME_TAB_INDEX = 0;
    public static final int FANTASY_TAB_INDEX = 1;
    public static final int TEAMS_TAB_INDEX = 2;
    public static final int INSTRUCTIONS_TAB_INDEX = 3;

    public static final int WIDTH = 1430;
    public static final int HEIGHT = 680;
    private JTabbedPane sidebar;

    private FootballTeam arsenal = new FootballTeam("Arsenal");
    private FootballTeam chelsea = new FootballTeam("Chelsea");
    private FootballTeam liverpool = new FootballTeam("Liverpool");
    private FootballTeam manUtd = new FootballTeam("ManchesterUnited");
    private FootballTeam manCity = new FootballTeam("ManchesterCity");
    private FootballTeam spurs = new FootballTeam("TottenhamHotspurs");

    private Player ederson = new Goalkeeper("Ederson", manCity, 6.0);
    private Player steffen = new Goalkeeper("Steffen", manCity, 4.5);
    private Player dias = new Defender("Dias", manCity, 6.0);
    private Player stones = new Defender("Stones", manCity, 5.0);
    private Player cancelo = new Defender("Cancelo", manCity, 5.5);
    private Player walker = new Defender("Walker", manCity, 5.5);
    private Player laporte = new Defender("Laporte", manCity, 5.0);
    private Player deBruyne = new Midfielder("DeBruyne", manCity, 11.5);
    private Player gundogan = new Midfielder("Gundogan", manCity, 6.5);
    private Player rodri = new Midfielder("Rodri", manCity, 5.0);
    private Player foden = new Midfielder("Foden", manCity, 8.0);
    private Player bernardo = new Midfielder("Bernardo", manCity, 7.0);
    private Player jesus = new Striker("Jesus", manCity, 7.5);
    private Player sterling = new Striker("Sterling", manCity, 9.5);
    private Player delap = new Striker("Delap", manCity, 4.5);

    private Player deGea = new Goalkeeper("DeGea", manUtd, 5.5);
    private Player deanHenderson = new Goalkeeper("DeanHenderson", manUtd, 5.0);
    private Player maguire = new Defender("Maguire", manUtd, 5.5);
    private Player lindelof = new Defender("Lindelof", manUtd, 5.0);
    private Player wanBissaka = new Defender("WanBissaka", manUtd, 5.0);
    private Player shaw = new Defender("Shaw", manUtd, 5.5);
    private Player bailey = new Defender("Bailey", manUtd, 4.5);
    private Player fernandes = new Midfielder("Fernandes", manUtd, 11.5);
    private Player sancho = new Midfielder("Sancho", manUtd, 9.5);
    private Player vanDeBeek = new Midfielder("VanDeBeek", manUtd, 5.5);
    private Player pogba = new Midfielder("Pogba", manUtd, 7.0);
    private Player mcTominay = new Midfielder("McTominay", manUtd, 4.5);
    private Player martial = new Striker("Martial", manUtd, 6.0);
    private Player cavani = new Striker("Cavani", manUtd, 8.0);
    private Player rashford = new Striker("Rashford", manUtd, 8.5);

    private Player alisson = new Goalkeeper("Alisson", liverpool, 6.0);
    private Player adrian = new Goalkeeper("Adrian", liverpool, 4.5);
    private Player vanDijk = new Defender("VanDijk", liverpool, 6.0);
    private Player matip = new Defender("Matip", liverpool, 5.0);
    private Player arnold = new Defender("Alexander-Arnold", liverpool, 6.5);
    private Player robertson = new Defender("Robertson", liverpool, 6.5);
    private Player gomez = new Defender("Gomez", liverpool, 5.5);
    private Player jordanHenderson = new Midfielder("Henderson", liverpool, 6.0);
    private Player keita = new Midfielder("Keita", liverpool, 5.5);
    private Player thiago = new Midfielder("Thiago", liverpool, 6.0);
    private Player minamino = new Midfielder("Minamino", liverpool, 5.5);
    private Player fabinho = new Midfielder("Fabinho", liverpool, 5.0);
    private Player salah = new Striker("Salah", liverpool, 12.5);
    private Player mane = new Striker("Mane", liverpool, 10.5);
    private Player firmino = new Striker("Firmino", liverpool, 8.0);

    private Player mendy = new Goalkeeper("Mendy", chelsea, 5.5);
    private Player kepa = new Goalkeeper("Kepa", chelsea, 5.0);
    private Player silva = new Defender("Silva", chelsea, 5.5);
    private Player rudiger = new Defender("Rudiger", chelsea, 5.0);
    private Player james = new Defender("James", chelsea, 5.5);
    private Player chilwell = new Defender("Chilwell", chelsea, 6.0);
    private Player azpilicueta = new Defender("Azpilicueta", chelsea, 5.5);
    private Player kante = new Midfielder("Kante", chelsea, 5.0);
    private Player jorginho = new Midfielder("Jorginho", chelsea, 5.0);
    private Player ziyech = new Midfielder("Ziyech", chelsea, 7.0);
    private Player pulisic = new Midfielder("Pulisic", chelsea, 8.5);
    private Player kovacic = new Midfielder("Kovacic", chelsea, 6.0);
    private Player werner = new Striker("Werner", chelsea, 8.5);
    private Player havertz = new Striker("Havertz", chelsea, 8.5);
    private Player abraham = new Striker("Abraham", chelsea, 4.5);

    private Player leno = new Goalkeeper("Leno", arsenal, 5.5);
    private Player runarsson = new Goalkeeper("Runarsson", arsenal, 4.5);
    private Player holding = new Defender("Holding", arsenal, 5.0);
    private Player gabriel = new Defender("Gabriel", arsenal, 5.0);
    private Player bellerin = new Defender("Bellerin", arsenal, 5.0);
    private Player tierney = new Defender("Tierney", arsenal, 5.5);
    private Player soares = new Defender("Soares", arsenal, 4.5);
    private Player xhaka = new Midfielder("Xhaka", arsenal, 5.5);
    private Player pepe = new Midfielder("Pepe", arsenal, 8.5);
    private Player saka = new Midfielder("Saka", arsenal, 7.0);
    private Player willian = new Midfielder("Willian", arsenal, 7.0);
    private Player partey = new Midfielder("Partey", arsenal, 5.0);
    private Player aubameyang = new Striker("Aubameyang", arsenal, 9.5);
    private Player lacazette = new Striker("Lacazette", arsenal, 8.5);
    private Player nketiah = new Striker("Nketiah", arsenal, 4.5);

    private Player lloris = new Goalkeeper("Lloris", spurs, 5.5);
    private Player hart = new Goalkeeper("Hart", spurs, 4.5);
    private Player alderweireld = new Defender("Alderweireld", spurs, 5.0);
    private Player dier = new Defender("Dier", spurs, 5.0);
    private Player aurier = new Defender("Aurier", spurs, 5.0);
    private Player reguilon = new Defender("Reguilon", spurs, 5.5);
    private Player doherty = new Defender("Doherty", spurs, 5.0);
    private Player hojbjerg = new Midfielder("Hojbjerg", spurs, 5.0);
    private Player sissoko = new Midfielder("Sissoko", spurs, 5.5);
    private Player ndombele = new Midfielder("Ndombele", spurs, 6.5);
    private Player winks = new Midfielder("Winks", spurs, 5.5);
    private Player alli = new Midfielder("Alli", spurs, 6.5);
    private Player kane = new Striker("Kane", spurs, 12.0);
    private Player son = new Striker("Son", spurs, 10.0);
    private Player lucas = new Striker("Lucas", spurs, 7.5);

    private Fixture manCityVmanUtd = new Fixture(manCity, manUtd, "Etihad Stadium");
    private Fixture manCityVchelsea = new Fixture(manCity, chelsea, "Etihad Stadium");
    private Fixture manCityVliverpool = new Fixture(manCity, liverpool, "Etihad Stadium");
    private Fixture manCityVarsenal = new Fixture(manCity, arsenal, "Etihad Stadium");
    private Fixture manCityVspurs = new Fixture(manCity, spurs, "Etihad Stadium");

    private Fixture manUtdVmanCity = new Fixture(manUtd, manCity, "Old Trafford");
    private Fixture manUtdVchelsea = new Fixture(manUtd, chelsea, "Old Trafford");
    private Fixture manUtdVliverpool = new Fixture(manUtd, liverpool, "Old Trafford");
    private Fixture manUtdVarsenal = new Fixture(manUtd, arsenal, "Old Trafford");
    private Fixture manUtdVspurs = new Fixture(manUtd, spurs, "Old Trafford");

    private Fixture chelseaVmanCity = new Fixture(chelsea, manCity, "Stamford Bridge");
    private Fixture chelseaVmanUtd = new Fixture(chelsea, manUtd, "Stamford Bridge");
    private Fixture chelseaVliverpool = new Fixture(chelsea, liverpool, "Stamford Bridge");
    private Fixture chelseaVarsenal = new Fixture(chelsea, arsenal, "Stamford Bridge");
    private Fixture chelseaVspurs = new Fixture(chelsea, spurs, "Stamford Bridge");

    private Fixture liverpoolVmanUtd = new Fixture(liverpool, manUtd, "Anfield");
    private Fixture liverpoolVchelsea = new Fixture(liverpool, chelsea, "Anfield");
    private Fixture liverpoolVmanCity = new Fixture(liverpool, manCity, "Anfield");
    private Fixture liverpoolVarsenal = new Fixture(liverpool, arsenal, "Anfield");
    private Fixture liverpoolVspurs = new Fixture(liverpool, spurs, "Anfield");

    private Fixture arsenalVmanUtd = new Fixture(arsenal, manUtd, "Emirates Stadium");
    private Fixture arsenalVchelsea = new Fixture(arsenal, chelsea, "Emirates Stadium");
    private Fixture arsenalVliverpool = new Fixture(arsenal, liverpool, "Emirates Stadium");
    private Fixture arsenalVmanCity = new Fixture(arsenal, manCity, "Emirates Stadium");
    private Fixture arsenalVspurs = new Fixture(arsenal, spurs, "Emirates Stadium");

    private Fixture spursVmanUtd = new Fixture(spurs, manUtd, "Tottenham Hotspur Stadium");
    private Fixture spursVchelsea = new Fixture(spurs, chelsea, "Tottenham Hotspur Stadium");
    private Fixture spursVliverpool = new Fixture(spurs, liverpool, "Tottenham Hotspur Stadium");
    private Fixture spursVarsenal = new Fixture(spurs, arsenal, "Tottenham Hotspur Stadium");
    private Fixture spursVmanCity = new Fixture(spurs, manCity, "Tottenham Hotspur Stadium");


    //EFFECTS - creates a Fantasy Application, displays tabs and sidebars
    public FantasyApp() throws FileNotFoundException {
        super("FantasyPL Assist");

        setUp();

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.RIGHT);

        setLocationRelativeTo(null);
        loadTabs();
        add(sidebar);
        setIconImage(new ImageIcon("./data/FPLIcon.png").getImage());
        setVisible(true);

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        runFantasyApp();
    }

    //EFFECTS - triggers all the necessary methods to run the program
    public void setUp() {
        setDetailsForArsenal();
        setDetailsForChelsea();
        setDetailsForLiverpool();
        setDetailsForManUtd();
        setDetailsForManCity();
        setDetailsForSpurs();
        addPlayersToArsenal();
        addPlayersToChelsea();
        addPlayersToLiverpool();
        addPlayersToManUtd();
        addPlayersToManCity();
        addPlayersToSpurs();
        addFixturesToArsenal();
        addFixturesToChelsea();
        addFixturesToLiverpool();
        addFixturesToManCity();
        addFixturesToManUtd();
        addFixturesToSpurs();
        addTeamsToList();
        input = new Scanner(System.in);
    }

    //MODIFIES - this
    //EFFECTS  - set the details for ManchesterCity football team
    public void setDetailsForManCity() {
        manCity.setRanking(1);
        manCity.setNumWin(27);
        manCity.setNumDraw(5);
        manCity.setNumLoss(6);
        manCity.setGoalsScored(83);
        manCity.setGoalsConceded(32);
    }

    //MODIFIES - this
    //EFFECTS  - add players to ManchesterCity football team
    public void addPlayersToManCity() {
        manCity.addPlayer(ederson);
        manCity.addPlayer(steffen);
        manCity.addPlayer(dias);
        manCity.addPlayer(stones);
        manCity.addPlayer(cancelo);
        manCity.addPlayer(walker);
        manCity.addPlayer(laporte);
        manCity.addPlayer(deBruyne);
        manCity.addPlayer(gundogan);
        manCity.addPlayer(rodri);
        manCity.addPlayer(foden);
        manCity.addPlayer(bernardo);
        manCity.addPlayer(jesus);
        manCity.addPlayer(sterling);
        manCity.addPlayer(delap);
    }

    //MODIFIES - this
    //EFFECTS - adds fixtures to ManchesterCity football team
    public void addFixturesToManCity() {
        manCity.addFixtures(spursVmanCity);
        manCity.addFixtures(manCityVarsenal);
        manCity.addFixtures(chelseaVmanCity);
        manCity.addFixtures(liverpoolVmanCity);
        manCity.addFixtures(manUtdVmanCity);
        manCity.addFixtures(arsenalVmanCity);
        manCity.addFixtures(manCityVchelsea);
        manCity.addFixtures(manCityVspurs);
        manCity.addFixtures(manCityVmanUtd);
        manCity.addFixtures(manCityVliverpool);
    }

    //EFFECTS - prints details for ManchesterCity football team
    public StringBuilder printDetailsForManCity() {
        return printDetailsForTeam(manCity);
    }

    //MODIFIES - this
    //EFFECTS  - set the details for ManchesterUnited football team
    public void setDetailsForManUtd() {
        manUtd.setRanking(2);
        manUtd.setNumWin(21);
        manUtd.setNumDraw(11);
        manUtd.setNumLoss(6);
        manUtd.setGoalsScored(73);
        manUtd.setGoalsConceded(44);
    }

    //MODIFIES - this
    //EFFECTS  - add players to ManchesterUnited football team
    public void addPlayersToManUtd() {
        manUtd.addPlayer(deGea);
        manUtd.addPlayer(deanHenderson);
        manUtd.addPlayer(maguire);
        manUtd.addPlayer(lindelof);
        manUtd.addPlayer(wanBissaka);
        manUtd.addPlayer(shaw);
        manUtd.addPlayer(bailey);
        manUtd.addPlayer(fernandes);
        manUtd.addPlayer(sancho);
        manUtd.addPlayer(vanDeBeek);
        manUtd.addPlayer(pogba);
        manUtd.addPlayer(mcTominay);
        manUtd.addPlayer(martial);
        manUtd.addPlayer(cavani);
        manUtd.addPlayer(rashford);
    }

    //MODIFIES - this
    //EFFECTS - adds fixtures to ManchesterUnited football team
    public void addFixturesToManUtd() {
        manUtd.addFixtures(manUtdVliverpool);
        manUtd.addFixtures(spursVmanUtd);
        manUtd.addFixtures(manUtdVmanCity);
        manUtd.addFixtures(chelseaVmanUtd);
        manUtd.addFixtures(manUtdVarsenal);
        manUtd.addFixtures(manCityVmanUtd);
        manUtd.addFixtures(manUtdVspurs);
        manUtd.addFixtures(liverpoolVmanUtd);
        manUtd.addFixtures(arsenalVmanUtd);
        manUtd.addFixtures(manUtdVchelsea);
    }

    //EFFECTS - prints details for ManchesterUnited football team
    public StringBuilder printDetailsForManUtd() {
        return printDetailsForTeam(manUtd);
    }

    //MODIFIES - this
    //EFFECTS  - set the details for Liverpool football team
    public void setDetailsForLiverpool() {
        liverpool.setRanking(3);
        liverpool.setNumWin(20);
        liverpool.setNumDraw(9);
        liverpool.setNumLoss(9);
        liverpool.setGoalsScored(68);
        liverpool.setGoalsConceded(42);
    }

    //MODIFIES - this
    //EFFECTS  - add players to Liverpool football team
    public void addPlayersToLiverpool() {
        liverpool.addPlayer(alisson);
        liverpool.addPlayer(adrian);
        liverpool.addPlayer(vanDijk);
        liverpool.addPlayer(matip);
        liverpool.addPlayer(arnold);
        liverpool.addPlayer(robertson);
        liverpool.addPlayer(gomez);
        liverpool.addPlayer(jordanHenderson);
        liverpool.addPlayer(keita);
        liverpool.addPlayer(thiago);
        liverpool.addPlayer(minamino);
        liverpool.addPlayer(fabinho);
        liverpool.addPlayer(salah);
        liverpool.addPlayer(mane);
        liverpool.addPlayer(firmino);
    }

    //MODIFIES - this
    //EFFECTS - adds fixtures to Liverpool football team
    public void addFixturesToLiverpool() {
        liverpool.addFixtures(liverpoolVchelsea);
        liverpool.addFixtures(liverpoolVmanCity);
        liverpool.addFixtures(manUtdVliverpool);
        liverpool.addFixtures(liverpoolVarsenal);
        liverpool.addFixtures(spursVliverpool);
        liverpool.addFixtures(chelseaVliverpool);
        liverpool.addFixtures(arsenalVliverpool);
        liverpool.addFixtures(liverpoolVmanUtd);
        liverpool.addFixtures(manCityVliverpool);
        liverpool.addFixtures(liverpoolVspurs);
    }

    //EFFECTS - prints details for Liverpool football team
    public StringBuilder printDetailsForLiverpool() {
        return printDetailsForTeam(liverpool);
    }

    //MODIFIES - this
    //EFFECTS  - set the details for Chelsea football team
    public void setDetailsForChelsea() {
        chelsea.setRanking(4);
        chelsea.setNumWin(19);
        chelsea.setNumDraw(10);
        chelsea.setNumLoss(9);
        chelsea.setGoalsScored(58);
        chelsea.setGoalsConceded(36);
    }

    //MODIFIES - this
    //EFFECTS  - add players to Chelsea football team
    public void addPlayersToChelsea() {
        chelsea.addPlayer(mendy);
        chelsea.addPlayer(kepa);
        chelsea.addPlayer(silva);
        chelsea.addPlayer(rudiger);
        chelsea.addPlayer(james);
        chelsea.addPlayer(chilwell);
        chelsea.addPlayer(azpilicueta);
        chelsea.addPlayer(kante);
        chelsea.addPlayer(jorginho);
        chelsea.addPlayer(ziyech);
        chelsea.addPlayer(pulisic);
        chelsea.addPlayer(kovacic);
        chelsea.addPlayer(werner);
        chelsea.addPlayer(havertz);
        chelsea.addPlayer(abraham);
    }

    //MODIFIES - this
    //EFFECTS - adds fixtures to Chelsea football team
    public void addFixturesToChelsea() {
        chelsea.addFixtures(arsenalVchelsea);
        chelsea.addFixtures(liverpoolVchelsea);
        chelsea.addFixtures(spursVchelsea);
        chelsea.addFixtures(chelseaVmanCity);
        chelsea.addFixtures(chelseaVmanUtd);
        chelsea.addFixtures(chelseaVliverpool);
        chelsea.addFixtures(manCityVchelsea);
        chelsea.addFixtures(chelseaVspurs);
        chelsea.addFixtures(chelseaVarsenal);
        chelsea.addFixtures(manUtdVchelsea);
    }

    //EFFECTS - prints details for Chelsea football team
    public StringBuilder printDetailsForChelsea() {
        return printDetailsForTeam(chelsea);
    }

    //MODIFIES - this
    //EFFECTS  - set the details for Arsenal football team
    public void setDetailsForArsenal() {
        arsenal.setRanking(8);
        arsenal.setNumWin(18);
        arsenal.setNumDraw(7);
        arsenal.setNumLoss(13);
        arsenal.setGoalsScored(55);
        arsenal.setGoalsConceded(39);
    }

    //MODIFIES - this
    //EFFECTS  - add players to Arsenal football team
    public void addPlayersToArsenal() {
        arsenal.addPlayer(leno);
        arsenal.addPlayer(runarsson);
        arsenal.addPlayer(holding);
        arsenal.addPlayer(gabriel);
        arsenal.addPlayer(bellerin);
        arsenal.addPlayer(tierney);
        arsenal.addPlayer(soares);
        arsenal.addPlayer(xhaka);
        arsenal.addPlayer(pepe);
        arsenal.addPlayer(saka);
        arsenal.addPlayer(willian);
        arsenal.addPlayer(partey);
        arsenal.addPlayer(aubameyang);
        arsenal.addPlayer(lacazette);
        arsenal.addPlayer(nketiah);
    }

    //MODIFIES - this
    //EFFECTS - adds fixtures to Arsenal football team
    public void addFixturesToArsenal() {
        arsenal.addFixtures(arsenalVchelsea);
        arsenal.addFixtures(manCityVarsenal);
        arsenal.addFixtures(arsenalVspurs);
        arsenal.addFixtures(liverpoolVarsenal);
        arsenal.addFixtures(manUtdVarsenal);
        arsenal.addFixtures(arsenalVmanCity);
        arsenal.addFixtures(spursVarsenal);
        arsenal.addFixtures(chelseaVarsenal);
        arsenal.addFixtures(arsenalVliverpool);
        arsenal.addFixtures(arsenalVmanUtd);
    }

    //EFFECTS - prints details for Arsenal football team
    public StringBuilder printDetailsForArsenal() {
        return printDetailsForTeam(arsenal);
    }

    //MODIFIES - this
    //EFFECTS  - set the details for TottenhamHotspurs football team
    public void setDetailsForSpurs() {
        spurs.setRanking(7);
        spurs.setNumWin(18);
        spurs.setNumDraw(8);
        spurs.setNumLoss(12);
        spurs.setGoalsScored(68);
        spurs.setGoalsConceded(45);
    }

    //MODIFIES - this
    //EFFECTS  - add players to TottenhamHotspurs football team
    public void addPlayersToSpurs() {
        spurs.addPlayer(lloris);
        spurs.addPlayer(hart);
        spurs.addPlayer(alderweireld);
        spurs.addPlayer(dier);
        spurs.addPlayer(aurier);
        spurs.addPlayer(reguilon);
        spurs.addPlayer(doherty);
        spurs.addPlayer(hojbjerg);
        spurs.addPlayer(sissoko);
        spurs.addPlayer(ndombele);
        spurs.addPlayer(winks);
        spurs.addPlayer(alli);
        spurs.addPlayer(kane);
        spurs.addPlayer(son);
        spurs.addPlayer(lucas);
    }

    //MODIFIES - this
    //EFFECTS - adds fixtures to Spurs football team
    public void addFixturesToSpurs() {
        spurs.addFixtures(spursVmanCity);
        spurs.addFixtures(spursVchelsea);
        spurs.addFixtures(arsenalVspurs);
        spurs.addFixtures(spursVmanUtd);
        spurs.addFixtures(spursVliverpool);
        spurs.addFixtures(spursVarsenal);
        spurs.addFixtures(chelseaVspurs);
        spurs.addFixtures(manCityVspurs);
        spurs.addFixtures(manUtdVspurs);
        spurs.addFixtures(liverpoolVspurs);
    }

    //EFFECTS - prints details for TottenhamHotspurs football team
    public StringBuilder printDetailsForSpurs() {
        return printDetailsForTeam(spurs);
    }

    public StringBuilder printDetailsForTeam(FootballTeam ft) {
        txt = new StringBuilder();
        helperPrintTeamDetails1(ft, txt);
        helperPrintTeamDetails2(ft, txt);
        return txt;
    }

    public void helperPrintTeamDetails1(FootballTeam ft, StringBuilder txt) {
        System.out.println("Team details of " + ft.getTeamName() + "\n");
        txt.append("Team details of " + ft.getTeamName() + "\n");
        System.out.println("Team Name - " + ft.getTeamName());
        txt.append("\nTeam Name - " + ft.getTeamName() + "\n");
        System.out.println("Team Ranking - " + ft.getRanking() + "\n");
        txt.append("Team Ranking - " + ft.getRanking() + "\n");
        System.out.println("Number of Wins - " + ft.getNumWins());
        txt.append("Number of Wins - " + ft.getNumWins() + "\n");
        System.out.println("Number of Draws - " + ft.getNumDraw());
        txt.append("Number of Draws - " + ft.getNumDraw() + "\n");
        System.out.println("Number of Loss - " + ft.getNumLoss());
        txt.append("Number of Loss - " + ft.getNumLoss() + "\n");
        System.out.println("Number of goals scored - " + ft.getGoalsScored());
        txt.append("Number of goals scored - " + ft.getGoalsScored() + "\n");
        System.out.println("Number of goals conceded - " + ft.getGoalsConceded() + "\n");
        txt.append("Number of goals conceded- " + ft.getGoalsConceded() + "\n");
        System.out.println("Team fixtures in order - \n");
        txt.append("\nTeam fixtures in order -" + "\n");
    }

    public void helperPrintTeamDetails2(FootballTeam ft, StringBuilder txt) {
        for (Fixture f : ft.getTeamFixtures()) {
            System.out.println(f.getHomeTeam().getTeamName() + " VS " + f.getAwayTeam().getTeamName()
                    + " @ " + f.getVenue());
            txt.append(f.getHomeTeam().getTeamName() + " VS " + f.getAwayTeam().getTeamName() + " @ " + f.getVenue()
                    + "\n");
        }
        System.out.println("\nTeam players are as follow - \n");
        txt.append("\nTeam players are as follow - \n");
        for (Player p : ft.getTeam()) {
            System.out.println("Name - " + p.getName());
            txt.append("Name - " + p.getName() + "\n");
            System.out.println("Position - " + p.getPosition());
            txt.append("Position - " + p.getPosition() + "\n");
        }
    }

    //MODIFIES - this
    //EFFECTS  - add available teams to a list
    public void addTeamsToList() {
        footballTeamList.add(arsenal);
        footballTeamList.add(chelsea);
        footballTeamList.add(liverpool);
        footballTeamList.add(manUtd);
        footballTeamList.add(manCity);
        footballTeamList.add(spurs);
    }

    //Source and Credits to TellerApp project by CPSC210 team
    //EFFECTS - runs the FantasyApp program
    public void runFantasyApp() {

        boolean keepGoing = true;
        String command = null;

        System.out.println("Welcome to FantasyPL Assist \n");

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommandForMenu(command);
            }
        }
        System.out.println("\nGoodLuck with your gameweek Manager!");
    }

    // EFFECTS: displays menu of options to user
    public void displayMenu() {
        System.out.println("Select from - ");
        System.out.println("\tm -> Manage fantasy team");
        System.out.println("\tv -> View football teams and stats");
        System.out.println("\tq -> Quit the program");
    }

    // EFFECTS: processes the command input by user for the main menu
    public void processCommandForMenu(String command) {
        if (command.equals("m")) {
            rulesExplained();
            setUpMyFantasyTeam();
        } else if (command.equals("v")) {
            viewTeams();
        } else {
            System.out.println("Invalid selection! Please reselect your option");
        }
    }

    //EFFECTS - explains basic rules of FPL
    public void rulesExplained() {
        System.out.println("Fantasy PL Rules - \n");
        System.out.println("You will have a budget of $100m to add 15 players to your fantasy team.");
        System.out.println("You will be adding 2 Goalkeepers, 5 Defenders, 5 Midfielders and 3 Strikers.");
        System.out.println("You can only choose 3 players maximum from the same team. \n");
    }

    //EFFECTS - creates a fantasy Team
    public void setUpMyFantasyTeam() {
        boolean keepGoing = true;
        String command = null;

        while (keepGoing) {
            displayFantasyMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("b")) {
                keepGoing = false;
            } else {
                processCommandForSetUpFantasy(command);
            }
        }
    }

    // EFFECTS: displays menu of fantasy options to user
    public void displayFantasyMenu() {
        System.out.println("Select the options below - ");
        System.out.println("\ta -> Add player");
        System.out.println("\tr -> Remove player");
        System.out.println("\tv -> View my fantasy team");
        System.out.println("\tc -> Check my remaining balance");
        System.out.println("\ts -> Save my fantasy team");
        System.out.println("\tl -> Load my fantasy team");
        System.out.println("\tb -> Back to main menu");
    }

    // EFFECTS: processes the command input by user for the fantasy
    public void processCommandForSetUpFantasy(String command) {
        if (command.equals("a")) {
            addPlayerToMyFantasyTeam();
        } else if (command.equals("r")) {
            removePlayerFromMyFantasyTeam();
        } else if (command.equals("v")) {
            viewMyFantasyTeam();
        } else if (command.equals("c")) {
            checkRemainingBalance();
        } else if (command.equals("s")) {
            saveMyFantasyTeam();
        } else if (command.equals("l")) {
            loadMyFantasyTeam();
        } else {
            System.out.println("Invalid selection! Please reselect your option");
        }
    }

    //MODIFIES - this
    //EFFECTS - adds a player to the fantasy team
    public void addPlayerToMyFantasyTeam() {
        displayTeamNamesForFantasy();
        System.out.println("Type in team's name to look for players");
        String teamName = input.next();
        displayPlayersForGivenTeam(teamName);
        System.out.println("Type in your player's name");
        String playerName = input.next();
        playerAddition(playerName);
    }

    public StringBuilder displayPlayersForGivenTeam(String teamName) {
        boolean founded = false;
        StringBuilder displayPlayers = new StringBuilder();
        for (FootballTeam ft : footballTeamList) {
            if (teamName.equals(ft.getTeamName())) {
                founded = true;
                teamFounded = ft;
                printPlayerNamesAndPriceForAGivenTeam(ft);
                displayPlayers = printPlayerNamesAndPriceForAGivenTeam(ft);
            }
        }
        if (founded) {
            return displayPlayers;
        } else {
            return displayPlayers.append("Invalid team selection! \nAdd player again by pressing Add Player");
        }
    }

    public String playerAddition(String playerName) {
        bool = false;
        String toReturn = "";
        for (Player p : teamFounded.getTeam()) {
            if (playerName.equals(p.getName())) {
                if (myFantasyTeam.addPlayer(p)) {
                    System.out.println("Addition of " + playerName + " successful!");
                    toReturn = "Addition of " + playerName + " successful!";
                    bool = true;
                }
            }
        }
        if (!bool) {
            System.out.println("Addition of " + playerName + " failed!");
            toReturn = "Addition of " + playerName + " failed!";
        }
        return toReturn;
    }

    //EFFECTS - prints out the player names from the given team
    public StringBuilder printPlayerNamesAndPriceForAGivenTeam(FootballTeam team) {
        StringBuilder txt = new StringBuilder();
        for (Player p : team.getTeam()) {
            System.out.println(p.getName() + " - $" + p.getPrice() + "m");
            txt.append(p.getName() + " - $" + p.getPrice() + "m \n");
        }
        return txt;
    }

    // EFFECTS: prints out team names
    public StringBuilder displayTeamNamesForFantasy() {
        teamNames = new StringBuilder();
        System.out.println("List of Teams - \n");
        teamNames.append("List of Teams - \n");
        System.out.println("\tArsenal");
        teamNames.append("\nArsenal\n");
        System.out.println("\tChelsea");
        teamNames.append("Chelsea\n");
        System.out.println("\tLiverpool");
        teamNames.append("Liverpool\n");
        System.out.println("\tManchesterUnited");
        teamNames.append("ManchesterUnited\n");
        System.out.println("\tManchesterCity");
        teamNames.append("ManchesterCity\n");
        System.out.println("\tTottenhamHotspurs\n");
        teamNames.append("TottenhamHotspurs\n");
        return teamNames;
    }

    //MODIFIES - this
    //EFFECTS - removes a player from the fantasy team
    public void removePlayerFromMyFantasyTeam() {
        String name;
        System.out.println("Type in player's name");
        name = input.next();
        removePlayer(name);
    }

    public String removePlayer(String name) {
        returnStatement = "Removal failed!";
        for (Player p : myFantasyTeam.getTeam()) {
            if (name.equals(p.getName())) {
                myFantasyTeam.removePlayer(p);
                System.out.println("Removal of " + name + " successful!");
                returnStatement = "Removal of " + name + " successful!";
            }
        }
        return returnStatement;
    }

    //EFFECTS - view the player names of the current fantasy team
    public StringBuilder viewMyFantasyTeam() {
        StringBuilder fantasyTeam = new StringBuilder();
        System.out.println("Players in my fantasy team - ");
        for (Player p : myFantasyTeam.getTeam()) {
            System.out.println(p.getName());
            fantasyTeam.append(p.getName() + "\n");
        }
        return fantasyTeam;
    }

    //EFFECTS - view the balance of the current fantasy team
    public String checkRemainingBalance() {
        System.out.println("Remaining Balance - $" + myFantasyTeam.getRemainingBalance());
        return ("Remaining Balance - $" + myFantasyTeam.getRemainingBalance());
    }

    //EFFECTS - view the stats of the teams available
    public void viewTeams() {
        boolean keepGoing = true;
        String command = null;

        while (keepGoing) {
            displayTeamMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("b")) {
                keepGoing = false;
            } else {
                processCommandForViewTeam(command);
            }
        }
    }

    //EFFECTS - prints out the menu for viewing Teams
    public void displayTeamMenu() {
        System.out.println("Select a team - ");
        System.out.println("\ta -> Arsenal");
        System.out.println("\tc -> Chelsea");
        System.out.println("\tl -> Liverpool");
        System.out.println("\tmu -> ManchesterUnited");
        System.out.println("\tmc -> ManchesterCity");
        System.out.println("\ts -> TottenhamHotspurs \n");
        System.out.println("\tb -> Back to main menu");
    }

    // EFFECTS: processes the command input by user for viewing teams
    public void processCommandForViewTeam(String command) {
        if (command.equals("a")) {
            printDetailsForArsenal();
            System.out.println("\n");
        } else if (command.equals("c")) {
            printDetailsForChelsea();
            System.out.println("\n");
        } else if (command.equals("l")) {
            printDetailsForLiverpool();
            System.out.println("\n");
        } else if (command.equals("mu")) {
            printDetailsForManUtd();
            System.out.println("\n");
        } else if (command.equals("mc")) {
            printDetailsForManCity();
            System.out.println("\n");
        } else if (command.equals("s")) {
            printDetailsForSpurs();
            System.out.println("\n");
        } else {
            System.out.println("Invalid selection! Please reselect your option");
        }
    }

    //EFFECTS - stores the current fantasy team in a file
    public String saveMyFantasyTeam() {
        String output;
        try {
            jsonWriter.open();
            jsonWriter.write(myFantasyTeam);
            jsonWriter.close();
            System.out.println("Current fantasy team saved to: " + JSON_STORE);
            output = "Current fantasy team saved to: " + JSON_STORE;
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save your team to: " + JSON_STORE);
            output = "Unable to save your team to: " + JSON_STORE;
        }
        return output;
    }

    //EFFECTS - loads the last saved fantasy team to the app
    public String loadMyFantasyTeam() {
        String output;
        try {
            myFantasyTeam = jsonReader.read();
            System.out.println("Loaded your previous team from " + JSON_STORE);
            output = "Loaded your previous team from " + JSON_STORE;
        } catch (IOException e) {
            System.out.println("Unable to read from: " + JSON_STORE);
            output = "Unable to read from: " + JSON_STORE;
        }
        return output;
    }

    //MODIFIES: this
    //EFFECTS: adds home tab, fantasy tab and stats tab to this UI
    private void loadTabs() {
        JPanel homeTab = new HomeTab(this);
        JPanel settingsTab = new FantasyTab(this);
        JPanel reportTab = new StatsTab(this);
        JPanel instructionTab = new InstructionTab(this);

        sidebar.add(homeTab, HOME_TAB_INDEX);
        sidebar.setTitleAt(HOME_TAB_INDEX, "Home");
        sidebar.add(settingsTab, FANTASY_TAB_INDEX);
        sidebar.setTitleAt(FANTASY_TAB_INDEX, "Fantasy");
        sidebar.add(reportTab, TEAMS_TAB_INDEX);
        sidebar.setTitleAt(TEAMS_TAB_INDEX, "Teams");
        sidebar.add(instructionTab, INSTRUCTIONS_TAB_INDEX);
        sidebar.setTitleAt(INSTRUCTIONS_TAB_INDEX, "Instructions");
    }

    //EFFECTS: returns sidebar of this UI
    public JTabbedPane getTabbedPane() {
        return sidebar;
    }
}
