package DCT;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

import MatrixCalculations.MatrixCalculator;

public class DCT {

	static Scanner sc = new Scanner(System.in);

	static int N = 8;
	static double n = 8d;

	static double[][] MTest = new double[][] {
		{16, 8, 23, 16, 5, 14, 7, 22 },
		{20, 14, 22, 7, 14, 22, 24, 6},
		{15, 23, 24, 23, 9, 6, 6, 20},
		{14, 8, 11, 14, 12, 12, 25, 12},
		{10, 9, 11, 9, 13, 19, 5, 17},
		{8, 22, 20, 15, 12, 8, 22, 17},
		{24, 22, 17, 12, 18, 11, 23, 14},
		{21, 25, 15, 16, 23, 14, 22, 22}
	};

	static double[][] Q50 = {{16, 11, 10, 16, 24, 40, 51, 61},
			{12, 12, 14, 19, 26, 58, 60, 55},
			{14, 13, 16, 24, 40, 57, 69, 56},
			{14, 17, 22, 29, 51, 87, 80, 62},
			{18, 22, 37, 56, 68, 109, 103, 77},
			{24, 35, 55, 64, 81, 104, 113, 92},
			{49, 64, 78, 87, 103, 121, 120, 101},
			{72, 92, 95, 98, 112, 100, 103, 99}};

	static double[][] Qx = new double[N][N];
	static double[][] T = new double[N][N];
	static double[][] Tt = new double[N][N];
	static double[][] TM = new double[N][N];
	static double[][] TMTt = new double[N][N];
	static double[][] DCTResult = new double[N][N];

	public static ArrayList<double[][]> run(ArrayList<double[][]> grids, double q){
		ArrayList<double[][]> results = new ArrayList<double[][]>();
		int i = 0;
		getQMatrix(q);
		roundArray(Qx);
		while(i < grids.size()){
			T = new double[N][N];
			Tt = new double[N][N];
			TM = new double[N][N];
			TMTt = new double[N][N];
			DCTResult = new double[N][N];
			Generate_T();
			multiply(T, grids.get(i), TM);
			multiply(TM, Tt, TMTt);
			roundArray(TMTt);
			quantization(TMTt, Qx, DCTResult);
			roundArrayForImage(DCTResult);
			results.add(DCTResult);
			i++;
		}
		System.out.println(results.size());
		return results;
	}

	public static void printArray(double[][] qx2){
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(3);
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				System.out.print(nf.format(qx2[i][j]) + "\t");
			}
			System.out.println();
		}
	}

	public static void Generate_T() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (r == 0) {
					T[r][c] = 1 / Math.sqrt(n);
				} else {
					T[r][c] = Math.sqrt((2.0/n)) * Math.cos((r*Math.PI * (2*c+1)) / (2 * n));
				}
				Tt[c][r] = T[r][c];
			}
		}
	}

	public static void multiply(double[][] t2, double[][] ds, double[][] tM2){	//R Serves as result
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				tM2[i][j] = 0;
				for(int q = 0; q < N; q++){
					tM2[i][j] = tM2[i][j] + (t2[i][q] * ds[q][j]);
				}
			}
		}
	}

	public static void roundArray(double[][] qx2){
		for(int i = 0; i < qx2.length; i++){
			for(int j = 0; j < qx2[0].length; j++){
				qx2[i][j] = Math.round(qx2[i][j]);
				if(qx2[i][j] > 255){
					qx2[i][j] = 255;
				}
			}
		}
	}

	public static void roundArrayForImage(double[][] chunk) {
		for(int i = 0; i < chunk.length; i++){
			for(int j = 0; j < chunk[0].length; j++){
				chunk[i][j] = Math.round(chunk[i][j]);
				if(chunk[i][j] > 255){
					chunk[i][j] = 255;
				} else if (chunk[i][j] < 0) {
					chunk[i][j] = 0;
				}
			}
		}
	}

	public static void getQMatrix(double q){
		if(q == 50){
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					Qx[i][j] = (int) Q50[i][j];
				}
			}
		} else if(q > 50){
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					Qx[i][j] = (int) (Q50[i][j] * ((100d - q) / 50d));
				}
			}
		} else if(q < 50){
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					Qx[i][j] = (int) (Q50[i][j] * (50d / q));
				}
			}
		}
	}

	public static void quantization(double[][] tMTt2, double[][] qx2, double[][] dCTResult2){
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				dCTResult2[i][j] = (tMTt2[i][j] / qx2[i][j]);
			}
		}
	}

	public static ArrayList<double[][]> create8x8s(int[][] source, int N) throws ArrayIndexOutOfBoundsException, NullPointerException  {
		if (N <= 0) {
			throw new ArrayIndexOutOfBoundsException("Chunks must be atleast 1x1");
		}
		int size = source.length / N * (source[0].length / N);
		ArrayList<double [][]> subArrays = new ArrayList<>();

		for (int c = 0; c < size; c++) {
			double[][] sub = new double[N][N];
			int startx = (N * (c / N)) % source.length;
			int starty = (N * c) % source[0].length;

			if (starty + N > source[0].length) {
				starty = 0;
			}

			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					sub[row][col] = source[startx + row][col + starty];
				}
			}
			subArrays.add(sub);
			//DCTDriver.printArray(sub);
			System.out.println("--------------");
			System.out.println();
		}
		return subArrays;
	}

	public static int[][] recombine8x8s(ArrayList<double[][]> chunks, int width, int height, int chunkSize) {
		int[][] recombinedMatrix = new int[height][width];
		int xIndex = 0;
		int yIndex = 0;
		int iterator = height / chunkSize;

		int startValue = 0;
		int endValue = iterator;
		int test = 0;

		for (int x = 0; x < iterator; x++) {
			for (int k = 0; k < chunkSize; k++) {
				for (int i = startValue; i < endValue; i++) {
					for (int j = 0; j < chunks.get(i)[0].length; j++) {
						recombinedMatrix[yIndex][xIndex] = (int) chunks.get(i)[k][j];
						xIndex++;
					}
				}
				yIndex++;
				xIndex = 0;
			}
			startValue += iterator;
			endValue += iterator;
		}
		System.out.println("Recombination Successful!");
		return recombinedMatrix;
	}
}