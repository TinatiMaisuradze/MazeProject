package be.tinati.maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Game {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(new File("out/production/resources/BaseMaze.txt"));
        BufferedReader reader = new BufferedReader(fileReader);
        System.out.println(reader.readLine());

        Maze mymaze = new Maze(3, 3);

        for (int i = 0; i < 9; i++) {
            String inputLine = reader.readLine();
            System.out.println(inputLine);
            String[] roomDetails = inputLine.split(",");
            int xCoordinate = Integer.parseInt(roomDetails[0]);
            int yCoordinate = Integer.parseInt(roomDetails[1]);

            Wall southWall = Wall.valueOf(roomDetails[3].toUpperCase());
            Wall norhtWall = Wall.valueOf(roomDetails[2].toUpperCase());
            Wall eastWall = Wall.valueOf(roomDetails[5].toUpperCase());
            Wall westWall = Wall.valueOf(roomDetails[4].toUpperCase());
            mymaze.setRoomSouthWall(xCoordinate, yCoordinate, southWall);
            mymaze.setRoomEastWall(xCoordinate, yCoordinate, eastWall);
            mymaze.setRoomNorthWall(xCoordinate, yCoordinate, norhtWall);
            mymaze.setRoomWestWall(xCoordinate, yCoordinate, westWall);
        }

        mymaze.print();
    }
}
