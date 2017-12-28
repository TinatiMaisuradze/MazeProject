package be.tinati.maze;

public class Room {
	private Passage northWall;
	private Passage southWall;
	private Passage eastWall;
	private Passage westWall;
	private RoomContent roomContent;


    public void setSouthWall(Passage southWall) {
        this.southWall = southWall;
    }

    public Passage getSouthWall() {
        return southWall;
    }

    public void setEastWall(Passage eastWall) {
        this.eastWall = eastWall;
    }

    public Passage getEastWall() {
        return eastWall;
    }

    public void setNorthWall(Passage northWall) {
        this.northWall = northWall;
    }
    public Passage getNorthWall() {
        return northWall;
    }

    public void setWestWall(Passage westWall) {
        this.westWall = westWall;
    }
    public Passage getWestWall() {
        return westWall;
    }


    public RoomContent getRoomContent() {
        return roomContent;
    }

    public void setRoomContent(RoomContent roomContent) {
        this.roomContent = roomContent;
    }
}
