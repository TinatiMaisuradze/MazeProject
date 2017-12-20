package be.tinati.maze;

public class Room {
	private int Xcoordinate;
	private int Ycoordinate;
	private Wall northWall;
	private Wall southWall;
	private Wall eastWall;
	private Wall westWall;
	private String object;

	public Room(int Xcoordinate, int Ycoordinate, Wall northWall, Wall southWall, Wall eastWall, Wall westWall,
			String object) {
		this.Xcoordinate = Xcoordinate;
		this.Ycoordinate = Ycoordinate;
		this.northWall = northWall;
		this.southWall = southWall;
		this.eastWall = eastWall;
		this.westWall = westWall;
		this.object = object;
	}

	private boolean hasEastPassage = false;
	private boolean hasSouthPassage = false;

	public boolean getHasEastPassage() {
		return hasEastPassage;
	}

	public void addEastPassage() {
		hasEastPassage = true;
	}

	public boolean getHasSouthPassage() {
		return hasSouthPassage;
	}

	public void addSouthPassage() {
		hasSouthPassage = true;
	}

    public Wall getEastWall() {
        return eastWall;
    }
}
