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
			}
			System.out.println();

			System.out.print("+");
			for (int i = 0; i < length; i++) {
                System.out.print(room[i][j].getSouthWall().getVerticalVisualisation() + "+");
			}
			System.out.println();
		}
	}
}
