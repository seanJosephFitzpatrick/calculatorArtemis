package DCT;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DCTDriver {
	
	static BufferedImage img;
	
	static final int N = 8;
	
	static int row = 0;
	static int col = 0;
	
	static int[][] pixelValues;
	
	static int[][] redValues;
	static int[][] blueValues;
	static int[][] greenValues;
	static int[][] alphaValues;
	static int[][] transparencyValues;
	static int[][] redDCTValues;
	static int[][] blueDCTValues;
	static int[][] greenDCTValues;
	static int[][] alphaDCTValues;
	static int[][] transparencyDCTValues;
	
	static int imgHeight;
	static int imgWidth;
	
	public static void main(String[] args){
		
		ImageFactory dct = new ImageFactory();
		
		img = dct.allocateImage();
		
		imgHeight = img.getHeight();
		imgWidth = img.getWidth();
		
		instantiateArrays();
		loadPixelValues();
		printArray(redValues);
		System.out.println("---------------");
//		generate8X8grid(redValues);
		
		DCT adct = new DCT();
		adct.create8x8s(redValues, 8);
		
		
		
		
		
		
		
	}
	
	private static void instantiateArrays(){
		redValues = new int[imgWidth][imgHeight];
		greenValues = new int[imgWidth][imgHeight];
		blueValues = new int[imgWidth][imgHeight];
		alphaValues = new int[imgWidth][imgHeight];
		transparencyValues = new int[imgWidth][imgHeight];
	}
	
	private static void loadPixelValues(){
		for(int i = 0; i < imgWidth; i++)
		    for(int j = 0; j < imgHeight; j++){
		    	Color color = new Color(img.getRGB(i, j));
		    	redValues[i][j] = color.getRed();
		    	blueValues[i][j] = color.getBlue();
		    	greenValues[i][j] = color.getGreen();
		    	alphaValues[i][j] = color.getAlpha();
		    	transparencyValues[i][j] = color.getTransparency();
		    }	        
	}
	
	public static void printArray(int[][] print){
		for(int i = 0; i < print.length; i++){
			for(int j = 0; j < print.length; j++){
				System.out.print(print[i][j] + "\t");
			}
			System.out.println();
		}
	}
	

}

