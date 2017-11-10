package integrals;




import java.util.Scanner;
import java.math.BigDecimal;
import java.util.ArrayList;
import ReversePolishNotation.CalcInterface;
import javafx.application.Application;
import javafx.stage.Stage;


public class SimpsonsRule {
	private static ArrayList<Double> yValues = new ArrayList<Double>();
	private static ArrayList<Double> xValues = new ArrayList<Double>();
	private static String functionText;
	
	public static String getFunctionText() {
		return functionText;
	}



	public static void setFunctionText(String functionText) {
		SimpsonsRule.functionText = functionText;
	}



	public static double f (double x, String function, boolean resInRadians) {
		
		function = function.replaceAll("x", Double.toString(x));
		
		double yValue =	Double.parseDouble(CalcInterface.run(function, resInRadians));
		
		return yValue;
	}
	
	
	
	public static void main(String[] args){
		
		
	}

     static Scanner sc = new Scanner (System.in);
     public static double integrate(double a, double b, String function, boolean resInRadians) throws Exception {
     
   
    	 SimpsonsRule.addPlotPoints(function,b, a);
    	 
    	 
    	 int N = 100;
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
     
     
     IntegralPlotter.setIntegralPointsX(xValues);
     IntegralPlotter.setIntegralPointsY(yValues);
     Application app2 =  new IntegralPlotter(); 
     Stage anotherStage = new Stage();
     app2.start(anotherStage);
     
     System.out.println(xValues);
     System.out.println(yValues);

     
     return sum * h;
  }
     public static void addPlotPoints(String function,double a,double b){
    	IntegralPlotter.getIntegralPointsX().clear();
    	IntegralPlotter.getIntegralPointsY().clear();
    	 BigDecimal aBig = new BigDecimal(a);
    	 BigDecimal bBig = new BigDecimal(b);
    	 BigDecimal diff = new BigDecimal(b-a);
    	 
    	 for(;(aBig.compareTo(bBig)!=1);aBig=aBig.add(diff.multiply(new BigDecimal(0.005)))){
    		
    		
    		 String a1=String.format("%f", aBig.doubleValue());
    		 String function1 = function.replaceAll("x", a1);
    		 String result=CalcInterface.run(function1, false);
    		 result= String.format("%f", Double.parseDouble(result));
    		 xValues.add(aBig.doubleValue());
    		 yValues.add(Double.parseDouble(result));
    	 }
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
