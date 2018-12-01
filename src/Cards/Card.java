package Cards;

public class Card {
	private String name;
	private int deckPos;

	private int cost;

	public Card(String name, int cost) {
		this.name = name;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}

	public String getFilename() {
		return System.getProperty("user.dir") + "\\src\\indexer\\images\\" + name.toLowerCase().replaceAll(" ", "_")
				+ ".png";
	}

	public int getDeckPos() {
		return deckPos;
	}

	public void setDeckPos(int deckPos) {
		this.deckPos = deckPos;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
