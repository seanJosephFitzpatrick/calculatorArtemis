package Equations;

import java.util.Scanner;

import ReversePolishNotation.CalcInterface;

public class QuadraticEquation {

	static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("Please enter a: ");
		double a = sc.nextInt();
		System.out.println("Please enter b: ");
		double b = sc.nextInt();
		System.out.println("Please enter c: ");
		double c = sc.nextInt();	
		caclQuadratic(a, b, c);
	}
	
	public static String caclQuadratic(double a, double b, double c) {
		String result = "";
		double D = Math.pow(b, 2) - 4*a*c;
		if (D > 0) {
			
			double x1 = (-b + Math.sqrt(D))/(2 * a);
			double x2 = (-b - Math.sqrt(D))/(2 * a);
			result = "x1 = " + Double.toString(x1) + "  x2 = " + Double.toString(x2);
		}else if (D == 0) {
			double x = -(b / 2 * a);
			result = Double.toString(x);
		}
		else {
			System.out.println("Error!");
		}
		result = CalcInterface.run(result, true);
		
		return result ;
		
		
		
		
	}
	
}
