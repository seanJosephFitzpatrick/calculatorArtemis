package CombinationsAndProbability;

import java.util.Scanner;

import ReversePolishNotation.CalcInterface;

public class Combinations {

	static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("Enter your number of objects: ");
        int objects = sc.nextInt();
        System.out.println("Enter your number of samples: ");
        int samples = sc.nextInt();
        
        calcCombinations(objects, samples);
               
	}
	
	
	public static String calcCombinations(int objects, int samples) {
		int diff = (objects - samples);
        
        if(objects < samples) {
        	throw new IllegalArgumentException();
        }
        
        String objectsFactorial = Factorial.factorial(objects);  
        String samplesFactorial = Factorial.factorial(samples); 
        String diffFactorial = Factorial.factorial(diff); 
        
        String expression = (objectsFactorial + " / ( " + samplesFactorial + " * " + diffFactorial + " ) ");
        String result = CalcInterface.run(expression, true);
        System.out.println("Combinations: " + result);  
        return result;
	}
		
}


