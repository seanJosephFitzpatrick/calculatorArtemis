package DCT;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class DCT {

	static Scanner sc = new Scanner(System.in);

	static int N = 8;
	static double n = 8d;

	static int[][] Q50 = {{16, 11, 10, 16, 24, 40, 51, 61},
			{12, 12, 14, 19, 26, 58, 60, 55},
			{14, 13, 16, 24, 40, 57, 69, 56},
			{14, 17, 22, 29, 51, 87, 80, 62},
			{18, 22, 37, 56, 68, 109, 103, 77},
			{24, 35, 55, 64, 81, 104, 113, 92},
			{49, 64, 78, 87, 103, 121, 120, 101},
			{72, 92, 95, 98, 112, 100, 103, 99}};

	static int[][] Qx = new int[N][N];
	static int[][] T = new int[N][N];
	static int[][] Tt = new int[N][N];
	static int[][] TM = new int[N][N];
	static int[][] TMTt = new int[N][N];
	static int[][] DCTResult = new int[N][N];

	public static void run(ArrayList<int[][]> grids){
		int i = 0;
		System.out.print("Please enter a value for Q: ");
		double q = sc.nextDouble();
		getQMatrix(q);
		while(i < grids.size()){
			roundArray(Qx);
			printArray(Qx);
			System.out.println("Matrix M: ");
			printArray(grids.get(i));
			loadT();
			System.out.println();
			System.out.println("Matrix T: ");
			printArray(T);
			System.out.println();
			System.out.println("Matrix Tt: ");
			printArray(Tt);
			System.out.println();
			multiply(T, grids.get(i), TM);
			System.out.println("Intermediary Matrix TM: ");
			printArray(TM);
			System.out.println();
			multiply(TM, Tt, TMTt);
			roundArray(TMTt);
			System.out.println("Intermediary Matrix TMTt (Rounded): ");
			printArray(TMTt);
			System.out.println();
			quantization(TMTt, Qx, DCTResult);
			roundArray(DCTResult);
			System.out.println();
			System.out.println("Resulting Matrix: ");
			printArray(DCTResult);
			i++;
		}
	}

	public static void printArray(int[][] toPrint){
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(3);
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				System.out.print(nf.format(toPrint[i][j]) + "\t");
			}
			System.out.println();
		}
	}

	public static void loadT(){
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(i == 0){
					T[i][j] = (int) (1 / (Math.sqrt(n)));
					Tt[j][i] = T[i][j];
				} else {
					T[i][j] = (int) (Math.sqrt(2 / n) * Math.cos(((2 * j + 1) * i * Math.PI) / (2 * n))); 
					Tt[j][i] = T[i][j];
				}
			}
		}
	}

	public static void multiply(int[][] x, int[][] y, int[][] r){	//R Serves as result
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				r[i][j] = 0;
				for(int q = 0; q < N; q++){
					r[i][j] = r[i][j] + (x[i][q] * y[q][j]);
				}
			}
		}
	}

	public static void roundArray(int[][] x){
		for(int i = 0; i < x.length; i++){
			for(int j = 0; j < x[0].length; j++){
				x[i][j] = Math.round(x[i][j]);
				if(x[i][j] > 255){
					x[i][j] = 255;
				} else if(x[i][j] < 1){
					x[i][j] = 1;
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

	public static void quantization(int[][] x, int[][] y, int[][] q){
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				q[i][j] = (x[i][j] / y[i][j]);
			}
		}
	}

	public static ArrayList<int[][]> create8x8s(int[][] source, int N) throws ArrayIndexOutOfBoundsException, NullPointerException  {
		if (N <= 0)
			throw new ArrayIndexOutOfBoundsException("Chunks must be atleast 1x1");
		int size = source.length / N * (source[0].length / N);
		ArrayList<int [][]> subArrays = new ArrayList<>();

		for (int c = 0; c < size; c++) {
			int[][] sub = new int[N][N];
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
			DCTDriver.printArray(sub);
			System.out.println("--------------");
			System.out.println();

		}
		return subArrays;
	}
}



