package DCT;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class ImageFactory {
	
	public BufferedImage loadImage(String fileName) {
		BufferedImage image = null;
		String filePath = ("Images/" + fileName);
		File aFile = new File(filePath);
		try {
			image = ImageIO.read(aFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Image Assigned!");
		return image;
	}
	
	public static void importImage(String filePath) {
		File aFile = new File(filePath);
		//Create copy of file in Images folder
		if (aFile.renameTo(new File("Images/" + aFile.getName()))) {
			System.out.println("File moved successfully");
		} else {
			System.out.println("File failed to move");
		}
	}
}

