package ui.tabs;

import ui.ButtonNames;
import ui.FantasyApp;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//EFFECTS - A class for a fantasy team tab of the program
public class FantasyTab extends Tab {

    private static final String RULEINTRO = "Fantasy PL Rules - \n";
    private static final String RULE1 = "You will have a budget of $100m to add 15 players to your fantasy team. ";
    private static final String RULE2 = "2 Goalkeepers, 5 Defenders, 5 Midfielders and 3 Strikers are required. ";
    private static final String RULE3 = "You can only choose 3 players maximum from the same team. \n";

    private static final int CENTER = SwingConstants.CENTER;
    private static final int LEFT_PADDING = 70;
    private static final int BOTTOM_PADDING = 5;

    private static final Dimension buttonDimension = new Dimension(200, 30);

    private static JPanel textPanel;
    private static JPanel fantasyTab;
    private static JPanel buttonsLayout;
    private static JPanel displayScreen;
    private static JTextField enterText;
    private static JTextField displayText;
    private static JTextArea players;
    private static JTextArea fantasyTeam;
    private static JButton addTeamButton;
    private static JButton addPlayerButton;
    private static JButton removePlayerButton;

    private static String buttonPressed;

    private static Font textFont = new Font("Georgia", Font.PLAIN, 15);

    private Border border;

    //EFFECTS - constructor to create a tab consisting of fantasy team
    public FantasyTab(FantasyApp fantasyApp) {
        super(fantasyApp);

        border = BorderFactory.createEmptyBorder(0, LEFT_PADDING, BOTTOM_PADDING, 0);
        fantasyTab = new JPanel();
        fantasyTab.setLayout(new BoxLayout(fantasyTab, BoxLayout.Y_AXIS));

        rulesExplained();
        fantasyTab.add(Box.createVerticalStrut(30));
        addButtons();
        fantasyTab.add(Box.createVerticalStrut(30));
        displayBoxSection();
        fantasyTab.add(Box.createVerticalStrut(30));
        displayPanels();

        this.add(fantasyTab);
    }

    //MODIFIES - this
    //EFFECTS - produces the explained rules
    public void rulesExplained() {
        JLabel ruleIntro = new JLabel(RULEINTRO, CENTER);
        ruleIntro.setFont(new Font("Arial", Font.ITALIC, 20));
        JLabel ruleDetails = new JLabel(RULE1 + RULE2 + RULE3, CENTER);
        ruleDetails.setFont(new Font("Arial", Font.CENTER_BASELINE, 13));

        this.add(ruleIntro);
        this.add(ruleDetails);
    }

    //MODIFIES - fantasyTab
    //EFFECTS - add all buttons to the frame
    public void addButtons() {
        buttonsLayout = new JPanel();
        buttonsLayout.setLayout(new FlowLayout(5));
        addAddButton();
        addRemoveButton();
        addViewTeamButton();
        addBalanceButton();
        addSaveButton();
        addLoadButton();
        fantasyTab.add(buttonsLayout);
    }

    //MODIFIES - buttonsLayout
    //EFFECTS - add ADD Player button to the frame
    public void addAddButton() {
        JButton addButton = new JButton(ButtonNames.ADDPLAYER.getValue());
        addButton.setPreferredSize(buttonDimension);
        formatButtonRow(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPressed = e.getActionCommand();
                if (buttonPressed.equals(ButtonNames.ADDPLAYER.getValue())) {
                    displayText.setText("Type in team's name");
                    players.setText(getFantasyApp().displayTeamNamesForFantasy().toString());
                }
            }
        });
        buttonsLayout.add(addButton);
    }

    //MODIFIES - this
    //EFFECTS - add action for the Enter (Team) Button to the frame
    public void addTeamButtonAction() {
        addTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPressed = e.getActionCommand();
                if (buttonPressed.equals(ButtonNames.ADDTEAM.getValue())) {
                    players.setText(getFantasyApp().displayPlayersForGivenTeam(enterText.getText()).toString());
                    displayText.setText("Type in player's name from panel below");
                }
            }
        });
    }

    //MODIFIES - this
    //EFFECTS - add action for the Enter (Player) Button to the frame
    public void addPlayerButtonAction() {
        addPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPressed = e.getActionCommand();
                if (buttonPressed.equals(ButtonNames.ADD.getValue())) {
                    displayText.setText(getFantasyApp().playerAddition(enterText.getText()));
                }
            }
        });
    }

    //MODIFIES - buttonsLayout
    //EFFECTS - add Remove Player button to the frame
    public void addRemoveButton() {
        JButton removeButton = new JButton(ButtonNames.REMOVEPLAYER.getValue());
        removeButton.setPreferredSize(buttonDimension);
        formatButtonRow(removeButton);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPressed = e.getActionCommand();
                if (buttonPressed.equals(ButtonNames.REMOVEPLAYER.getValue())) {
                    displayText.setText("Type in player's name from your team to remove");
                }
            }
        });
        buttonsLayout.add(removeButton);
    }

    //MODIFIES - this
    //EFFECTS - add REMOVE button to the frame
    public void removeButtonAction() {
        removePlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPressed = e.getActionCommand();
                if (buttonPressed.equals(ButtonNames.REMOVE.getValue())) {
                    displayText.setText(getFantasyApp().removePlayer(enterText.getText()));
                }
            }
        });
    }

    //MODIFIES - buttonsLayout
    //EFFECTS - add View Team button to the frame
    public void addViewTeamButton() {
        JButton viewTeamButton = new JButton(ButtonNames.VIEWTEAM.getValue());
        viewTeamButton.setPreferredSize(buttonDimension);
        formatButtonRow(viewTeamButton);
        viewTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals(ButtonNames.VIEWTEAM.getValue())) {
                    fantasyTeam.setText(getFantasyApp().viewMyFantasyTeam().toString());
                }
            }
        });
        buttonsLayout.add(viewTeamButton);
    }

    //MODIFIES - buttonsLayout
    //EFFECTS - add Balance button to the frame
    public void addBalanceButton() {
        JButton balanceButton = new JButton(ButtonNames.CHECKBALANCE.getValue());
        balanceButton.setPreferredSize(buttonDimension);
        formatButtonRow(balanceButton);

        balanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals(ButtonNames.CHECKBALANCE.getValue())) {
                    displayText.setText(getFantasyApp().checkRemainingBalance());
                }
            }
        });
        buttonsLayout.add(balanceButton);
    }

    //MODIFIES - buttonsLayout
    //EFFECTS - add SAVE button to the frame
    public void addSaveButton() {
        JButton saveButton = new JButton(ButtonNames.SAVETEAM.getValue());
        saveButton.setPreferredSize(buttonDimension);
        formatButtonRow(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals(ButtonNames.SAVETEAM.getValue())) {
                    displayText.setText(getFantasyApp().saveMyFantasyTeam());
                }
            }
        });
        buttonsLayout.add(saveButton);
    }

    //MODIFIES - buttonsLayout
    //EFFECTS - add LOAD button to the frame
    public void addLoadButton() {
        JButton loadButton = new JButton(ButtonNames.LOADTEAM.getValue());
        loadButton.setPreferredSize(buttonDimension);
        formatButtonRow(loadButton);

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals(ButtonNames.LOADTEAM.getValue())) {
                    displayText.setText(getFantasyApp().loadMyFantasyTeam());
                }
            }
        });
        buttonsLayout.add(loadButton);
    }

    //MODIFIES - fantasyTab
    //EFFECTS - add a section of text boxes to the fantasy app
    public void displayBoxSection() {
        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        displayTextBox(textPanel);
        textPanel.add(Box.createVerticalStrut(20));
        addTextBox(textPanel);
        fantasyTab.add(textPanel);
    }

    //MODIFIES - textPanel
    //EFFECTS - add a read-only text box to display output
    public void displayTextBox(JPanel textPanel) {
        displayText = new JTextField(16);
        displayText.setEditable(false);
        displayText.setFont(textFont);
        textPanel.add(displayText);
    }

    //MODIFIES - textPanel, enterButtonsPanel
    //EFFECTS - add an editable text box with associated buttons to the frame
    public void addTextBox(JPanel textPanel) {
        JPanel enterButtonsPanel = new JPanel();
        enterButtonsPanel.setLayout(new FlowLayout());

        enterText = new JTextField(16);
        enterText.setFont(textFont);
        addTeamButton = new JButton(ButtonNames.ADDTEAM.getValue());
        addTeamButton.setPreferredSize(buttonDimension);
        addTeamButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addPlayerButton = new JButton(ButtonNames.ADD.getValue());
        addPlayerButton.setPreferredSize(buttonDimension);
        addPlayerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removePlayerButton = new JButton(ButtonNames.REMOVE.getValue());
        removePlayerButton.setPreferredSize(buttonDimension);
        removePlayerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        addTeamButtonAction();
        addPlayerButtonAction();
        removeButtonAction();

        textPanel.add(enterText);
        textPanel.add(Box.createVerticalStrut(20));

        enterButtonsPanel.add(addTeamButton);
        enterButtonsPanel.add(addPlayerButton);
        enterButtonsPanel.add(Box.createHorizontalStrut(80));
        enterButtonsPanel.add(removePlayerButton);

        textPanel.add(enterButtonsPanel);
    }

    //MODIFIES - fantasyTab
    //EFFECTS - add a Panel containing other panels to display output
    public void displayPanels() {
        displayScreen = new JPanel();
        displayScreen.setLayout(new FlowLayout());
        displayPlayers(displayScreen);
        displayScreen.add(Box.createHorizontalStrut(50));
        displayTeam(displayScreen);
        fantasyTab.add(displayScreen);
    }

    //MODIFIES - displayScreen
    //EFFECTS - add a panel to display football teams and their players
    public void displayPlayers(JPanel displayScreen) {
        players = new JTextArea(15, 20);
        players.setAlignmentX(Component.LEFT_ALIGNMENT);
        players.setEditable(false);
        players.setFont(textFont);
        displayScreen.add(players);
    }

    //MODIFIES - displayScreen
    //EFFECTS - add a panel to display your current fantasy team
    public void displayTeam(JPanel displayScreen) {
        fantasyTeam = new JTextArea(15, 20);
        fantasyTeam.setAlignmentX(Component.RIGHT_ALIGNMENT);
        fantasyTeam.setEditable(false);
        fantasyTeam.setFont(textFont);
        displayScreen.add(fantasyTeam);
    }
}
