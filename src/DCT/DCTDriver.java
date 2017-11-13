package DCT;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class DCTDriver {
	BufferedImage img;
	BufferedImage rebuiltImg;
	ImageFactory imageFactory;
	DCT adct;

	final int N = 8;
	int row = 0;
	int col = 0;

	//Full RGBA pixel values (BufferedImage.getRGB())
	int[][] preCompressionPixelValues;
	int[][] postCompressionPixelValues;
	//Red Values
	int[][] redValues;
	ArrayList<double[][]> redChunks;
	ArrayList<double[][]> quantizedRedChunks;
	//Green
	int[][] greenValues;
	ArrayList<double[][]> greenChunks;
	ArrayList<double[][]> quantizedGreenChunks;
	//Blue
	int[][] blueValues;
	ArrayList<double[][]> blueChunks;
	ArrayList<double[][]> quantizedBlueChunks;
	//Alpha
	int[][] alphaValues;

	//Width and Height of image
	int imgHeight;
	int imgWidth;

	public DCTDriver() {
		imageFactory = new ImageFactory();
		adct = new DCT();
	}
	
	public void loadImage(String fileName) {
		img = imageFactory.loadImage(fileName);
		imgHeight = img.getHeight();
		imgWidth = img.getWidth();
		instantiateArrays();
		loadPreCompressionPixelValues();
	}
	
	private void instantiateArrays(){
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
	private void loadPreCompressionPixelValues(){
		for(int i = 0; i < imgWidth; i++) {
		    for(int j = 0; j < imgHeight; j++){
		    	preCompressionPixelValues[i][j] = img.getRGB(i, j);
		    	alphaValues[i][j] = (preCompressionPixelValues[i][j] >> 24) & 0xFF;
		    	redValues[i][j] = (preCompressionPixelValues[i][j] >> 16) & 0xFF;
		    	greenValues[i][j] = (preCompressionPixelValues[i][j] >> 8) & 0xFF;
		    	blueValues[i][j] = preCompressionPixelValues[i][j] & 0xFF;
		    }
		}
		
		redChunks = adct.create8x8s(redValues, 8);
		greenChunks = adct.create8x8s(greenValues, 8);
		blueChunks = adct.create8x8s(blueValues, 8);
	}
	
	public void compressImage(double qValue) {
		compressChunks(qValue);
		try {
			recombineImage(quantizedRedChunks, quantizedGreenChunks, quantizedBlueChunks);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void compressChunks(double qValue) {
		quantizedRedChunks = adct.run(redChunks, qValue);
		quantizedGreenChunks = adct.run(greenChunks, qValue);
		quantizedBlueChunks = adct.run(blueChunks, qValue);
	}
	
	private void recombineImage(ArrayList<double[][]> finalRedChunks, ArrayList<double[][]> finalGreenChunks, ArrayList<double[][]> finalBlueChunks) throws IOException {
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
	
	private int recombinePixel(int r, int g, int b, int a) {
		int p = (a << 24) | (r << 16) | (g << 8) | b;
		return p;
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
	
	/*public static void main(String[] args) {
		DCTDriver d = new DCTDriver();
		d.loadImage("lena.jpg");
		d.compressImage(50);
	}*/
}