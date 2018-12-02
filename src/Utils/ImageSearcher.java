package Utils;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageSearcher {
	public static boolean isOnScreen(BufferedImage bi, Rectangle location) {
		BufferedImage image = null;
		try {
			image = new Robot().createScreenCapture(location);
			ImageIO.write(image, "png", new File("screenshot.png"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {

				boolean invalid = false;
				int k = x, l = y;
				for (int a = 0; a < bi.getWidth(); a++) {
					l = y;
					for (int b = 0; b < bi.getHeight(); b++) {
						int color = image.getRGB(k, l);
						if (bi.getRGB(a, b) > image.getRGB(k, l) * 0.9999 && bi.getRGB(a, b) < color * 1.0001) {
							invalid = true;
							break;
						} else {
							l++;
						}
					}
					if (invalid) {
						break;
					} else {
						k++;
					}

				}
				if (!invalid) {
					return true;
				}
			}
		}

		return false; // If no image is found

	}
	public static int[] searchForColor(Rectangle loc, int searchColor) {
		BufferedImage bi = null;
		try {
			bi = new Robot().createScreenCapture(loc);
//			ImageIO.write(bi, "png", new File(++x + "screenshot.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int x = 0; x < bi.getWidth(); ++x)
			for (int y = 0; y < bi.getHeight(); ++y) {
				if ((bi.getRGB(x, y) & 0x00FFFFFF) == searchColor)
					return new int[] { x, y };
			}
		return null;
	}
}
