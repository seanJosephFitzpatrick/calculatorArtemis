package MatrixTest;

import static org.junit.Assert.*;

import java.lang.reflect.Array;

import org.junit.Test;

public class MatrixCalculatorTest {
	public int[][] testA =
		{{5, 2, 3, 1},
				{8, 2, 9, 3},
				{2, 4, 6, 8},
				{3, 5, 7, 9}};

	public int[][] testB =
		{{7, 4, 6, 2},
				{1, 5, 4, 8},
				{5, 9, 3, 1},
				{1, 6, 6, 7}};
	
	
	@Test
	public void testAddTwoMatrices() {
		int[][] resultArray = {{12,	6,	9,	3},	
			{9,	7,	13,	11},	
			{7,	13,	9,	9},	
			{4,	11,	13,	16}};
		assertArrayEquals(resultArray, MatrixCalculations.MatrixCalculator.addMatrix(testA, testB));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddTwoMatricesLessRows() {
		int[][] array = {	
			{9,	7,	13,	11},	
			{7,	13,	9,	9},	
			{4,	11,	13,	16}};
		MatrixCalculations.MatrixCalculator.addMatrix(array, testB);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddTwoMatricesLessColumns() {
		int[][] array = {{12,	6,	9},	
				{9,	7,	13},	
				{7,	13,	9,	9},	
				{4,	11,	13,	16}};
		MatrixCalculations.MatrixCalculator.addMatrix(array, testB);
	}
	
	@Test
	public void testSubtractTwoMatrices() {
		int[][] resultArray = {{-2,	-2,	-3,	-1},	
				{7,	-3,	5,	-5},	
				{-3,	-5,	3,	7},	
				{2,	-1,	1,	2	}};
		assertArrayEquals(resultArray, MatrixCalculations.MatrixCalculator.subtractMatrix(testA, testB));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSubtractTwoMatricesLessRows() {
		int[][] array = {	
			{9,	7,	13,	11},	
			{7,	13,	9,	9},	
			{4,	11,	13,	16}};
		MatrixCalculations.MatrixCalculator.subtractMatrix(array, testB);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSubtractTwoMatricesLessColumns() {
		int[][] array = {{12,	6,	9},	
				{9,	7,	13},	
				{7,	13,	9,	9},	
				{4,	11,	13,	16}};
		MatrixCalculations.MatrixCalculator.subtractMatrix(array, testB);
	}
	
	@Test
	public void testMultiplyTwoMatrices() {
		int[][] resultArray = {{53,	63,	53,	36},	
			{106,	141,	101,	62},	
			{56,	130,	94,	98},	
			{70,	154,	113,	116	}};
		assertArrayEquals(resultArray, MatrixCalculations.MatrixCalculator.multiplyMatrix(testA, testB));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMultiplyTwoMatricesRowsNotMatchingColumns() {
		int[][] array = {{12,	6,	9},	
				{9,	7,	13},	
				{7,	13,	9,	9},	
				{4,	11,	13,	16}};
		MatrixCalculations.MatrixCalculator.multiplyMatrix(array, testB);
	}
	
	@Test
	public void testGenerateMatrixReturnsArray() {
		int[][] resultArray = MatrixCalculations.MatrixCalculator.GenerateNumbers();
		assertNotNull(resultArray);
	}	

}
