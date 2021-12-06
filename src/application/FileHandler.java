package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.tsc.model.BoardGame;
import mru.tsc.model.Book;
import mru.tsc.model.Figure;
import mru.tsc.model.Item;
import mru.tsc.model.Movie;

/**
 * class to load the file and split each element into a variable
 * 
 * @param none
 * @return none
 * @throws FileNotFoundException
 *
 */
public class FileHandler {

	// This is the items.txt file with all the players information
	private final String FILE = ("res/items.txt");

	public String getFILE() {
		return FILE;
	}

	ArrayList<Item> itemList;

	public ArrayList<Item> masterItemList() throws FileNotFoundException {

		// create array list
		itemList = new ArrayList<>();

		File itemsFile = new File(FILE);
		String itemLine;
		// split each item into the sepereate elements
		String[] splitLine = null;

		// to check if the file exists
		if (itemsFile.exists()) {
			// read the text filer

			Scanner reader = new Scanner(itemsFile);
			while (reader.hasNextLine()) {
				itemLine = reader.nextLine();
				splitLine = itemLine.split(";");

				// get SN from split line
				String sn = splitLine[0];

				// get first character
				char firstSnNumber = sn.charAt(0);

				// check for movies
				if (firstSnNumber == '4' || firstSnNumber == '5' || firstSnNumber == '6') {

					itemList.add(createMovie(splitLine));
				}

				// check for books
				else if (firstSnNumber == '2' || firstSnNumber == '3') {

					itemList.add(createBook(splitLine));

				}

				// check for figure
				else if (firstSnNumber == '0' || firstSnNumber == '1') {

					itemList.add(createFigure(splitLine));
				}

				// check for board game
				else if (firstSnNumber == '7' || firstSnNumber == '8' || firstSnNumber == '9') {

					itemList.add(createBoardGame(splitLine));

				}

			}
		}
		return itemList;

	}

	public Item createBoardGame(String[] splitLine) {
		int minNumPlayers = 0;
		int maxNumPlayers = 0;

		String snum = splitLine[0];
		String name = splitLine[1];
		String brand = splitLine[2];
		double price = Double.parseDouble(splitLine[3]);
		int availCount = Integer.parseInt(splitLine[4]);
		int ageAppropriate = Integer.parseInt(splitLine[5]);
		String numPlayers = splitLine[6];

		try {
			// to get the max and min number of players
			String[] numPlySplit = numPlayers.split("-");

			minNumPlayers = Integer.parseInt(numPlySplit[0]);
			maxNumPlayers = Integer.parseInt(numPlySplit[1]);

			// create new boardgame object
		} catch (Exception e) {
			System.out.println("Boardgame without a player range exists");
		}

		return new BoardGame(snum, name, brand, price, availCount, ageAppropriate, numPlayers, minNumPlayers,
				maxNumPlayers);

	}

	public Item createFigure(String[] splitLine) {

		String snum = splitLine[0];
		String name = splitLine[1];
		String brand = splitLine[2];
		double price = Double.parseDouble(splitLine[3]);
		int availCount = Integer.parseInt(splitLine[4]);
		int ageAppropriate = Integer.parseInt(splitLine[5]);
		String figType = splitLine[6];

		// create new figure object

		return new Figure(snum, name, brand, price, availCount, ageAppropriate, figType);

	}

	public Item createBook(String[] splitLine) {

		String snum = splitLine[0];
		String name = splitLine[1];
		String authors = splitLine[2];
		double price = Double.parseDouble(splitLine[3]);
		int availCount = Integer.parseInt(splitLine[4]);
		int ageAppropriate = Integer.parseInt(splitLine[5]);
		String genre = splitLine[6];
		String publication = splitLine[7];

		// create new book object

		return new Book(snum, name, authors, price, availCount, ageAppropriate, genre, publication);

	}

	public Item createMovie(String[] splitLine) {

		String snum = splitLine[0];
		String name = splitLine[1];
		double price = Double.parseDouble(splitLine[2]);
		int availCount = Integer.parseInt(splitLine[3]);
		int ageAppropriate = Integer.parseInt(splitLine[4]);
		String releaseYear = splitLine[5];
		int rating = Integer.parseInt(splitLine[6]);

		return new Movie(snum, name, price, availCount, ageAppropriate, releaseYear, rating);

	}

	public void save(ArrayList<Item> itemsList) throws FileNotFoundException {

		PrintWriter pw = new PrintWriter(FILE);
		for (Item it : itemsList) {
			pw.println(it);

		}
		System.out.println("Saving file...");
		System.out.println("Thanks for using the Mini Store Application!");
		pw.close();
	}

}
