package be.tinati.maze;

public enum Object {
    START(" S "),
    END (" E "),
    NO("   "),
    KEY(" K "),
    HAMMER(" H "),
    TROPHY (" T ");

    private String Visualisation;


   Object (String Visualisation) {
        this.Visualisation = Visualisation;

    }

    public String getVisualisation() {
        return Visualisation;
    }

    public void setVisualisation(String visualisation) {
        Visualisation = visualisation;
    }
}

