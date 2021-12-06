/**
 * Movie class
 * author Helga
 */
package mru.tsc.model;

public class Movie extends Item {

	private String releaseYear;
	private int rating;

	/**
	 * Movie method 
	 * @param sn
	 * @param name
	 * @param price
	 * @param availableCount
	 * @param ageAppropriate
	 * @param releaseYear
	 * @param rating
	 */
	public Movie(String sn, String name, double price, int availableCount, int ageAppropriate, String releaseYear,
			int rating) {
		super(sn, name, price, availableCount, ageAppropriate);
		this.rating = rating;
		this.releaseYear = releaseYear;
	}
	
	// getter for each variable
	public String getReleaseYear() {
		return releaseYear;
	}

	public int getRating() {
		return rating;
	}
	
	/**
	 * toString Method 
	 */
	@Override

	public String toString() {

		return this.getSN() + ";" + this.getName() + ";" + this.getPrice() + ";" + this.getAvailableCount() + ";"
				+ this.getAgeAppropriate() + ";" + releaseYear + ";" + rating;
	}

}
