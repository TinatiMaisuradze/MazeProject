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
		System.out.println(reader.readLine());
		
		Maze mymaze = new Maze(5, 5);

//      mymaze.room[0][0].eastWall = Wall.BREAKABLE;

//		mymaze.addEastPassage(0, 0);
//		mymaze.addEastPassage(1, 1);
//		mymaze.addEastPassage(2, 2);
//		mymaze.addEastPassage(3, 3);
//		mymaze.addEastPassage(4, 4);
//		mymaze.addEastPassage(5, 5);
//		mymaze.addEastPassage(6, 6);
//		mymaze.addEastPassage(7, 7);
//		mymaze.addEastPassage(8, 8);
//		mymaze.addSouthPassage(0, 1);
//		mymaze.addSouthPassage(1, 2);
//		mymaze.addSouthPassage(2, 3);
//		mymaze.addSouthPassage(3, 4);
//		mymaze.addSouthPassage(4, 5);
//		mymaze.addSouthPassage(5, 6);
//		mymaze.addSouthPassage(6, 7);
//		mymaze.addSouthPassage(7, 8);
		
		mymaze.print();

	}
}
