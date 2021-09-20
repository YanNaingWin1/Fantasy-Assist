package ui.tabs;

import ui.ButtonNames;
import ui.FantasyApp;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//EFFECTS - A class for a home tab of the program
public class HomeTab extends Tab {

    private static final String INIT_GREETING = "FantasyPL Assist - Taking your FPL experience to the next level  ";

    //EFFECTS - constructor to create a home tab
    public HomeTab(FantasyApp fantasyApp) {
        super(fantasyApp);
        setBackground(Color.CYAN);
        placeGreeting();
        addFantasyButton();
        addTeamsButton();
        try {
            displayHomePic();
        } catch (IOException e) {
            System.out.println("Picture invalid!");
        }
    }

    //EFFECTS: creates welcome message at top of console
    private void placeGreeting() {
        JLabel greeting = new JLabel(INIT_GREETING, JLabel.CENTER);
        greeting.setFont(new Font("Arial", Font.ITALIC, 30));
        greeting.setSize(50, 100 / 3);
        this.add(greeting);
    }

    //MODIFIES - this
    //EFFECTS - adds a button to manage your fantasy team
    private void addFantasyButton() {
        JButton fantasyButton = new JButton(ButtonNames.FANTASYTEAM.getValue());
        fantasyButton.setPreferredSize(new Dimension(150,30));
        fantasyButton.setBackground(Color.white);

        JPanel buttonRow = formatButtonRow(fantasyButton);

        fantasyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals(ButtonNames.FANTASYTEAM.getValue())) {
                    getFantasyApp().getTabbedPane().setSelectedIndex(FantasyApp.FANTASY_TAB_INDEX);
                    try {
                        playSound();
                    } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                        System.out.println("Audio File Not Supported");
                    } catch (IOException ioException) {
                        System.out.println("Exception thrown for Input Output!");
                    } catch (LineUnavailableException lineUnavailableException) {
                        System.out.println("Exception thrown!");
                    }
                }
            }
        });
        this.add(fantasyButton);
    }

    //MODIFIES - this
    //EFFECTS - adds a button to view the stats of available football teams
    private void addTeamsButton() {
        JButton teamsButton = new JButton(ButtonNames.TEAMS.getValue());
        teamsButton.setPreferredSize(new Dimension(150,30));
        teamsButton.setBackground(Color.yellow);

        teamsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals(ButtonNames.TEAMS.getValue())) {
                    getFantasyApp().getTabbedPane().setSelectedIndex(FantasyApp.TEAMS_TAB_INDEX);
                }
            }
        });

        this.add(teamsButton);
    }

    //MODIFIES - this
    //EFFECTS - play music when the method is called
    //credit to - https://www.codejava.net/coding/how-to-play-back-audio-in-java-with-examples
    public void playSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File audioFile = new File("./data/IntroPlTheme.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        Clip audioClip = (Clip) AudioSystem.getLine(info);
        audioClip.open(audioStream);
        audioClip.start();
    }

    //MODIFIES - this
    //EFFECTS - display picture when the method is called
    public void displayHomePic() throws IOException {
        BufferedImage playersImage = ImageIO.read(new File("./data/HomePic.png"));
        JLabel playerLabel = new JLabel(new ImageIcon(playersImage));
        add(playerLabel);
    }
}
