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

    public void changePosition() {
        System.out.println("hi now you can move! with u - up, d - down, r - right, l - left ");
        Scanner scanner = new Scanner(System.in);

        switch (scanner.next()) {
            case "u":
                positionY -= 1;
                break;
            case "d":
                positionY += 1;
                break;
            case "r":
                positionX += 1;
                break;
            case "l":
                positionX -= 1;
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
