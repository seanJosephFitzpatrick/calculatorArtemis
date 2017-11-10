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
	static int[][] redValues2;

	static int[][] redValues;
	static int[][] blueValues;
	static int[][] greenValues;
	static int[][] alphaValues;

	static int imgHeight;
	static int imgWidth;

	public static void main(String[] args){
		ImageFactory dct = new ImageFactory();

		img = dct.allocateImage();
		imgHeight = img.getHeight();
		imgWidth = img.getWidth();

		instantiateArrays();

		System.out.println(imgHeight);
		System.out.println(imgWidth);
		loadPixelValues();

		DCT adct = new DCT();
		ArrayList<int[][]> redChunks = adct.create8x8s(redValues, 8);
		ArrayList<int[][]> greenChunks = adct.create8x8s(greenValues, 8);
		ArrayList<int[][]> blueChunks = adct.create8x8s(blueValues, 8);

		ArrayList<int[][]> resultRedChunks = adct.run(redChunks);
	}

	private static void instantiateArrays(){
		pixelValues = new int[imgWidth][imgHeight];
		redValues = new int[imgWidth][imgHeight];
		redValues2 = new int[imgWidth][imgHeight];
		greenValues = new int[imgWidth][imgHeight];
		blueValues = new int[imgWidth][imgHeight];
		alphaValues = new int[imgWidth][imgHeight];
	}

	private static void loadPixelValues(){
		for(int i = 1; i < imgWidth; i++)
		    for(int j = 1; j < imgHeight; j++){
		    	pixelValues[i][j] = img.getRGB(i, j);
		    	alphaValues[i][j] = (pixelValues[i][j] >> 24) & 0xFF;
		    	redValues[i][j] = (pixelValues[i][j] >> 16) & 0xFF;
		    	greenValues[i][j] = (pixelValues[i][j] >> 8) & 0xFF;
		    	blueValues[i][j] = pixelValues[i][j] & 0xFF;
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

