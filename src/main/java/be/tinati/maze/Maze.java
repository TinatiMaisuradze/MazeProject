package be.tinati.maze;

import java.util.Scanner;

public class Maze {
    private String name;
    private Room[][] room;
    private int length;
    private int height;
    
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

    public void setItem(int xCoordinate, int yCoordinate, Item type) {
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
                + " " + "Hammers" + " | " + player.getNrOfTrophys() + " " + "Throphies");


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

    public void changePassageNorthOf(int x, int y, Passage newPassage) {
        room[x][y].setNorthWall(newPassage);
        room[x][y - 1].setSouthWall(newPassage);
    }

    public void changePassageEastOf(int x, int y, Passage newPassage) {
        room[x][y].setEastWall(newPassage);
        room[x + 1][y].setWestWall(newPassage);
    }

    // change position; for each wall, also same wall of the other room since they are doubled up
    public void changePosition(Player player) {
        Room room = this.room[player.getPX()][player.getPY()];
        System.out.println("hi now you can move! with u - up, d - down, r - right, l - left ");
        switch (scanner.next()) {
            case "u":
                if (room.getNorthWall() == Passage.BREAKABLE) {
                    if (player.getNrOfHammers() > 0) {
                        changePassageNorthOf(player.getPX(), player.getPY(), Passage.BROKENWALL);
                        player.decNrOfHammers();

                    }
                } else if (room.getNorthWall() == Passage.DOOR) {
                    if (player.getNrOfKeys() > 0) {
                        changePassageNorthOf(player.getPX(), player.getPY(), Passage.OPENDOOR);
                        player.decNrOfKeys();
                    }
                } else if (room.getNorthWall() == Passage.WALL) {
                    if (player.getNrOfTrophys() > 0) {
                        System.out.println("Do you want to use one Trophy to pass through this wall? Please answer yes or no.");
                        if (scanner.next() == "yes") {
                            player.decNrOfTrhophys();
                            player.setpY(player.getPY() - 1);
                        } else if (scanner.next() == "no") {
                            System.out.println("Please choose another direction.");
                        }
                    }
                } else {
                    player.setpY(player.getPY() - 1);
                }
                break;
            case "d":
                if (room.getSouthWall() == Passage.BREAKABLE) {
                    if (player.getNrOfHammers() > 0) {
                        changePassageNorthOf(player.getPX(), player.getPY() + 1, Passage.BROKENWALL);
                        player.decNrOfHammers();
                    }
                } else if (room.getSouthWall() == Passage.DOOR) {
                    if (player.getNrOfKeys() > 0) {
                        changePassageNorthOf(player.getPX(), player.getPY() + 1, Passage.OPENDOOR);
                        player.decNrOfKeys();
                    }
                } else if (room.getSouthWall() == Passage.WALL) {
                    if (player.getNrOfTrophys() > 0) {
                        System.out.println("Do you want to use one Trophy to pass through this wall? Please answer yes or no.");
                        if (scanner.next() == "yes") {
                            player.decNrOfTrhophys();
                            player.setpY(player.getPY() - 1);
                        } else if (scanner.next() == "no") {
                            System.out.println("Please choose another direction.");
                        }
                    }
                } else {
                    player.setpY(player.getPY() + 1);
                }
                break;
            case "r":
                if (room.getEastWall() == Passage.BREAKABLE) {
                    if (player.getNrOfHammers() > 0) {
                        changePassageEastOf(player.getPX(), player.getPY(), Passage.BROKENWALL);
                        player.decNrOfHammers();
                    }
                } else if (room.getEastWall() == Passage.DOOR) {
                    if (player.getNrOfKeys() > 0) {
                        changePassageEastOf(player.getPX(), player.getPY(), Passage.OPENDOOR);
                        player.decNrOfKeys();
                    }
                } else if (room.getEastWall() == Passage.WALL) {
                    if (player.getNrOfTrophys() > 0) {
                        System.out.println("Do you want to use one Trophy to pass through this wall? Please answer yes or no.");
                        if (scanner.next() == "yes") {
                            player.decNrOfTrhophys();
                            player.setpY(player.getPY() - 1);
                        } else if (scanner.next() == "no") {
                            System.out.println("Please choose another direction.");
                        }
                    }
                } else {
                    player.setPX(player.getPX() + 1);
                }
                break;
            case "l":
                if (room.getWestWall() == Passage.BREAKABLE) {
                    if (player.getNrOfHammers() > 0) {
                        changePassageEastOf(player.getPX() - 1, player.getPY(), Passage.BROKENWALL);
                        player.decNrOfHammers();
                    }
                } else if (room.getWestWall() == Passage.DOOR) {
                    if (player.getNrOfKeys() > 0) {
                        changePassageEastOf(player.getPX() - 1, player.getPY(), Passage.OPENDOOR);
                        player.decNrOfKeys();
                    }
                } else if (room.getWestWall() == Passage.WALL) {
                    if (player.getNrOfTrophys() > 0) {
                        System.out.println("Do you want to use one Trophy to pass through this wall? Please answer yes or no.");
                        if (scanner.next() == "yes") {
                            player.decNrOfTrhophys();
                            player.setpY(player.getPY() - 1);
                        } else if (scanner.next() == "no") {
                            System.out.println("Please choose another direction.");
                        }
                    }
                } else {
                    player.setPX(player.getPX() - 1);
                }
                break;
            default:
                System.out.println();
        }
        stepCounter = stepCounter + 1;
    }

    public void pickUpObject(Player player) {
        Room room = this.room[player.getPX()][player.getPY()];
        if (room.getItem() instanceof Key) {
            player.incNrOfKeys();
            room.setItem(new NoItem());
        } else if (room.getItem() instanceof Hammer) {
            player.incNrOfHammers();
            room.setItem(new NoItem());
        } else if (room.getItem() instanceof Trophy) {
            player.incNrOfTrophys();
            room.setItem(new NoItem());
        }
    }

    public boolean checkForEnd(Player player) {
        Room room = this.room[player.getPX()][player.getPY()];
        return room.getItem() instanceof NoItem;
    }
}
