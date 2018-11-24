package Utils;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageSearcher {
	public static boolean isOnScreen(BufferedImage bi, Rectangle location) {
		BufferedImage image = null;
		try {
			image = new Robot().createScreenCapture(location);
			ImageIO.write(image, "jpg", new File("screenshot.jpg"));

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
						if (bi.getRGB(a, b) != image.getRGB(k, l)) {
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
