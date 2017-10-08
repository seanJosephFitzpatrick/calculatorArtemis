package integrals;

/**
 * 
 * 
 * https://www.princeton.edu/
 * 
 */

import java.util.Scanner;

public class SimpsonsRule {
       public static double f (double x) {
    	return (-6*x*x+3*x);
    	}
    
     static Scanner sc = new Scanner (System.in);
     public static double integrate (double a, double b) {
     
    int N = 10000;
	// System.out.println("Enter precision parament : ");
	// int N = sc.nextInt();
	 
	 double h = (b - a)/ N;
	 
     // 1/3 terms
     double sum = 1.0 / 3.0 * (f(a) + f(b));

     // 4/3 terms
     for (int i = 1; i < N ; i += 2) {
        double x = a + h * i;
        sum += 4.0 / 3.0 * f(x);
     }

     // 2/3 terms
     for (int i = 2; i < N ; i += 2) {
        double x = a + h * i;
        sum += 2.0 / 3.0 * f(x);
     }

     return sum * h;
  }

  // sample client program
  public static void main(String[] args) { 
		System.out.println("Enter a: ");
		double a = sc.nextDouble();
		
		System.out.println("Enter b: ");
		double b = sc.nextDouble();
     System.out.println(integrate(a, b));
  }

}
