package be.tinati.maze;

import java.util.Scanner;

public class Maze {
    private String name;
    private Room[][] room;
    private int length;
    private int height;
    private int xCoordinate;
    private int yCoordinate;
    private int stepCounter = 0;
    private Scanner scanner = new Scanner(System.in);

    public int getStepCounter() {
        return stepCounter;
    }

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

    public void setObject(int xCoordinate, int yCoordinate, Item type) {
        room[xCoordinate][yCoordinate].setItem(type);
    }

    // printing double maze for checking input
    public void printMazeDoubleWalls(Player player) {

        for (int yCoordinate = 0; yCoordinate < height; yCoordinate++) {
            for (int xCoordinate = 0; xCoordinate < length; xCoordinate++) {
                System.out.print("+" + room[xCoordinate][yCoordinate].getNorthWall().getVerticalVisualisation() + "+");
            }
            System.out.println();

            for (int xCoordinate = 0; xCoordinate < length; xCoordinate++) {
                System.out.print(room[xCoordinate][yCoordinate].getWestWall().getHorizontalVisualisation());


                if (player.playerPosition(xCoordinate, yCoordinate)) {
                    System.out.print(" X ");
                } else System.out.print((room[xCoordinate][yCoordinate].getItem().getVisualisation()));
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
        System.out.println(getStepCounter() + " " + "steps taken");
        System.out.println("Player backpack includes - " + " " + player.getNrOfKeys() + " " + "Keys" + " | " + player.getNrOfHammers()
                + " " + "Hammers" + " | " + player.getNrOfTrophys() + " " + "Throphys");


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
                    System.out.print((room[xCoordinate][yCoordinate].getItem().getVisualisation()));
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

    // change position; for each wall, also same wall of the other room since they are doubled up
    public void changePosition(Player player) {
        Room room = this.room[player.getPositionX()][player.getPositionY()];
        System.out.println("hi now you can move! with u - up, d - down, r - right, l - left ");
        switch (scanner.next()) {
            case "u":
                Room room1 = this.room[player.getPositionX()][player.getPositionY() - 1];
                if (room.getNorthWall() == Passage.BREAKABLE) {
                    if (player.getNrOfHammers() > 0) {
                        room.setNorthWall(Passage.BROKENWALL);
                        room1.setSouthWall(Passage.BROKENWALL);
                        player.decNrOfHammers();

                    }
                } else if (room.getNorthWall() == Passage.DOOR) {
                    if (player.getNrOfKeys() > 0) {
                        room.setNorthWall(Passage.OPENDOOR);
                        room1.setSouthWall(Passage.OPENDOOR);
                        player.decNrOfKeys();
                    }
                } else if (room.getNorthWall() == Passage.WALL) {
                    if (player.getNrOfTrophys() > 0) {
                        player.decNrOfTrhophys();
                        player.setPositionY(player.getPositionY() - 1);
                    }
                } else if (room.getNorthWall() != Passage.WALL) {
                    player.setPositionY(player.getPositionY() - 1);
                }
                break;
            case "d":
                Room room2 = this.room[player.getPositionX()][player.getPositionY() + 1];
                if (room.getSouthWall() == Passage.BREAKABLE) {
                    if (player.getNrOfHammers() > 0) {
                        room.setSouthWall(Passage.BROKENWALL);
                        room2.setNorthWall(Passage.BROKENWALL);

                        player.decNrOfHammers();
                    }
                } else if (room.getSouthWall() == Passage.DOOR) {
                    if (player.getNrOfKeys() > 0) {
                        room.setSouthWall(Passage.OPENDOOR);
                        room2.setNorthWall(Passage.OPENDOOR);
                        player.decNrOfKeys();
                    }
                } else if (room.getSouthWall() == Passage.WALL) {
                    if (player.getNrOfTrophys() > 0) {
                        player.decNrOfTrhophys();
                        player.setPositionY(player.getPositionY() + 1);
                    }
                } else if (room.getSouthWall() != Passage.WALL) {
                    player.setPositionY(player.getPositionY() + 1);
                }
                break;
            case "r":
                Room room3 = this.room[player.getPositionX() + 1][player.getPositionY()];
                if (room.getEastWall() == Passage.BREAKABLE) {
                    if (player.getNrOfHammers() > 0) {
                        room.setEastWall(Passage.BROKENWALL);
                        room3.setWestWall(Passage.BROKENWALL);
                        player.decNrOfHammers();
                    }
                } else if (room.getEastWall() == Passage.DOOR) {
                    if (player.getNrOfKeys() > 0) {
                        room.setEastWall(Passage.OPENDOOR);
                        room3.setWestWall(Passage.OPENDOOR);
                        player.decNrOfKeys();
                    }
                } else if (room.getEastWall() == Passage.WALL) {
                    if (player.getNrOfTrophys() > 0) {
                        player.decNrOfTrhophys();
                        player.setPositionX(player.getPositionX() + 1);
                    }
                } else if (room.getEastWall() != Passage.WALL) {
                    player.setPositionX(player.getPositionX() + 1);
                }
                break;
            case "l":
                Room room4 = this.room[player.getPositionX() - 1][player.getPositionY()];
                if (room.getWestWall() == Passage.BREAKABLE) {
                    if (player.getNrOfHammers() > 0) {
                        room.setWestWall(Passage.BROKENWALL);
                        room4.setEastWall(Passage.BROKENWALL);
                        player.decNrOfHammers();
                    }
                } else if (room.getWestWall() == Passage.DOOR) {
                    if (player.getNrOfKeys() > 0) {
                        room.setWestWall(Passage.OPENDOOR);
                        room4.setEastWall(Passage.OPENDOOR);
                        player.decNrOfKeys();
                    }
                } else if (room.getWestWall() == Passage.WALL) {
                    if (player.getNrOfTrophys() > 0) {
                        player.decNrOfTrhophys();
                        player.setPositionX(player.getPositionX() - 1);
                    }
                } else if (room.getWestWall() != Passage.WALL) {
                    player.setPositionX(player.getPositionX() - 1);
                }
                break;
            default:
                System.out.println();
        }
        stepCounter = stepCounter + 1;
    }

    public void pickUpObject(Player player) {
        Room room = this.room[player.getPositionX()][player.getPositionY()];
        if (room.getItem() == Item.KEY) {
            player.incNrOfKeys();
            room.setItem(Item.NO);
        } else if (room.getItem() == Item.HAMMER) {
            player.incNrOfHammers();
            room.setItem(Item.NO);
        } else if (room.getItem() == Item.TROPHY) {
            player.incNrOfTrophys();
            room.setItem(Item.NO);
        }

    }

    public boolean checkForEnd(Player player) {
        Room room = this.room[player.getPositionX()][player.getPositionY()];
        return room.getItem() == Item.END;
    }


}
