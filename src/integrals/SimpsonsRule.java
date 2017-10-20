package integrals;

/**
 * 
 * 
 * https://www.princeton.edu/
 * 
 */

import java.util.Scanner;
import java.util.ArrayList;
import ReversePolishNotation.CalcInterface;
import javafx.application.Application;


public class SimpsonsRule {
	private static ArrayList<Double> yValues = new ArrayList<Double>();
	private static ArrayList<Double> xValues = new ArrayList<Double>();
	
	public static double f (double x, String function, boolean resInRadians) {
		xValues.add(x);
		function = function.replaceAll("x", Double.toString(x));
		
		double yValue =	Double.parseDouble(CalcInterface.run(function, resInRadians));
		yValues.add(yValue);
		return yValue;
	}
	
	
	
	public static void main(String[] args){
		double a = 3d;
		double b = 5d;
		String function = "-6*x";
		
		System.out.println(integrate(a,b,function,true));
		
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
     System.out.println(sum*h);
     
     IntegralPlotter.setIntegralPointsX(xValues);
     IntegralPlotter.setIntegralPointsY(yValues);
     Application.launch(IntegralPlotter.class);
     
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
