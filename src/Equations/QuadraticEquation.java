package Equations;

import java.util.Scanner;

import ReversePolishNotation.CalcInterface;

public class QuadraticEquation {

	static Scanner sc;

	public static void main(String[] args) throws Exception {
		sc = new Scanner(System.in);
		System.out.println("Please enter a: ");
		double a = sc.nextInt();
		System.out.println("Please enter b: ");
		double b = sc.nextInt();
		System.out.println("Please enter c: ");
		double c = sc.nextInt();	
		caclQuadratic(a, b, c);
	}
	
	public static String caclQuadratic(double a, double b, double c) throws Exception {
			if (a == 0) {
				throw new Exception();
			}
		String x0 = "";
		String y0 = "";
		String x1 = "";
		String x2 = "";
		String x = "";
		String result = "";
		double D = Math.pow(b, 2) - 4*a*c;
		if (D > 0) {
					
			x1 = CalcInterface.run("((-1 * " + b + ") + rts (" + D + "))/(2 * " + a + ")", true);	//x1 = (-b + Math.sqrt(D))/(2 * a)
			x2 = CalcInterface.run("((-1 * " + b + ") - rts (" + D + "))/(2 * " + a + ")", true);	//x2 = (-b - Math.sqrt(D))/(2 * a)
			
			y0 = CalcInterface.run("(-1 * (" + D + " / 4 * " + a + "))", true);						//y0 = -D / (4 * a)
			x0 = CalcInterface.run("(-1 * (" + b + " / 2 * " + a + "))", true);						//x0 = -(b / 2 * a)
			
		}else if (D == 0) {
			
			x = CalcInterface.run("(-1 * (" + b + " / 2 * " + a + "))", true);						//x = -(b / 2 * a)
			
		}
		else {
			System.out.println("Error!");
		}

		return result ;
		
		
		
		
	}
	
}
