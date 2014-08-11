package cz.zweistein.garfield;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.imageio.ImageIO;

public class PictureParser {

	public static void main(String[] args) throws IOException {

		int baseIndex = 705;

		NumberFormat formatter = new DecimalFormat("0000");

		File[] files = (new File("./input")).listFiles();

		for (int i = 0; i < files.length; i++) {

			String imageFile = files[i].getPath();

			System.out.println((baseIndex + i) + " " + imageFile);

			BufferedImage image = ImageIO.read(new File(imageFile));

			int width = 167;
			int height = 149;

			if (image.getHeight() < height) {
				BufferedImage resizedImage = new BufferedImage(
						image.getWidth(), height, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g = resizedImage.createGraphics();
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, image.getWidth(), image.getHeight());
				g.drawImage(image, 0, (height - image.getHeight()) / 2,
						image.getWidth(), image.getHeight(), null);
				g.dispose();
				image = resizedImage;
			}

			int topOffset = (image.getHeight() - height) / 2;

			BufferedImage tileA = image
					.getSubimage(0, topOffset, width, height);
			BufferedImage tileB = image.getSubimage(
					(image.getWidth() - width) / 2, topOffset, width, height);
			BufferedImage tileC = image.getSubimage(image.getWidth() - width,
					topOffset, width, height);

			String baseFile = "./output/" + formatter.format(baseIndex + i);

			ImageIO.write(tileA, "png", new File(baseFile + "a.png"));
			ImageIO.write(tileB, "png", new File(baseFile + "b.png"));
			ImageIO.write(tileC, "png", new File(baseFile + "c.png"));

		}

	}

}
