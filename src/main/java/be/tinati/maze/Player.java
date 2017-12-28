package be.tinati.maze;

import java.util.Scanner;

public class Player {
    private String name;
    private int positionX;
    private int positionY;
    private int stepCounter = 0;

    // Initial position is the entry point(S) of the maze
    public Player(String name, int positionX, int positionY) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;

    }

    public boolean playerPosition(int xCoordinate, int yCoordinate) {

        return positionX == xCoordinate && positionY == yCoordinate;
    }

    private void moveThroughPassage(Passage wall) {
        if (wall != Passage.WALL)
            positionY -= 1;
    }

    public void changePosition(Room room1) {
        System.out.println("hi now you can move! with u - up, d - down, r - right, l - left ");
        Scanner scanner = new Scanner(System.in);

        switch (scanner.next()) {
            case "u":
                moveThroughPassage(room1.getNorthWall());
                break;
            case "d":
                moveThroughPassage(room1.getSouthWall());
                break;
            case "r":
                moveThroughPassage(room1.getEastWall());
                break;
            case "l":
                moveThroughPassage(room1.getWestWall());
                break;
            default:
                System.out.println("Please only use, U, D, R, L ");
        }
        stepCounter = stepCounter + 1;

    }

    public int getStepCounter() {
        return stepCounter;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public String getName() {
        return name;
    }


}
