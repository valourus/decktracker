package Utils;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Resource {

	private static HashMap<Images, BufferedImage> images = new HashMap<Images, BufferedImage>();
	private static HashMap<Coords, Rectangle> coords = new HashMap<Coords, Rectangle>();

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
