package Cards;

import java.awt.image.BufferedImage;

public class Card {
	private String name;
	private int deckPos;

	private int cost;
	private BufferedImage img;

	public Card(String name, int cost, BufferedImage img) {
		this.name = name;
		this.cost = cost;
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}

	public BufferedImage getImg() {
		return img;
	}

	public int getDeckPos() {
		return deckPos;
	}

	public void setDeckPos(int deckPos) {
		this.deckPos = deckPos;
	}
}
