package be.tinati.maze;

public enum RoomContent {
    START(" S "),
    END(" E "),
    NO("   "),
    KEY(" K "),
    HAMMER(" H "),
    TROPHY(" T ");

    private String Visualisation;


    RoomContent(String Visualisation) {
        this.Visualisation = Visualisation;

    }

    public String getVisualisation() {
        return Visualisation;
    }

    public void setVisualisation(String visualisation) {
        Visualisation = visualisation;
    }
}

