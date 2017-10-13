package integrals;

/**
 * 
 * 
 * https://www.princeton.edu/
 * 
 */

import java.util.Scanner;

import ReversePolishNotation.CalcInterface;

public class SimpsonsRule {
	public static double f (double x, String function, boolean resInRadians) {
		function = function.replaceAll("x", Double.toString(x));
		return Double.parseDouble(CalcInterface.run(function, resInRadians));
	}

     static Scanner sc = new Scanner (System.in);
     public static double integrate(double a, double b, String function, boolean resInRadians) {
     
    int N = 10;
	// System.out.println("Enter precision parament : ");
	// int N = sc.nextInt();
	 
	 double h = (b - a)/ N;
	 
     // 1/3 terms
     double sum = 1.0 / 3.0 * (f(a, function, resInRadians) + f(b, function, resInRadians));

     // 4/3 terms
     for (int i = 1; i < N ; i += 2) {
        double x = a + h * i;
        sum += 4.0 / 3.0 * f(x, function, resInRadians);
     }

     // 2/3 terms
     for (int i = 2; i < N ; i += 2) {
        double x = a + h * i;
        sum += 2.0 / 3.0 * f(x, function, resInRadians);
     }

     return sum * h;
  }

//  // sample client program
//  public static void main(String[] args) { 
//		System.out.println("Enter a: ");
//		double a = sc.nextDouble();
//		
//		System.out.println("Enter b: ");
//		double b = sc.nextDouble();
//     System.out.println(integrate(a, b, function));
//  }

}
