package mru.tsc.model;

/**
 * This is the book class which extends the item class
 * 
 * @author Chidera
 *
 */
public class Book extends Item {

	private String authorList;
	private String genre;
	private String publication;

	public Book(String sn, String name, String authors, double price, int availableCount, int ageAppropriate,
			String genre, String publication) {
		super(sn, name, price, availableCount, ageAppropriate);
		this.authorList = authors;
		this.genre = genre;
		this.publication = publication;
	}

	public String getAuthorList() {
		return authorList;
	}

	public String getGenre() {
		return genre;
	}

	public String getPublication() {
		return publication;
	}

	@Override

	public String toString() {

		return this.getSN() + ";" + this.getName() + ";" + authorList + ";" + this.getPrice() + ";"
				+ this.getAvailableCount() + ";" + this.getAgeAppropriate() + ";" + genre + ";" + publication;
	}
}
