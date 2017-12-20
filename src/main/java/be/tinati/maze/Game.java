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
		
		mymaze.print();
	}
}
