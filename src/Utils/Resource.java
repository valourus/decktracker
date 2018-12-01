package Utils;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import Cards.Card;

public class Resource {

	private static HashMap<Images, BufferedImage> images = new HashMap<Images, BufferedImage>();
	private static HashMap<Coords, Rectangle> coords = new HashMap<Coords, Rectangle>();
	private static ArrayList<Card> cards = new ArrayList<>();

	public static ArrayList<Card> getCards() {
		return cards;
	}

	public static void setCards(ArrayList<Card> cards) {
		Resource.cards = cards;
	}

	public static void setImages(HashMap<Images, BufferedImage> images) {
		Resource.images = images;
	}

	public static void setCoords(HashMap<Coords, Rectangle> coords) {
		Resource.coords = coords;
	}

	public static BufferedImage getImage(Images name) {
		return images.get(name);
	}

	public static Rectangle getLocation(Coords name) {
		return coords.get(name);
	}

}
