package mru.tsc.model;

public class BoardGame extends Toy {
	private String numPlayers;
	private int minPlayers;
	private int maxPlayers;
	private String brand;

	public BoardGame(String sn, String name, String brand, double price, int availableCount, int ageAppropriate,
			String numPlayers, int minPlayers, int maxPlayers) {
		super(sn, name, price, availableCount, ageAppropriate, brand);

		this.numPlayers = numPlayers;
		this.maxPlayers = maxPlayers;
		this.minPlayers = minPlayers;
		this.brand = brand;
	}

	public String getNumPlayers() {
		return numPlayers;
	}

	public int getMinPlayers() {
		return minPlayers;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	@Override

	public String toString() {

		return this.getSN() + ";" + this.getName() + ";" + brand + ";" + this.getPrice() + ";"
				+ this.getAvailableCount() + ";" + this.getAgeAppropriate() + ";" + minPlayers + "-" + maxPlayers;
	}

}