package mru.tsc.model;

/**
 * This class is the SuperClass Item
 * 
 * @author Chidera
 *
 */
public class Item {

	// Memeber variables shared by each type of item
	private String SN;
	private String name;
	private double price;
	private int availableCount;
	private int ageAppropriate;
/**
 * Item method
 * @param sn
 * @param name
 * @param price
 * @param availableCount
 * @param ageAppropriate
 */
	// Constructor
	public Item(String sn, String name, double price, int availableCount, int ageAppropriate) {

		this.SN = sn;
		this.name = name;
		this.price = price;
		this.availableCount = availableCount;
		this.ageAppropriate = ageAppropriate;
	}

	// setters and getters for each variable

	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}

	public String getSN() {
		return SN;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getAvailableCount() {
		return availableCount;
	}

	public int getAgeAppropriate() {
		return ageAppropriate;
	}

}
