
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import Cards.CardFactory;
import Controllers.LogicController;
import Utils.Coords;
import Utils.Images;
import Utils.Resource;

public class Application {

	public Application() {
		HashMap<Images, BufferedImage> images = new HashMap<Images, BufferedImage>();
		HashMap<Coords, Rectangle> coords = new HashMap<Coords, Rectangle>();


		coords.put(Coords.ABOVE_FIRST_CARD, new Rectangle(483, 25, 30, 30));
		coords.put(Coords.ABOVE_SECOND_CARD, new Rectangle(530, 25, 30, 30));
		coords.put(Coords.ABOVE_THIRD_CARD, new Rectangle(582, 25, 30, 30));
		coords.put(Coords.ABOVE_FOURTH_CARD, new Rectangle(623, 25, 30, 30));
		coords.put(Coords.ABOVE_FIFTH_CARD, new Rectangle(671, 25, 30, 30));
		coords.put(Coords.ABOVE_SIXTH_CARD, new Rectangle(717, 25, 30, 30));
		coords.put(Coords.ABOVE_SEVENTH_CARD, new Rectangle(764, 25, 30, 30));
		coords.put(Coords.ABOVE_EIGHTH_CARD, new Rectangle(809, 25, 30, 30));

		coords.put(Coords.FIRST_CARD, new Rectangle(480, 55, 40, 50));
		coords.put(Coords.SECOND_CARD, new Rectangle(528, 55, 40, 50));
		coords.put(Coords.THIRD_CARD, new Rectangle(575, 55, 40, 50));
		coords.put(Coords.FOURTH_CARD, new Rectangle(620, 55, 40, 50));
		coords.put(Coords.FIFTH_CARD, new Rectangle(667, 55, 40, 50));
		coords.put(Coords.SIXTH_CARD, new Rectangle(715, 55, 40, 50));
		coords.put(Coords.SEVENTH_CARD, new Rectangle(760, 55, 40, 50));
		coords.put(Coords.EIGHTH_CARD, new Rectangle(805, 55, 40, 50));

		coords.put(Coords.OPPONENT_DECK, new Rectangle(473, 42, 384, 65));
		
		Resource.setCoords(coords);
		Resource.setImages(images);
		Resource.setCards(CardFactory.createCards());
		new LogicController();
	}

	public static void main(String[] args) {
		new Application();
	}

}