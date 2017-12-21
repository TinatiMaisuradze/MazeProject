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
                room[i][j] = new Room(Wall.WALL, Wall.WALL, Wall.WALL, Wall.WALL, Object.NO);
            }
        }
    }

    //set methods

    public void setRoomSouthWall(int i, int j, Wall type) {
        room[i][j].setSouthWall(type);
    }

    public void setRoomNorthWall(int i, int j, Wall type) {
        room[i][j].setNorthWall(type);
    }

    public void setRoomEastWall(int i, int j, Wall type) {
        room[i][j].setEastWall(type);
    }

    public void setRoomWestWall(int i, int j, Wall type) {
        room[i][j].setWestWall(type);
    }

     public void setObject(int i, int j, Object type) {
       room[i][j].setObject(type);
    }

    // printing maze
    public void print() {
        System.out.print("+");
        for (int i = 0; i < length; i++) {
            System.out.print("---+");
        }
        System.out.println ();

        for (int j = 0; j < height; j++) {
            System.out.print("|");
            for (int i = 0; i < length; i++) {
                System.out.print((room[i][j].getObject().getVisualisation()) + room[i][j].getEastWall().getHorizontalVisualisation());
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
