package be.tinati.maze;

import java.util.Scanner;

public class Player {
    private String name;
    private int positionX;
    private int positionY;
    private int nrOfKeys = 0;
    private int nrOfHammers = 0;
    private int nrOfTrophys = 0;


    // Initial position is the entry point(S) of the maze
    public Player(String name, int positionX, int positionY) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void incNrOfKeys() {
        nrOfKeys++;
    }

    public void incNrOfHammers() {
        nrOfHammers++;
    }

    public void incNrOfTrophys() {
        nrOfTrophys++;
    }

    public void decNrOfKeys() {
        nrOfKeys--;
    }

    public void decNrOfHammers() {
        nrOfHammers--;
    }
    public void decNrOfTrhophys(){
        nrOfTrophys--;
    }

    public boolean playerPosition(int xCoordinate, int yCoordinate) {

        return positionX == xCoordinate && positionY == yCoordinate;
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

    public int getNrOfKeys() {
        return nrOfKeys;
    }

    public int getNrOfHammers() {
        return nrOfHammers;
    }

    public int getNrOfTrophys() {
        return nrOfTrophys;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }


}