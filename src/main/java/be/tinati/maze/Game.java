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

        Maze mymaze = new Maze("Maze1", 5, 5);

        Player player = new Player("Tinati", 0, 0);

        String inputLine = reader.readLine();
        while (inputLine != null) {
            String[] roomDetails = inputLine.split(",");

            int xCoordinate = Integer.parseInt(roomDetails[0]);
            int yCoordinate = Integer.parseInt(roomDetails[1]);
            Passage northWall = Passage.valueOf(roomDetails[2].toUpperCase());
            Passage southWall = Passage.valueOf(roomDetails[3].toUpperCase());
            Passage westWall = Passage.valueOf(roomDetails[4].toUpperCase());
            Passage eastWall = Passage.valueOf(roomDetails[5].toUpperCase());
            Item item = Item.valueOf(roomDetails[6].toUpperCase());


            mymaze.setRoomSouthWall(xCoordinate, yCoordinate, southWall);
            mymaze.setRoomEastWall(xCoordinate, yCoordinate, eastWall);
            mymaze.setRoomNorthWall(xCoordinate, yCoordinate, northWall);
            mymaze.setRoomWestWall(xCoordinate, yCoordinate, westWall);
            mymaze.setObject(xCoordinate, yCoordinate, item);
            inputLine = reader.readLine();
        }


        mymaze.print(player);

        while (!mymaze.checkForEnd(player)) {
            mymaze.changePosition(player);
            mymaze.pickUpObject(player);
            mymaze.print(player);
        }
        System.out.println("PlayerName - " + player.getName() + " | " + "MazeName - " + mymaze.getName()
                + " | " + "NrOfSteps  - " + mymaze.getStepCounter());
    }
}