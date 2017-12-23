package be.tinati.maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Game {

// main method, connects to input with bufferedreader, specifies maze dimensions, specifies
// how to read input (separate by comma) and which value is defined why which path of input
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(new File("out/production/resources/MidiMaze.txt"));
        BufferedReader reader = new BufferedReader(fileReader);
        System.out.println(reader.readLine());

        Maze mymaze = new Maze(5, 5);

        String inputLine = reader.readLine();
        while (inputLine != null) {
            String[] roomDetails = inputLine.split(",");

            int xCoordinate = Integer.parseInt(roomDetails[0]);
            int yCoordinate = Integer.parseInt(roomDetails[1]);
            Wall northWall = Wall.valueOf(roomDetails[2].toUpperCase());
            Wall southWall = Wall.valueOf(roomDetails[3].toUpperCase());
            Wall westWall = Wall.valueOf(roomDetails[4].toUpperCase());
            Wall eastWall = Wall.valueOf(roomDetails[5].toUpperCase());
            Object object = Object.valueOf(roomDetails[6].toUpperCase());


            mymaze.setRoomSouthWall(xCoordinate, yCoordinate, southWall);
            mymaze.setRoomEastWall(xCoordinate, yCoordinate, eastWall);
            mymaze.setRoomNorthWall(xCoordinate, yCoordinate, northWall);
            mymaze.setRoomWestWall(xCoordinate, yCoordinate, westWall);
            mymaze.setObject(xCoordinate, yCoordinate, object);
            inputLine = reader.readLine();
        }

        mymaze.print();
    }
}
