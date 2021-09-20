package ui.tabs;

import ui.FantasyApp;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//EFFECTS - A class for an instruction tab of the program
public class InstructionTab extends Tab {

    private JPanel instructions;
    private JPanel addPlayersInstructions;
    private JPanel removePlayersInstructions;

    private JScrollPane sp;

    private Font textFont = new Font("Arial", Font.PLAIN, 18);

    //EFFECTS - a constructor to create an instruction tab
    public InstructionTab(FantasyApp fantasyApp) {
        super(fantasyApp);
        instructions = new JPanel();
        instructions.setLayout(new BoxLayout(instructions, BoxLayout.Y_AXIS));
        addingPlayers(instructions);
        removingPlayers(instructions);
        try {
            addRest4(instructions);
        } catch (IOException e) {
            System.out.println("Error - Picture not found!");
        }
        sp = new JScrollPane(instructions);
        sp.setPreferredSize(new Dimension(800, 600));
        this.add(sp);
    }

    //MODIFIES - instructions
    //EFFECTS - add all the instructions to add a player to the team
    public void addingPlayers(JPanel instructions) {
        addPlayersInstructions = new JPanel();
        addPlayersInstructions.setLayout(new BoxLayout(addPlayersInstructions, BoxLayout.Y_AXIS));

        try {
            addPlayerPart1(addPlayersInstructions);
            addPlayerPart2(addPlayersInstructions);
            addPlayerPart3(addPlayersInstructions);
        } catch (IOException e) {
            System.out.println("Error - Picture not found!");
        }
        instructions.add(addPlayersInstructions);
    }

    //MODIFIES - addPlayersInstructions
    //EFFECTS - a helper function to add a player to the team
    private void addPlayerPart1(JPanel addPlayersInstructions) throws IOException {
        JLabel addPlayer1 = new JLabel();
        JLabel addPlayer2 = new JLabel();
        addPlayer1.setFont(textFont);
        addPlayer2.setFont(textFont);
        addPlayer1.setText("1) Adding Players");
        addPlayer2.setText("To add a player to your fantasy team, press Add Player as shown below\n");

        BufferedImage myPicture = ImageIO.read(new File("./data/Add.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        addPlayersInstructions.add(addPlayer1, Component.CENTER_ALIGNMENT);
        addPlayersInstructions.add(addPlayer2, Component.CENTER_ALIGNMENT);
        addPlayersInstructions.add(picLabel);
    }

    //MODIFIES - addPlayersInstructions
    //EFFECTS - a helper function to add a player to the team
    private void addPlayerPart2(JPanel addPlayersInstructions) throws IOException {
        JLabel addPlayer3 = new JLabel();
        addPlayer3.setFont(textFont);
        addPlayer3.setText("Then, select a team of your choice by typing in a team and press Enter (Football Team)");

        BufferedImage myPicture = ImageIO.read(new File("./data/EnterTeam.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        addPlayersInstructions.add(addPlayer3, Component.CENTER_ALIGNMENT);
        addPlayersInstructions.add(picLabel);
    }

    //MODIFIES - addPlayersInstructions
    //EFFECTS - a helper function to add a player to the team
    private void addPlayerPart3(JPanel addPlayersInstructions) throws IOException {
        JLabel addPlayer3 = new JLabel();
        addPlayer3.setFont(textFont);
        addPlayer3.setText("Finally, type in a player's name to add the player to your team by pressing "
                + "Enter (Player)");

        BufferedImage myPicture = ImageIO.read(new File("./data/EnterPlayer.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        addPlayersInstructions.add(addPlayer3, Component.CENTER_ALIGNMENT);
        addPlayersInstructions.add(picLabel);
    }

    //MODIFIES - addPlayersInstructions
    //EFFECTS - add all the instructions to remove a player to the team
    public void removingPlayers(JPanel instructions) {
        removePlayersInstructions = new JPanel();
        removePlayersInstructions.setLayout(new BoxLayout(addPlayersInstructions, BoxLayout.Y_AXIS));

        try {
            removePlayerPart1(addPlayersInstructions);
            removePlayerPart2(addPlayersInstructions);
        } catch (IOException e) {
            System.out.println("Error - Picture not found!");
        }
        instructions.add(addPlayersInstructions);
    }

    //MODIFIES - addPlayersInstructions
    //EFFECTS - a helper function to remove a player to the team
    private void removePlayerPart1(JPanel addPlayersInstructions) throws IOException {
        JLabel removePlayer1 = new JLabel();
        JLabel removePlayer2 = new JLabel();
        removePlayer1.setFont(textFont);
        removePlayer2.setFont(textFont);
        removePlayer1.setText("2) Remove Players");
        removePlayer2.setText("To remove the player from your fantasy team, press Remove Player as shown below\n");

        BufferedImage myPicture = ImageIO.read(new File("./data/RemovePlayer.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        addPlayersInstructions.add(removePlayer1, Component.CENTER_ALIGNMENT);
        addPlayersInstructions.add(removePlayer2, Component.CENTER_ALIGNMENT);
        addPlayersInstructions.add(picLabel);
    }

    //MODIFIES - addPlayersInstructions
    //EFFECTS - a helper function to remove a player to the team
    private void removePlayerPart2(JPanel addPlayersInstructions) throws IOException {
        JLabel removePlayer3 = new JLabel();
        removePlayer3.setFont(textFont);
        removePlayer3.setText("Next, type in the player's name and then press Remove button as shown below\n");

        BufferedImage myPicture = ImageIO.read(new File("./data/Remove.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        addPlayersInstructions.add(removePlayer3, Component.CENTER_ALIGNMENT);
        addPlayersInstructions.add(picLabel);
    }

    //MODIFIES - addPlayersInstructions
    //EFFECTS - add instructions for the rest of the buttons
    public void addRest4(JPanel addPlayersInstructions) throws IOException {
        JLabel rest1 = new JLabel();
        JLabel rest2 = new JLabel();
        JLabel rest3 = new JLabel();
        JLabel rest4 = new JLabel();
        JLabel rest5 = new JLabel();
        rest1.setFont(textFont);
        rest2.setFont(textFont);
        rest3.setFont(textFont);
        rest4.setFont(textFont);
        rest5.setFont(textFont);
        rest5.setText("3) Other options - ");
        rest1.setText("View My Fantasy Team - Press to view your current fantasy team squad");
        rest2.setText("Check Balance - Press to view the remaining balance of your fantasy team");
        rest3.setText("Save - Press to save your current fantasy team");
        rest4.setText("Load - Press to load your last saved fantasy team");

        BufferedImage myPicture = ImageIO.read(new File("./data/Rest4.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        addPlayersInstructions.add(rest5, Component.CENTER_ALIGNMENT);
        addPlayersInstructions.add(rest1, Component.CENTER_ALIGNMENT);
        addPlayersInstructions.add(rest2, Component.CENTER_ALIGNMENT);
        addPlayersInstructions.add(rest3, Component.CENTER_ALIGNMENT);
        addPlayersInstructions.add(rest4, Component.CENTER_ALIGNMENT);
        addPlayersInstructions.add(picLabel);
    }


}
