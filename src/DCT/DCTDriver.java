package DCT;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class DCTDriver {

	static BufferedImage img;
	static BufferedImage rebuiltImg;
	static ImageFactory dct;
	static DCT adct;

	static final int N = 8;

	static int row = 0;
	static int col = 0;

	//Full RGBA pixel values (BufferedImage.getRGB())
	static int[][] preCompressionPixelValues;
	static int[][] postCompressionPixelValues;
	//Red Values
	static int[][] redValues;
	static ArrayList<double[][]> redChunks;
	//Green
	static int[][] greenValues;
	static ArrayList<double[][]> greenChunks;
	//Blue
	static int[][] blueValues;
	static ArrayList<double[][]> blueChunks;
	//Alpha
	static int[][] alphaValues;

	//Width and Height of image
	static int imgHeight;
	static int imgWidth;

	public DCTDriver() {
		dct = new ImageFactory();
		adct = new DCT();
	}
	
	public static void main(String[] args) throws IOException{
		dct = new ImageFactory();
		adct = new DCT();
		loadImage();

		redChunks = adct.create8x8s(redValues, 8);
		greenChunks = adct.create8x8s(greenValues, 8);
		blueChunks = adct.create8x8s(blueValues, 8);
		
		ArrayList<double[][]> resultRedChunks = adct.run(redChunks);
		ArrayList<double[][]> resultGreenChunks = adct.run(greenChunks);
		ArrayList<double[][]> resultBlueChunks = adct.run(blueChunks);
		
		recombineImage(resultRedChunks, resultGreenChunks, resultBlueChunks);
	}
	
	public static int recombinePixel(int r, int g, int b, int a) {
		int p = (a << 24) | (r << 16) | (g << 8) | b;
		return p;
	}
	
	public static void recombineImage(ArrayList<double[][]> finalRedChunks, ArrayList<double[][]> finalGreenChunks, ArrayList<double[][]> finalBlueChunks) throws IOException {
		int[][] combinedReds = adct.recombine8x8s(finalRedChunks, 256, 256, 8);
		int[][] combinedGreens = adct.recombine8x8s(finalGreenChunks, 256, 256, 8);
		int[][] combinedBlues = adct.recombine8x8s(finalBlueChunks, 256, 256, 8);
		
		rebuiltImg = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_ARGB);
		File f = null;
		
		for (int i = 0; i < imgHeight; i++) {
			for (int j = 0; j < imgWidth; j++) {
				postCompressionPixelValues[i][j] = recombinePixel(combinedReds[i][j], combinedGreens[i][j], combinedBlues[i][j], 1);
				rebuiltImg.setRGB(i, j, postCompressionPixelValues[i][j]);
			}
		}
		
		f = new File("Images/compressedImage.jpg");
		ImageIO.write(rebuiltImg, "jpg", f);
	}
	
	public static void loadImage() {
		img = dct.allocateImage();
		imgHeight = img.getHeight();
		imgWidth = img.getWidth();
		instantiateArrays();
		loadPreCompressionPixelValues();
	}

	private static void instantiateArrays(){
		preCompressionPixelValues = new int[imgWidth][imgHeight];
		postCompressionPixelValues = new int[imgWidth][imgHeight];
		redValues = new int[imgWidth][imgHeight];
		redChunks = new ArrayList<double[][]>();
		greenValues = new int[imgWidth][imgHeight];
		greenChunks = new ArrayList<double[][]>();
		blueValues = new int[imgWidth][imgHeight];
		blueChunks = new ArrayList<double[][]>();
		alphaValues = new int[imgWidth][imgHeight];
	}

	//Load the pixel values from the image and separate them into their individual color arrays
	private static void loadPreCompressionPixelValues(){
		for(int i = 0; i < imgWidth; i++) {
		    for(int j = 0; j < imgHeight; j++){
		    	preCompressionPixelValues[i][j] = img.getRGB(i, j);
		    	alphaValues[i][j] = (preCompressionPixelValues[i][j] >> 24) & 0xFF;
		    	redValues[i][j] = (preCompressionPixelValues[i][j] >> 16) & 0xFF;
		    	greenValues[i][j] = (preCompressionPixelValues[i][j] >> 8) & 0xFF;
		    	blueValues[i][j] = preCompressionPixelValues[i][j] & 0xFF;
		    }
		}
	}

	//Utility print methods
	public static void printArray(int[][] print){
		for(int i = 0; i < print.length; i++){
			for(int j = 0; j < print.length; j++){
				System.out.print(print[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void printArray(double[][] print){
		for(int i = 0; i < print.length; i++){
			for(int j = 0; j < print.length; j++){
				System.out.print(print[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

