package be.tinati.maze;

public class Maze {
    private String name;
    private Room[][] room;
    private int length;
    private int height;
    private int xCoordinate;
    private int yCoordinate;

    // constructor method
    public Maze(String name, int length, int height) {
        this.length = length;
        this.height = height;
        this.name = name;

        // initialize grid of rooms
        room = new Room[length][height];
        // initializing every room, store them under grid
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                room[i][j] = new Room();
            }
        }
    }

    //set methods
    public String getName() {
        return name;
    }

    public void setRoomSouthWall(int xCoordinate, int yCoordinate, Passage type) {
        room[xCoordinate][yCoordinate].setSouthWall(type);
    }

    public void setRoomNorthWall(int xCoordinate, int yCoordinate, Passage type) {
        room[xCoordinate][yCoordinate].setNorthWall(type);
    }

    public void setRoomEastWall(int xCoordinate, int yCoordinate, Passage type) {
        room[xCoordinate][yCoordinate].setEastWall(type);
    }

    public void setRoomWestWall(int xCoordinate, int yCoordinate, Passage type) {
        room[xCoordinate][yCoordinate].setWestWall(type);
    }

    public void setObject(int xCoordinate, int yCoordinate, RoomContent type) {
        room[xCoordinate][yCoordinate].setRoomContent(type);
    }

    // printing double maze for checking input
    public void printMazeDoubleWalls() {

        for (int yCoordinate = 0; yCoordinate < height; yCoordinate++) {
            for (int xCoordinate = 0; xCoordinate < length; xCoordinate++) {
                System.out.print("+" + room[xCoordinate][yCoordinate].getNorthWall().getVerticalVisualisation() + "+");
            }
            System.out.println();

            for (int xCoordinate = 0; xCoordinate < length; xCoordinate++) {
                System.out.print(room[xCoordinate][yCoordinate].getWestWall().getHorizontalVisualisation());
                System.out.print((room[xCoordinate][yCoordinate].getRoomContent().getVisualisation()));
                System.out.print(room[xCoordinate][yCoordinate].getEastWall().getHorizontalVisualisation());
            }
            System.out.println();

            for (int xCoordinate = 0; xCoordinate < length; xCoordinate++) {
                System.out.print("+" + room[xCoordinate][yCoordinate].getSouthWall().getVerticalVisualisation() + "+");
            }
            System.out.println();
        }

    }


    // printing maze
    public void print(Player player) {


        for (int yCoordinate = 0; yCoordinate < height; yCoordinate++) {
            for (int xCoordinate = 0; xCoordinate < length; xCoordinate++) {
                System.out.print("#" + room[xCoordinate][yCoordinate].getNorthWall().getVerticalVisualisation());

            }

            System.out.println("#");


            for (int xCoordinate = 0; xCoordinate < length; xCoordinate++) {
                System.out.print(room[xCoordinate][yCoordinate].getWestWall().getHorizontalVisualisation());
                if (player.playerPosition(xCoordinate, yCoordinate)) {
                    System.out.print(" X ");
                } else {
                    System.out.print((room[xCoordinate][yCoordinate].getRoomContent().getVisualisation()));
                }

            }
            System.out.print(room[height - 1][yCoordinate].getWestWall().getHorizontalVisualisation());
            System.out.println();

        }

        for (int xCoordinate = 0; xCoordinate < length; xCoordinate++) {
            System.out.print("#" + room[xCoordinate][height - 1].getSouthWall().getVerticalVisualisation());
        }
        System.out.print("#");
        System.out.println();
        System.out.println();
    }

    public boolean checkForEnd(Player player) {
        Room room = this.room[player.getPositionX()][player.getPositionY()];
        return room.getRoomContent() == RoomContent.END;
    }

    public void accessChangePosition(Player player) {

        Room room1 = this.room[player.getPositionX()][player.getPositionY()];
        player.changePosition(room1);
    }



}


