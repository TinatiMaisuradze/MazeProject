package be.tinati.maze;

public class Maze {
	private Room[][] room;
	private int length;
	private int height;
	
	// constructor method
	public Maze(int length, int height) {
		this.length = length;
		this.height = height;

		// initialize grid of rooms
		room = new Room[length][height];
		// initializing every room, store them under grid
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < height; j++) {
				room[i][j] = new Room(j, j, Wall.NORMAL, Wall.NORMAL, Wall.NORMAL, Wall.NORMAL, null);
			}
		}
	}
	
	// works with class maze adding passage method
	public void addEastPassage(int x, int y) {
		// works with class room
		room[x][y].addEastPassage();
	}

	public void addSouthPassage(int x, int y) {
		room[x][y].addSouthPassage();
	}

	// printing maze
	public void print() {
		System.out.print("+");
		for (int i = 0; i < length; i++) {
			System.out.print("---+");
		}
		System.out.println();

		for (int j = 0; j < height; j++) {
			System.out.print("|");
			for (int i = 0; i < length; i++) {
				System.out.print("   " + room[i][j].getEastWall().getHorizontalVisualisation());
//				if (room[i][j].getHasEastPassage()) {
//					System.out.print("    ");
//				} else {
//					System.out.print("   |");
//				}
			}
			System.out.println();

			System.out.print("+");
			for (int i = 0; i < length; i++) {
				if (room[i][j].getHasSouthPassage()) {
					System.out.print("    ");
				} else {
					System.out.print("---+");
				}
			}
			System.out.println();
		}
	}
}
