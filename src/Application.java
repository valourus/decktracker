
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import Controllers.LogicController;
import Utils.Coords;
import Utils.Images;
import Utils.Resource;

public class Application {

	public Application() {
		HashMap<Images, BufferedImage> images = new HashMap<Images, BufferedImage>();
		HashMap<Coords, Rectangle> coords = new HashMap<Coords, Rectangle>();

		coords.put(Coords.ABOVE_FIRST_CARD, new Rectangle(483, 25, 30, 30));
		coords.put(Coords.ABOVE_SECOND_CARD, new Rectangle(532, 25, 30, 30));
		coords.put(Coords.ABOVE_THIRD_CARD, new Rectangle(582, 25, 30, 30));
		coords.put(Coords.ABOVE_FOURTH_CARD, new Rectangle(623, 25, 30, 30));
		coords.put(Coords.ABOVE_FIFTH_CARD, new Rectangle(671, 25, 30, 30));
		coords.put(Coords.ABOVE_SIXTH_CARD, new Rectangle(717, 25, 30, 30));
		coords.put(Coords.ABOVE_SEVENTH_CARD, new Rectangle(764, 25, 30, 30));
		coords.put(Coords.ABOVE_EIGHTH_CARD, new Rectangle(809, 25, 30, 30));

		Resource.setCoords(coords);
		Resource.setImages(images);

		new LogicController();
	}

	public static void main(String[] args) {
		new Application();
	}

}