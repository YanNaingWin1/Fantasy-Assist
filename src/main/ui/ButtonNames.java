package ui;

//EFFECTS - an enum for all the button names available.
public enum ButtonNames {
    FANTASYTEAM("Pick Team"),
    TEAMS("View Teams"),
    ADDPLAYER("Add Player"),
    REMOVEPLAYER("Remove Player"),
    VIEWTEAM("View My Fantasy Team"),
    SUBMIT("Submit"),
    CHECKBALANCE("Check Balance"),
    SAVETEAM("Save"),
    LOADTEAM("Load"),
    ADDTEAM("Enter (Football Team)"),
    ADD("Enter (Player)"),
    REMOVE("Remove");

    private final String name;

    ButtonNames(String name) {
        this.name = name;
    }

    //EFFECTS: returns name value of this button
    public String getValue() {
        return name;
    }
}
