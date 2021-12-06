package mru.tsc.model;

public class Figure extends Toy {

	private String figureType;
	private String brand;
	
	/**
	 * figure method 
	 * @param sn
	 * @param name
	 * @param brand
	 * @param price
	 * @param availableCount
	 * @param areAppropriate
	 * @param figureType
	 */
	public Figure(String sn, String name, String brand, double price, int availableCount, int areAppropriate,
			String figureType) {

		super(sn, name, price, availableCount, areAppropriate, brand);
	//declaration 
		this.figureType = figureType;
		this.brand = brand;
	}
	// getter for figure type
	public String getFigureType() {
		return figureType;
	}
	
	/**
	 * overriding toString method
	 */
	@Override

	public String toString() {

		return this.getSN() + ";" + this.getName() + ";" + brand + ";" + this.getPrice() + ";"
				+ this.getAvailableCount() + ";" + this.getAgeAppropriate() + ";" + figureType;
	}
}
