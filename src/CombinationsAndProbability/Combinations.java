package CombinationsAndProbability;

import java.util.Scanner;

public class Combinations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your number of objects: ");
        int objects = sc.nextInt();
        System.out.println("Enter your number of samples: ");
        int samples = sc.nextInt();
        
        int diff = (objects - samples);
        
        if(objects < samples) {
        	sc.close();
        	throw new IllegalArgumentException();
        }
        
        String objectsFactorial = Factorial.factorial(objects);  
        String samplesFactorial = Factorial.factorial(samples); 
        String diffFactorial = Factorial.factorial(diff); 
        
        String expression = (objectsFactorial + " / ( " + samplesFactorial + " * " + diffFactorial + " ) ");
        System.out.println(expression);
        sc.close();       
	}

}
