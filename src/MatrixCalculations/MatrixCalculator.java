package MatrixCalculations;

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

	public static void main(String[] args) {
		MatrixCalculator m = new MatrixCalculator();
		m.multiplyMatrix(testA, testB);
	}
}
