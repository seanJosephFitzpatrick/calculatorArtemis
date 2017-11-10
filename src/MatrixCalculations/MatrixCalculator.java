package MatrixCalculations;

import java.text.NumberFormat;

public class MatrixCalculator {

	static int[][] testA =
		{{5, 2, 3, 1},
		{8, 2, 9, 3},
		{2, 4, 6, 8},
		{3, 5, 7, 9}};

	static int[][] testB =
		{{7, 4, 6, 2},
		{1, 5, 4, 8},
		{5, 9, 3, 1},
		{1, 6, 6, 7}};

	//MULTIPLICATION - DOUBLE
	public double[][] multiplyMatrix(double[][] A, double[][] B) {
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
	public int[][] multiplyMatrix(int[][] A, int[][] B) {
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
	public double[][] addMatrix(double[][] A, double[][] B) {
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
	public int[][] addMatrix(int[][] A, int[][] B) {
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
	public double[][] subtractMatrix(double[][] A, double[][] B) {
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
	public int[][] subtractMatrix(int[][] A, int[][] B) {
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
