package Equations;


import java.util.Scanner;

import ReversePolishNotation.CalcInterface;
import javafx.scene.AmbientLight;

public class CubicEquations {

	static Scanner sc;
	private static String x1;
	private static String x2;
	private static String x3;
	
	
	public static void main(String[] args) throws Exception {
//		sc = new Scanner(System.in);
//		System.out.println("Please enter a: ");
//		double a = sc.nextDouble();
//		System.out.println("Please enter b: ");
//		double b = sc.nextDouble();2
//		System.out.println("Please enter c: ");
//		double c = sc.nextDouble();
//		System.out.println("Please enter d: ");
//		double d = sc.nextDouble();
//		caclCubicEquation(a, b, c, d);

	}

	public static String getX1() {
		return x1;
	}


	public static void setX1(String x1) {
		CubicEquations.x1 = x1;
	}


	public static String getX2() {
		return x2;
	}


	public static void setX2(String x2) {
		CubicEquations.x2 = x2;
	}


	public static String getX3() {
		return x3;
	}


	public static void setX3(String x3) {
		CubicEquations.x3 = x3;
	}


	public static String caclCubicEquation(double a, double b, double c, double d) throws Exception {
		if (a == 0) {
			throw new Exception();
		}
		// BigDecimal aBig = new BigDecimal(a);
		// BigDecimal bBig = new BigDecimal(b);
		// BigDecimal cBig = new BigDecimal(c);
		// BigDecimal dBig = new BigDecimal(d);

		String result = "";

		// double p = (-(Math.pow(b, 2)) / (3 * Math.pow(a, 2))) + c / a;
		double p = Double.parseDouble(CalcInterface.run("(-1*(" + b + "^2)/(3*" + a + "^2))+" + c + "/" + a, true));
		System.out.println(p);
		// System.out.println(Double.parseDouble(pText));
		double q = (2 * (Math.pow(b, 3)) / (27 * Math.pow(a, 3))) - ((b * c) / (3 * Math.pow(a, 2))) + d / a;
		System.out.println(q);

		double D = (Math.pow(q, 2) / 4) + (Math.pow(p, 3) / 27) / 108;
		System.out.println(D);

		if (D < 0) {
			// double u = (-q / 2) + Math.sqrt(D);
			// double v = (-q / 2) - Math.sqrt(D);
			//
			// // double uv = Math.cbrt(u) * Math.cbrt(v);
			// double l = ((-q / 2) + D);
			// if (l == (-p / 3)) {
			double alpha;

			double x1Real;
			double x2Real;
			double x3Real;

			if (q < 0) {
				alpha = Math.atan((Math.sqrt(-D)) / (-q) * 2);
				x1Real = 2 * Math.sqrt((-p / 3)) * (Math.cos(alpha / 3)) - (b / 3 * a);
				x2Real = (2 * (Math.sqrt(-p / 3))) * (Math.cos((alpha + 2 * Math.PI) / 3)) - (b / 3 * a);
				x3Real = 2 * Math.sqrt(-p / 3) * (Math.cos((alpha + 4 * Math.PI) / 3)) - (b / 3 * a);

			} else if (q > 0) {
				alpha = Math.atan(Math.sqrt(-D) / (-q) * 2) + Math.PI;
				x1Real = Math.sqrt(-p / 3) * (Math.cos(alpha / 3)) - (b / 3 * a);
				x2Real = Math.sqrt(-p / 3) * (Math.cos((alpha + 2 * Math.PI) / 3)) - (b / 3 * a);
				x3Real = Math.sqrt(-p / 3) * (Math.cos((alpha + 4 * Math.PI) / 3)) - (b / 3 * a);

			} else {
				alpha = Math.PI / 2;

				x1Real = Math.sqrt(-p / 3) * (Math.cos(alpha / 3)) - (b / 3 * a);
				x2Real = Math.sqrt(-p / 3) * (Math.cos((alpha + 2 * Math.PI) / 3)) - (b / 3 * a);
				x3Real = Math.sqrt(-p / 3) * (Math.cos((alpha + 4 * Math.PI) / 3)) - (b / 3 * a);
			}

			x1Real = Math.round(x1Real);
			x2Real = Math.round(x2Real);
			x3Real = Math.round(x3Real);

			 x1 = Double.toString(x1Real);
			 x2 = Double.toString(x2Real);
			 x3 = Double.toString(x3Real);
			System.out.println("x1: " + x1 + " x2: " + x2 + " x3: " + x3);

		} else if (D == 0) {
			if (p == 0 & q == 0) {
				double x1Real = -(b / 3 * a);
				x1Real = Math.round(x1Real);
				 x1 = Double.toString(x1Real);
				System.out.println("x1 : " + x1);

			} else {
				double x1Real = 2 * Math.cbrt((-q / 2)) - (b / 3 * a);
				double x2Real = -1 * Math.cbrt((-q / 2)) - (b / 3 * a);

				x1Real = Math.round(x1Real);
				x2Real = Math.round(x2Real);

				 x1 = Double.toString(x1Real);
				 x2 = Double.toString(x2Real);
				System.out.println("x1: " + x1 + " x2: " + x2);
			}

		} else {
			double u = (-q / 2) + Math.sqrt(D);
			double v = (-q / 2) - Math.sqrt(D);

			double uvSum = Math.cbrt(u) + Math.cbrt(v);
			double uvSub = Math.cbrt(u) - Math.cbrt(v);

			double x1Real = uvSum - (b / 3 * a);
			double x23Real = ((-1 / 2) * uvSum) - (b / 3 * a);
			double xImag = (Math.sqrt(3) / 2) * uvSub;

			// x1Real = Math.round(x1Real);
			// x23Real = Math.round(x23Real);

			x1 = Double.toString(x1Real);
			x2 = Double.toString(x23Real) + "+ i* " + Double.toString(xImag);
			x3 = Double.toString(x23Real) + "- i* " + Double.toString(xImag);
			

			System.out.println("x1: " + x1 + " x2: " + x2 + " x3: " + x3);
		}
		return result;

		
	}
}
