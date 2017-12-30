package be.tinati.maze;

public enum Passage {
    WALL("#", "###"),
    NO(" ", "   "),
    OPENDOOR("/", "///"),
    DOOR ("|" , "---"),
    BREAKABLE("B", "-B-"),
    FAKE("#", "###"),
    BROKENWALL (">", ">>>");

    private String horizontalVisualisation;
    private String verticalVisualisation;

    Passage(String horizontalVisualisation, String verticalVisualisation) {
        this.horizontalVisualisation = horizontalVisualisation;
        this.verticalVisualisation = verticalVisualisation;
    }

    public String getVerticalVisualisation() {
        return verticalVisualisation;
    }

    public String getHorizontalVisualisation() {
        return horizontalVisualisation;
    }
}
