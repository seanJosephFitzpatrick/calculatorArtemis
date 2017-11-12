package DCT;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class ImageFactory {

	public BufferedImage allocateImage(){
		BufferedImage image = null;
		Scanner in = new Scanner(System.in);
		try{
			int choice = 0;
			while (choice != 2) {
				System.out.println("1. Import new Image");
				System.out.println("2. Use Imported Image");
				choice = in.nextInt();
				if (choice == 1) {
					System.out.print("Enter file path to image: ");
					String filePath = in.next();
					//Change windows filepath to one accepted by Java
					filePath = filePath.replace("/", "\\");
					File aFile = new File(filePath);
					//Create copy of file in Images folder
					if (aFile.renameTo(new File("Images/" + aFile.getName()))) {
						System.out.println("File moved successfully");
					} else {
						System.out.println("File failed to move");
					}
				} else if (choice == 2) {
					System.out.print("Enter filename: ");
					String filePath = ("Images/" + in.next());
					File aFile = new File(filePath);
					image = ImageIO.read(aFile);
					System.out.println("Image Assigned!");
				}
			}
		} catch (IOException e){
			System.out.println("Image not found");
		}
		return image;
	}

	/*public static void main(String[] args) {
		ImageFactory i = new ImageFactory();
		BufferedImage img = i.allocateImage();
		System.out.println(img.getHeight());
	}*/
}

