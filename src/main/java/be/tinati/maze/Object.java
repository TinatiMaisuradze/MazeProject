package be.tinati.maze;

public enum Object {
    START(" S "),
    FINISH(" E )"),
    NO("   "),
    KEY(" K "),
    HAMMER(" H ");

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

