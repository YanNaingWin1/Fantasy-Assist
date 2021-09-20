package ui.tabs;

import ui.FantasyApp;

import javax.swing.*;
import java.awt.*;

//EFFECTS - an abstract class for all the tabs in the program
public abstract class Tab extends JPanel {

    private final FantasyApp fantasyApp;

    //EFFECTS - a constructor to initialise a tab
    public Tab(FantasyApp fantasyApp) {
        this.fantasyApp = fantasyApp;
    }

    //EFFECTS: creates and returns row with button included
    public JPanel formatButtonRow(JButton b) {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(b);
        return p;
    }

    //EFFECTS: returns the fantasy app for this tab
    public FantasyApp getFantasyApp() {
        return fantasyApp;
    }


}
