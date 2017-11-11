package MatrixCalculations;

import java.text.NumberFormat;
import java.util.Random;

public class MatrixCalculator {

	public static int[][] testA =
		{{5, 2, 3, 1},
		{8, 2, 9, 3},
		{2, 4, 6, 8},
		{3, 5, 7, 9}};

	public static int[][] testB =
		{{7, 4, 6, 2},
		{1, 5, 4, 8},
		{5, 9, 3, 1},
		{1, 6, 6, 7}};

	
	public static int[][] GenerateNumbers() {
		int[][] temp = new int[4][4];
		Random randomGenerator = new Random();
	    for (int r = 0; r < 4; r++)
	      for (int c = 0; c < 4; c++)
	      {
	        temp[r][c] = randomGenerator.nextInt(100);
	      }
	    return temp;
	  }

	
	
	//MULTIPLICATION - DOUBLE
	public static double[][] multiplyMatrix(double[][] A, double[][] B) {
		int aRows = A.length;
		int aColumns = A[0].length;
		int bRows = B.length;
		int bColumns = B[0].length;

		double[][] C = new double[aRows][bColumns];

		if (aColumns != bRows) {
			throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
		}

		for (int r = 0; r < aRows; r++) {
			for (int c = 0; c < bColumns; c++) {
				C[r][c] = 0.0;
			}
		}

		for (int i = 0; i < aRows; i++) {
			for (int j = 0; j < bColumns; j++) {
				for (int k = 0; k < aColumns; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		return C;
	}

	//MULTIPLICATION - INT
	public static int[][] multiplyMatrix(int[][] A, int[][] B) {
		int aRows = A.length;
		int aColumns = A[0].length;
		int bRows = B.length;
		int bColumns = B[0].length;

		int[][] C = new int[aRows][bColumns];

		if (aColumns != bRows) {
			throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
		}

		for (int r = 0; r < aRows; r++) {
			for (int c = 0; c < bColumns; c++) {
				C[r][c] = 0;
			}
		}

		for (int i = 0; i < aRows; i++) {
			for (int j = 0; j < bColumns; j++) {
				for (int k = 0; k < aColumns; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		return C;
	}

	//ADDITION - DOUBLE
	public static double[][] addMatrix(double[][] A, double[][] B) {
		int aRows = A.length;
		int aColumns = A[0].length;
		int bRows = B.length;
		int bColumns = B[0].length;

		double[][] C = new double[aRows][bColumns];

		if (aRows != bRows) {
			throw new IllegalArgumentException("Rows not equal size");
		}
		if (aColumns != bColumns) {
			throw new IllegalArgumentException("Columns not equal size");
		}

		for (int r = 0; r < aRows; r++) {
			for (int c = 0; c < bColumns; c++) {
				C[r][c] = 0;
			}
		}

		for (int r = 0; r < aRows; r++) {
			for (int c = 0; c < bColumns; c++) {
				C[r][c] = A[r][c] + B[r][c];
			}
		}
		return C;
	}

	//ADDITION - INT
	public static int[][] addMatrix(int[][] A, int[][] B) {
		int aRows = A.length;
		int aColumns = A[0].length;
		int bRows = B.length;
		int bColumns = B[0].length;

		int[][] C = new int[aRows][bColumns];

		if (aRows != bRows) {
			throw new IllegalArgumentException("Rows not equal size");
		}
		if (aColumns != bColumns) {
			throw new IllegalArgumentException("Columns not equal size");
		}

		for (int r = 0; r < aRows; r++) {
			for (int c = 0; c < bColumns; c++) {
				C[r][c] = 0;
			}
		}

		for (int r = 0; r < aRows; r++) {
			for (int c = 0; c < bColumns; c++) {
				C[r][c] = A[r][c] + B[r][c];
			}
		}
		return C;
	}

	//SUBTRACTION - DOUBLE
	public static double[][] subtractMatrix(double[][] A, double[][] B) {
		int aRows = A.length;
		int aColumns = A[0].length;
		int bRows = B.length;
		int bColumns = B[0].length;

		double[][] C = new double[aRows][bColumns];

		if (aRows != bRows) {
			throw new IllegalArgumentException("Rows not equal size");
		}
		if (aColumns != bColumns) {
			throw new IllegalArgumentException("Columns not equal size");
		}

		for (int r = 0; r < aRows; r++) {
			for (int c = 0; c < bColumns; c++) {
				C[r][c] = 0;
			}
		}

		for (int r = 0; r < aRows; r++) {
			for (int c = 0; c < bColumns; c++) {
				C[r][c] = A[r][c] - B[r][c];
			}
		}

		return C;
	}

	//SUBTRACTION - INT
	public static int[][] subtractMatrix(int[][] A, int[][] B) {
		int aRows = A.length;
		int aColumns = A[0].length;
		int bRows = B.length;
		int bColumns = B[0].length;

		int[][] C = new int[aRows][bColumns];

		if (aRows != bRows) {
			throw new IllegalArgumentException("Rows not equal size");
		}
		if (aColumns != bColumns) {
			throw new IllegalArgumentException("Columns not equal size");
		}

		for (int r = 0; r < aRows; r++) {
			for (int c = 0; c < bColumns; c++) {
				C[r][c] = 0;
			}
		}

		for (int r = 0; r < aRows; r++) {
			for (int c = 0; c < bColumns; c++) {
				C[r][c] = A[r][c] - B[r][c];
			}
		}
		return C;
	}

	public static void printArray(int[][] toPrint){
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(3);
		for(int i = 0; i < toPrint.length; i++){
			for(int j = 0; j < toPrint[0].length; j++){
				System.out.print(nf.format(toPrint[i][j]) + "\t");
			}
			System.out.println();
		}
	}
}
