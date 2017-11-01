package DCT;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageFactory {
		
	public BufferedImage allocateImage(){
		
		BufferedImage image = null;
		
		try{
			image = ImageIO.read(new File("Images/lena.jpg"));
			System.out.println("Image Assigned!");
		} catch (IOException e){
			
		}
		
		return image;
	}
	
	
	
	
	
}
