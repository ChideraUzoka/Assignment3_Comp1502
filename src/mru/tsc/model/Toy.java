package mru.tsc.model;

/**
 * This is the toy class which extends the item class
 * 
 * @author Chidera
 *
 */
public class Toy extends Item {

	private String brand;
	/**
	 * Toy method 
	 * @param sn
	 * @param name
	 * @param price
	 * @param availableCount
	 * @param areAppropriate
	 * @param brand
	 */
	public Toy(String sn, String name, double price, int availableCount, int areAppropriate, String brand) {
		super(sn, name, price, availableCount, areAppropriate);

		this.brand = brand;
	}
	//getter for brand
	public String getBrand() {
		return brand;
	}

}
