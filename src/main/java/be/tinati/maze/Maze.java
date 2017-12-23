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

    public void setRoomSouthWall(int xCoordinate, int yCoordinate, Wall type) {
        room[xCoordinate][yCoordinate].setSouthWall(type);
    }

    public void setRoomNorthWall(int xCoordinate, int yCoordinate, Wall type) {
        room[xCoordinate][yCoordinate].setNorthWall(type);
    }

    public void setRoomEastWall(int xCoordinate, int yCoordinate, Wall type) {
        room[xCoordinate][yCoordinate].setEastWall(type);
    }

    public void setRoomWestWall(int xCoordinate, int yCoordinate, Wall type) {
        room[xCoordinate][yCoordinate].setWestWall(type);
    }

     public void setObject(int xCoordinate, int yCoordinate, Object type) {
       room[xCoordinate][yCoordinate].setObject(type);
    }

    /*// printing maze
    public void printMazeDoubleWalls() {

        for (int yCoordinate = 0; yCoordinate < height; yCoordinate++) {
            for (int xCoordinate = 0; xCoordinate < length; xCoordinate++) {
                System.out.print("+" + room[xCoordinate][yCoordinate].getNorthWall().getVerticalVisualisation() + "+");
            }
            System.out.println ();

            for (int xCoordinate = 0; xCoordinate < length; xCoordinate++) {
                System.out.print(room[xCoordinate][yCoordinate].getWestWall().getHorizontalVisualisation());
                System.out.print((room[xCoordinate][yCoordinate].getObject().getVisualisation()));
                System.out.print(room[xCoordinate][yCoordinate].getEastWall().getHorizontalVisualisation());
            }
            System.out.println();

            for (int xCoordinate = 0; xCoordinate < length; xCoordinate++) {
                System.out.print("+" + room[xCoordinate][yCoordinate].getSouthWall().getVerticalVisualisation() + "+");
            }
            System.out.println();
        }

    }*/
    // printing maze
    public void print() {

        for (int yCoordinate = 0; yCoordinate < height; yCoordinate++) {
            for (int xCoordinate = 0; xCoordinate < length; xCoordinate++) {
                System.out.print("+" + room[xCoordinate][yCoordinate].getNorthWall().getVerticalVisualisation());
            }
            System.out.println ();

            for (int xCoordinate = 0; xCoordinate < length; xCoordinate++) {
                System.out.print(room[xCoordinate][yCoordinate].getWestWall().getHorizontalVisualisation());
                System.out.print((room[xCoordinate][yCoordinate].getObject().getVisualisation()));
            }
            System.out.println();
        }

            }

        }


