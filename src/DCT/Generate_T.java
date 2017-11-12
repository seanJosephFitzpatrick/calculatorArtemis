package DCT;


import java.text.DecimalFormat;

public class Generate_T {
	static int N = 8;
	static double n = 8.0;
	public static double[][] T = new double[N][N];
	public static double[][] Tt = new double[N][N];
	static DecimalFormat df = new DecimalFormat("###0.000");

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

	public static void PrintMatrix(double[][] matrix) {
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				System.out.print(df.format(matrix[r][c]) + " ");
			}
			System.out.println();
		}
	}
}
