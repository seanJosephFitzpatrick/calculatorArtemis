package Equations;


import java.util.Scanner;

import ReversePolishNotation.CalcInterface;

public class LinearEquations {

	static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("Please enter a: ");
		double a = sc.nextInt();
		System.out.println("Please enter b: ");
		double b = sc.nextInt();

		caclLinear(a, b);
	}

	public static String caclLinear(double a, double b) {
		String result = "";
		double x;
		x = -b / a;
		result = Double.toString(x);
		
		result = CalcInterface.run(result, true);

		return result;

	}

}
