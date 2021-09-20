package ui.tabs;

import ui.ButtonNames;
import ui.FantasyApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//EFFECTS - A class for an stats tab of the program
public class StatsTab extends Tab {

    private static final Font textFont = new Font("Arial", Font.PLAIN, 17);

    private static JTextField team;
    private static JTextArea displayTeam;
    private static JScrollPane sp;

    private static final Dimension buttonDimension = new Dimension(100, 30);

    //EFFECTS - constructor to add a tabs that display stats of football teams
    public StatsTab(FantasyApp fantasyApp) {
        super(fantasyApp);

        JPanel teams = new JPanel();
        teams.setLayout(new BoxLayout(teams, BoxLayout.Y_AXIS));

        initializeInstruction(teams);
        enterTeam(teams);
        teams.add(Box.createVerticalStrut(10));
        displayTeam(teams);

        this.add(teams);
    }

    //MODIFIES - teams
    //EFFECTS - initializes all the instructions to view teams
    public void initializeInstruction(JPanel teams) {
        JPanel instructions = new JPanel();
        instructions.setLayout(new BoxLayout(instructions, BoxLayout.Y_AXIS));
        JTextArea teamsDisplay = new JTextArea(8, WIDTH);
        teamsDisplay.setFont(textFont);
        teamsDisplay.setEditable(false);
        teamsDisplay.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        JTextField instruction = new JTextField("Type in the team from the panel to view its stats", 50);
        instruction.setFont(textFont);
        instruction.setAlignmentX(Component.CENTER_ALIGNMENT);
        instruction.setEditable(false);

        teamsDisplay.setText("Select a team - \n \ta -> Arsenal \n \tc -> Chelsea \n \tl -> Liverpool \n "
                + "\tmu -> Manchester United \n \tmc -> Manchester City \n \ts -> Tottenham Hotspurs");

        instructions.add(teamsDisplay);
        instructions.add(Box.createVerticalStrut(20));
        instructions.add(instruction);
        instructions.add(Box.createVerticalStrut(20));

        teams.add(instructions, Component.LEFT_ALIGNMENT);
    }

    //MODIFIES - teams
    //EFFECTS - creates a text field and a button for user to enter input data.
    public void enterTeam(JPanel teams) {
        JPanel enterTeam = new JPanel();
        enterTeam.setLayout(new FlowLayout());
        team = new JTextField(100);

        JButton submitButton = new JButton(ButtonNames.SUBMIT.getValue());
        submitButton.setPreferredSize(buttonDimension);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals(ButtonNames.SUBMIT.getValue())) {
                    executeTeams();
                }
            }
        });

        enterTeam.add(team);
        enterTeam.add(Box.createHorizontalStrut(20));
        enterTeam.add(submitButton);

        teams.add(enterTeam);
    }

    //MODIFIES - teams
    //EFFECTS - creates a scroll panel to display output
    public void displayTeam(JPanel teams) {
        displayTeam = new JTextArea(15, 50);
        displayTeam.setEditable(false);
        displayTeam.setFont(textFont);

        sp = new JScrollPane(displayTeam);

        teams.add(sp);
    }

    //EFFECTS - displays teams depending on the input text by the user
    public void executeTeams() {
        switch (team.getText()) {
            case "a" :
                displayTeam.setText(getFantasyApp().printDetailsForArsenal().toString());
                break;
            case "c" :
                displayTeam.setText(getFantasyApp().printDetailsForChelsea().toString());
                break;
            case "l" :
                displayTeam.setText(getFantasyApp().printDetailsForLiverpool().toString());
                break;
            case "mu" :
                displayTeam.setText(getFantasyApp().printDetailsForManUtd().toString());
                break;
            case "mc" :
                displayTeam.setText(getFantasyApp().printDetailsForManCity().toString());
                break;
            case "s" :
                displayTeam.setText(getFantasyApp().printDetailsForSpurs().toString());
                break;
            default:
                displayTeam.setText("Invalid selection! Please reselect your option");
                break;
        }
    }

}
