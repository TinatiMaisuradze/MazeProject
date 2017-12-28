package be.tinati.maze;

public class Room {
	private Wall northWall;
	private Wall southWall;
	private Wall eastWall;
	private Wall westWall;
	private RoomContent roomContent;


	public Room(Wall northWall, Wall southWall, Wall eastWall, Wall westWall, RoomContent roomContent) {
		this.northWall = northWall;
		this.southWall = southWall;
		this.eastWall = eastWall;
		this.westWall = westWall;
		this.roomContent = roomContent;

	}

    public void setSouthWall(Wall southWall) {
        this.southWall = southWall;
    }

    public Wall getSouthWall() {
        return southWall;
    }

    public void setEastWall(Wall eastWall) {
        this.eastWall = eastWall;
    }

    public Wall getEastWall() {
        return eastWall;
    }

    public void setNorthWall(Wall northWall) {
        this.northWall = northWall;
    }
    public Wall getNorthWall() {
        return northWall;
    }

    public void setWestWall(Wall westWall) {
        this.westWall = westWall;
    }
    public Wall getWestWall() {
        return westWall;
    }


    public RoomContent getRoomContent() {
        return roomContent;
    }

    public void setRoomContent(RoomContent roomContent) {
        this.roomContent = roomContent;
    }
}
