package be.tinati.maze;

public class Room {
    private Passage northWall;
    private Passage southWall;
    private Passage eastWall;
    private Passage westWall;
    private Item item;


    public void setSouthWall(Passage southWall) {
        this.southWall = southWall;
    }

    public void setEastWall(Passage eastWall) {
        this.eastWall = eastWall;
    }

    public void setNorthWall(Passage northWall) {
        this.northWall = northWall;
    }

    public void setWestWall(Passage westWall) {
        this.westWall = westWall;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Passage getSouthWall() {
        return southWall;
    }

    public Passage getEastWall() {
        return eastWall;
    }

    public Passage getNorthWall() {
        return northWall;
    }

    public Passage getWestWall() {
        return westWall;
    }

    public Item getItem() {
        return item;
    }
}
