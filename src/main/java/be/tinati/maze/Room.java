package be.tinati.maze;

public class Room {
	private int xCoordinate;
	private int yCoordinate;
	private Wall northWall;
	private Wall southWall;
	private Wall eastWall;
	private Wall westWall;
	private String object;

	public Room(int xCoordinate, int yCoordinate, Wall northWall, Wall southWall, Wall eastWall, Wall westWall,
			String object) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.northWall = northWall;
		this.southWall = southWall;
		this.eastWall = eastWall;
		this.westWall = westWall;
		this.object = object;
	}

    public Wall getEastWall() {
        return eastWall;
    }

    public Wall getSouthWall() {
        return southWall;
    }
}
