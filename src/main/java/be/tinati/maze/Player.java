package be.tinati.maze;

public class Player {
    private String name;
    private int pX; //position X of player on the grid
    private int pY;//position Y of player on the grid
    private int nrOfTrophies = 0;
    private int nrOfKeys = 0;
    private int nrOfHammers = 0;


    // Initial position is the entry point(S) of the maze
    public Player(String name, int pX, int pY) {
        this.name = name;
        this.pX = pX;
        this.pY = pY;
    }

    public boolean playerPosition(int xCoordinate, int yCoordinate) {
        return pX == xCoordinate && pY == yCoordinate;
    }

    public int getPX() {
        return pX;
    }

    public int getPY() {
        return pY;
    }

    public String getName() {
        return name;
    }

    public void setPX(int positionX) {
        this.pX = positionX;
    }

    public void setpY(int pY) {
        this.pY = pY;
    }

    public void incNrOfTrophys() {
        nrOfTrophies++;
    }

    public void decNrOfTrhophys() {
        nrOfTrophies--;
    }

    public int getNrOfTrophys() {
        return nrOfTrophies;
    }

    public void incNrOfHammers() {
        nrOfHammers++;
    }

    public void decNrOfHammers() {
        nrOfHammers--;
    }

    public int getNrOfHammers() {
        return nrOfHammers;
    }

    public void incNrOfKeys() {
        nrOfKeys++;
    }

    public void decNrOfKeys() {
        nrOfKeys--;
    }

    public int getNrOfKeys() {
        return nrOfKeys;
    }
}